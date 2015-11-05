package messy.tets;

import messy.tetscore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class bworkb extends BlockContainer {

	public bworkb(){

		super(Material.iron);
		setCreativeTab(tetscore.tet);

	}

	   @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	        player.openGui(tetscore.instance, tetscore.gwid, world, x, y, z);
	        return true;
	    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new wotil();
	}

}
