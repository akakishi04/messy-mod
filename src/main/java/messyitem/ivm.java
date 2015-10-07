package messyitem;

import cpw.mods.fml.common.Loader;
import jp.plusplus.fbs.api.FBSEntityPropertiesAPI;
import jp.plusplus.fbs.exprop.FBSEntityProperties;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ivm extends ItemFood {

	public ivm() {
		super(3,0.1F,true);
		setCreativeTab(CreativeTabs.tabFood);
		setTextureName("tete:villager'smeat");
		setUnlocalizedName("villager's meat");

	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
	 	if(Loader.isModLoaded("The Forbidden Knowledge")==true){
	 	FBSEntityPropertiesAPI.LoseSanity(p_77654_3_, 1, 2, true);
	 	}
        return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
    }
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer player) {
    	if(Loader.isModLoaded("The Forbidden Knowledge")==true){
        FBSEntityProperties prop=FBSEntityProperties.get(player);
        if(prop!=null && prop.getSanity()>0) {
        	player.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }
    	}else{
    	player.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));}
        return p_77659_1_;
    }
	
	
	
}
