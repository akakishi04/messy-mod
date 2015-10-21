package messy.messyblock;

import messy.tetscore;
import messy.tets.dtil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class blockcross extends BlockContainer {

	public blockcross() {
		super(Material.wood);
		setCreativeTab(tetscore.tet);
		setBlockBounds(0f, 0f, 0f, 1f, 2.1f, 1f);

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
				return new dtil();
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){




		if(world.isAirBlock(x, y, z)==true &&world.isAirBlock(x, y+1, z)==true ){

			return true;

		}else{
			return false;
		}

	}
	{

	}

	@Override
	public int getRenderType(){
		return tetscore.blockcrossr;
	}
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/*@Override
	 public void onBlockAdded(World world, int x, int y, int z)
    {
		world.setBlock(x, y+1, z,null );

        super.onBlockAdded(world, x, y, z);
    }
	*/



}
