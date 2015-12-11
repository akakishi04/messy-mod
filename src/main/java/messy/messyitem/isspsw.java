package messy.messyitem;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.plusplus.fbs.AchievementRegistry;
import jp.plusplus.fbs.exprop.SanityManager;
import jp.plusplus.fbs.spirit.ISpiritTool;
import jp.plusplus.fbs.spirit.SpiritManager;
import jp.plusplus.fbs.spirit.SpiritStatus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class isspsw extends vilswep implements ISpiritTool {
	
	
	public isspsw() {
	//	setCreativeTab(tetscore.tet);
		setMaxStackSize(1);
		setTextureName("aa");
		
	}
	
	@Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player) {
        if(player instanceof EntityPlayer){
            SpiritStatus ss=SpiritStatus.readFromNBT(itemStack.getTagCompound());

            int dur=calcDurable(ss);
            ss.addItemDamage(1);
            if(ss.getItemDamage()>dur){
                ss.setItemDamage(dur);
            }
            if(ss.getItemDamage()==dur){
                ((EntityPlayer) player).triggerAchievement(AchievementRegistry.evil);
            }
            if(ss.getItemDamage()<dur && ss.isOwner((EntityPlayer)player) && ss.addExp(1)){
                SpiritManager.talk((EntityPlayer)player, ss.getCharacter(), "lvup", itemStack);
                SanityManager.setSpiritLevel((EntityPlayer)player, ss.getLv());

                if(!((EntityPlayer) player).worldObj.isRemote && ss.getLv()==50) ((EntityPlayer) player).triggerAchievement(AchievementRegistry.best);
            }
            SpiritManager.updateNBT(itemStack, ss);
        }
        return true;
    }
	
	 @Override
	    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	        if(player.isSneaking()){
	            SpiritStatus status=SpiritStatus.readFromNBT(itemStack.getTagCompound());
	            if(status.getOwnerName().equals(player.getDisplayName())){
	                SpiritManager.openGui(player);
	            }
	        }
	        else{
	            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
	        }

	        return itemStack;
	    }
	 
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
	        SpiritManager.addInformation(itemStack, player, list, flag);
	    }
	 
	 @Override
	    public String getItemStackDisplayName(ItemStack p_77653_1_) {
	        return SpiritManager.getSpiritDisplayName(p_77653_1_);
	    }
	 
	 @Override
	    public boolean isDamaged(ItemStack stack) {
	        return SpiritStatus.readFromNBT(stack.getTagCompound()).getItemDamage()>0;
	    }
	 
	 @Override
	    public boolean isItemTool(ItemStack p_77616_1_) {
	        return true;
	    }
	
	@Override
	public float calcDamage(SpiritStatus ss) {
	        if(ss.getItemDamage()>=calcDurable(ss)) return 0.5f;
	        return 3.5f+ss.getMaxDamage()*ss.calcRatio(ss.getStrength());
	    
	}

	@Override
	public int calcDigLv(SpiritStatus ss) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int calcDurable(SpiritStatus ss) {
		// TODO 自動生成されたメソッド・スタブ
		return 1000+(int)(ss.getMaxDurability()*ss.calcRatio(ss.getToughness()));
	}

	@Override
	public void calcInitialValue(SpiritStatus ss, ItemStack material) {
	
	if(material.getItem() instanceof vilswep){
   
    int i=0,n=0;
    
    vilswep vis=(vilswep) material.getItem();
    
    i=5+vis.gvs(material);
    n=vis.gvs(material)*2;
    
    float maxDamage=i*1000;


    float maxDurabity=n*100*100;

    ss.setMaxStatus(maxDamage, 0, maxDurabity);
    ss.addStrength(MathHelper.ceiling_float_int(i / (ss.getMaxDamage() / 255.f)));
    ss.addToughness(MathHelper.ceiling_float_int(5000/(ss.getMaxDurability()/255.f)));// TODO 自動生成されたメソッド・スタブ
		
	}
	
	}

}
