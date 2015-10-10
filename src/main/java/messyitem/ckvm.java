package messyitem;

import net.minecraft.item.ItemFood;
import tets.tetscore;

public class ckvm extends ItemFood{

	public ckvm() {
		super(7,0.5F,true);
		setTextureName("tete:cookedvillager'smeat");
		setUnlocalizedName("cookedvillager'smeat");
		setCreativeTab(tetscore.tet);
	}

}
