package messy.messyitem;

import messy.tetscore;
import net.minecraft.item.ItemFood;


public class bakedbed extends ItemFood {

	public bakedbed(){
		
		super(8,0.4F,false);
		setTextureName("tete:bakedbed");
		setUnlocalizedName("bakedbed");
		setCreativeTab(tetscore.tet);
		
	}
	
}
