package messy.messyitem;

import messy.tetscore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class bedstick extends ItemPickaxe {


	public bedstick(){
		super(tetscore.ttrte);
		
		setCreativeTab(tetscore.tet);
	}

	
	@Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if(p_77648_3_.getBlock(x, y, z)!=Blocks.bedrock){
			
		
			
			}
		
        return true;

    }
	@Override
	public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player) {
		
		
		
		return iStack;
		
		
		
	
	}

	
}
