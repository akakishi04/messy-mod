package messy.messyblock;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.tets.register;
import messy.tets.vimitil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class bsmin extends BlockContainer {

	public bsmin() {
		super(Material.iron);
		setCreativeTab(tetscore.tet);
		setTickRandomly(true);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new vimitil();

	}
	


	@Override
	 public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	 public void randomDisplayTick(World world, int x, int y, int z, Random random){
		
		TileEntity tile=world.getTileEntity(x, y, z);
		
		if(tile != null && tile instanceof vimitil){
			
			vimitil vim=(vimitil)tile;
			
			if(vim.getvillager()!=null && vim.getruntime()>5 && random.nextInt(2)==0){
				
				double d1=x+random.nextFloat();
				double d2=y+2.0;
				double d3=z+random.nextFloat();
				
				world.spawnParticle("lava", d1, d2, d3, 0, 0, 0);
				
			}
			
		}
		double d4 =x+random.nextFloat();
		double d5=y-1.05;
		double d6=z+random.nextFloat();
		
		if(world.getBlock(x, y-1, z)==register.vilmin){
			
			world.spawnParticle("dripLava", d4, d5, d6, 0.0D, 0.0D, 0.0D);
			
		}
		
	}
	
}
