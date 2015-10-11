package messy.messyitem;

import messy.tetscore;
import messy.tets.achire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ckvm extends ItemFood{

	public ckvm() {
		super(7,0.5F,true);
		setTextureName("tete:cookedvillager'smeat");
		setUnlocalizedName("cookedvillager'smeat");
		setCreativeTab(tetscore.tet);
	}
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player){
		
		player.addStat(achire.villagereater, 1);
		
		return super.onEaten(itemStack, world, player);
	}

}
