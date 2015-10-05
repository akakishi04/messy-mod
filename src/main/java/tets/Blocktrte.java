package tets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class Blocktrte extends Block {
	
	private IIcon[] iicons=new IIcon[16];
	
	public Blocktrte(){
		super(Material.glass);
		setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(15);
		setHardness(7.5F);
		setHarvestLevel("pickaxe", 2);
		setBlockTextureName("tete:tra-0");
	}
	
 
	
	 @Override
	    public int getRenderBlockPass()
	    {
	        return 1;
	    }
	 @Override
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
}
