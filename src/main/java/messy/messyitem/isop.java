package messy.messyitem;

import messy.tetscore;
import messy.tets.EnPro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class isop extends ItemFood {

	public isop(){
		super(0,0,false);
		setCreativeTab(tetscore.tet);
		setAlwaysEdible();
	}
	
	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer player) {
	 	EnPro ep=EnPro.get(player);
	 	if(ep.getAcount()==0){
	 	ep.setAcount(p_77654_2_.rand.nextInt(1000));
	 	}
	 	ep.setpomil(true);
	 	
        return super.onEaten(p_77654_1_, p_77654_2_, player);
    }
			
	 public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer player) {
		 EnPro ep=EnPro.get(player);
		 	if(ep.getAcount()==0){
		 	ep.setAcount(p_77659_2_.rand.nextInt(1000));
		 	}
		 	ep.setpomil(true);
		 	

	        return p_77659_1_;
	    }	
	
}
