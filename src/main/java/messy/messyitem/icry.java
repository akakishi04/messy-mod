package messy.messyitem;

import java.util.List;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.tets.achire;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class icry extends Item{

	public icry(){
		
		setTextureName("tete:endercrystal");
		setCreativeTab(tetscore.tet);
		maxStackSize=1;
	}

	@Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {


		if(!p_77648_3_.isRemote){
		p_77648_3_.spawnEntityInWorld(new EntityEnderCrystal(p_77648_3_,x+0.5,y+2,z+0.5));
		p_77648_1_.damageItem(1, p_77648_2_);
		}
		if(!Loader.isModLoaded("jp-plusplus-fbs")){
			p_77648_2_.addStat(achire.Haid, 1);
		}

        return true;

    }
	 @Override
	    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {

	        p_77659_3_.swingItem();
	        return p_77659_1_;

	    }

	 @Override
	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
	        list.add("これはエンダークリスタルそのものではない");
	 }
}
