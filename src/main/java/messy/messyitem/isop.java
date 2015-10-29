package messy.messyitem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.plusplus.fbs.exprop.FBSEntityProperties;
import messy.tetscore;
import messy.tets.EnPro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class isop extends ItemFood {

	public isop(){
		super(0,0,false);
		setCreativeTab(tetscore.tet);
		setAlwaysEdible();
		setTextureName("tete:sop");

	
	}
	
	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer player) {
	 	EnPro ep=EnPro.get(player);
	 	FBSEntityProperties fep=FBSEntityProperties.get(player);
	 	if(!p_77654_2_.isRemote){
	 	if(ep.getAcount()==0){
	 	ep.setAcount(p_77654_2_.rand.nextInt(1000)+20*60*20*5);
	 	}
	 	player.addPotionEffect(new PotionEffect(Potion.hunger.id, 20*60*20*5, 1));
	 	player.addPotionEffect(new PotionEffect(Potion.poison.id, 20*60*20*5, 2));
	 	player.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*30, 3));
	 	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*30, 3));
	 	int mglv =fep.getMagicLevel();
	 	fep.setMagicLevel(1);
	 	if(fep.getMaxSanity()!=99){
	 		 player.addChatComponentMessage(new ChatComponentText("It becomes only to poison It 's failure poor"));
	 	}
	 		
	 	fep.setSanity(99);
	 	fep.setMagicLevel(mglv);
	 	ep.setpomil(true);
	 	 player.addChatComponentMessage(new ChatComponentText(String.valueOf(fep.getSanity())));
	 	}
        return super.onEaten(p_77654_1_, p_77654_2_, player);
    }
			
	 public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer player) {
		 player.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
		 	
		 	

	        return p_77659_1_;
	    }	

	 @Override
		@SideOnly(Side.CLIENT)

		public boolean hasEffect(ItemStack par1ItemStack) {
			return true;
		}
	 
 
}
