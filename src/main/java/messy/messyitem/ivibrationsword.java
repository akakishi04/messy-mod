package messy.messyitem;

import messy.tetscore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ivibrationsword extends ItemSword {
	
	public ivibrationsword(){
		
		super(ToolMaterial.EMERALD);
		setCreativeTab(tetscore.tet);
		
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.openGui(tetscore.instance, tetscore.gvibid, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return itemStack;
    }
	
}
