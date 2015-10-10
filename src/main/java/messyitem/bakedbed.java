package messyitem;

import net.minecraft.item.ItemFood;
import tets.tetscore;


public class bakedbed extends ItemFood {

	public bakedbed(){
		
		super(8,0.4F,false);
		setTextureName("tete:bakedbed");
		setUnlocalizedName("bakedbed");
		setCreativeTab(tetscore.tet);
		
	}
	
}
