package messy.messyitem;

import messy.tetscore;
import mods.defeatedcrow.api.edibles.EdibleItem;
import net.minecraft.item.ItemStack;

public class bloodtea extends EdibleItem{
	
	public bloodtea(){
		
		super();
		setCreativeTab(tetscore.tet);
		
	}
	
	@Override
	public ItemStack getReturnContainer(int meta) {

		return null;
	}
	
}
