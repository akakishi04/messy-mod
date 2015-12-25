package messy.messyblock;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class bdr extends Block {
	
	@SideOnly(Side.CLIENT)
	public IIcon[]icot=new IIcon[10];
	
	
	
	
	
	public bdr() {
		super(Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		//setCreativeTab(tetscore.tet);
		setTickRandomly(true);
		setLightLevel(0.3F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
	
	
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void  registerBlockIcons(IIconRegister par1IconRegister){
		for(int i=0;i<10;i++)
		icot[i]=par1IconRegister.registerIcon("tete:dep_"+String.valueOf(i));
		
	}
	
	@Override
	public IIcon getIcon(int par1, int par2){
		
		return icot[par2];
		
	}
	
	@Override
	public int getRenderType()
    {
        return tetscore.dragone;
    }

	@Override
	@SideOnly(Side.CLIENT)
	 public void randomDisplayTick(World world, int x, int y, int z, Random random){
		

			world.spawnParticle("portal", x+random.nextFloat(), 0, z+random.nextFloat(),  random.nextFloat(), random.nextFloat(), random.nextFloat());

		
	}
	
	

}
