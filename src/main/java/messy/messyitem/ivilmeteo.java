package messy.messyitem;

import messy.tetscore;
import messy.tets.achire;
import messy.tets.villagemeteor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ivilmeteo extends Item {

	public ivilmeteo(){

		setCreativeTab(tetscore.tet);
		setTextureName("tete:vilmete");
		setUnlocalizedName("mvilmete");
		setMaxDamage(10);
		setMaxStackSize(1);
	}

	@Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {


		if(!world.isRemote){
			p_77648_2_.addStat(achire.villagerfall, 1);
			p_77648_1_.damageItem(1, p_77648_2_);
			villagemeteor.villmete(world,x,y,z, p_77648_2_);

		}
		


        return true;

    }

	 @Override
	    public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer p_77659_3_) {

			p_77659_3_.swingProgressInt=20;
	
	        return p_77659_1_;

	    }
}
