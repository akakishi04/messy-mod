package tets;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class blockcross extends BlockContainer {

	protected blockcross() {
		super(Material.wood);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockBounds(0f, 0f, 0f, 1f, 4f, 1f);
		
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
				return new dtil();
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		
		
		
		
		if(world.isAirBlock(x, y, z)==true &&world.isAirBlock(x, y+1, z)==true && world.isAirBlock(x, y+2, z)==true &&
			world.isAirBlock(x-1, y+2, z)==true){
			
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
