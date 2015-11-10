package messy.messyitem;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import messy.tetscore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class vilswep extends ItemSword {

	private static ToolMaterial ee=EnumHelper.addToolMaterial("ee", 0, 50000, 1, 1, 30);
	private final float damage;
	public vilswep() {
		super(ee);
		damage=5;
		setCreativeTab(tetscore.tet);
		setMaxDamage(-1);
		setMaxStackSize(1);
		setUnlocalizedName("Death candle supervise sword");
		
		
	}

	@Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
       
        NBTTagCompound nbt = new NBTTagCompound();
      
            nbt.setInteger("vilsol", 0);
            itemStack.setTagCompound(nbt);
        
        itemStack.setTagCompound(nbt);//ItemStackにNBTTagCompoundを格納
    }
	
	@Override
	    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHeld) {
		  NBTTagCompound nbt = itemStack.stackTagCompound == null ? new NBTTagCompound():itemStack.stackTagCompound;
		  		if(nbt.getTag("vilsol") != null){
		  			if(nbt.getInteger("vilsol")>=0){
		  		nbt.setInteger("vilsol", nbt.getInteger("vilsol"));
		  		}else if(nbt.getInteger("vilsol")<0){
		  			nbt.setInteger("vilsol",0);
		  		}
		  
		  		
		  		
		  		}else {
		  			nbt.setInteger("vilsol",0);
				}
	            itemStack.setTagCompound(nbt);
		
	        
	 
	    }
	  @Override
	  public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
		  
		  NBTTagCompound nbt = itemStack.getTagCompound();
		  if(nbt!=null){
		  list.add(String.valueOf(nbt.getInteger("vilsol")));
		  }
	  }
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		
		if(entity instanceof EntityVillager && !player.worldObj.isRemote){
			NBTTagCompound nbt=stack.stackTagCompound;

		
			entity.worldObj.setBlock((int)entity.posX-1, (int)entity.posY, (int)entity.posZ,tetscore.cross);
			entity.setDead();
			nbt.setInteger("vilsol", nbt.getInteger("vilsol")+1);
			stack.setTagCompound(nbt);
			
			return false;
		}else{
			
			return false;
		}
		
        
    }
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", this.damage+gvs(stack), 0));
		return multimap;
	}
	
	public int gvs(ItemStack itemStack){
		
		NBTTagCompound nbt =itemStack.stackTagCompound;
		if(nbt!=null && nbt.getTag("vilsol")!=null){
			return nbt.getInteger("vilsol");
		}
		return 0;
	}
	@Override
	public boolean isItemTool(ItemStack p_77616_1_)
    {
        return true;
    }
	
}
