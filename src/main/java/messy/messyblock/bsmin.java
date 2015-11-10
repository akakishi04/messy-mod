package messy.messyblock;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.messyitem.vilswep;
import messy.tets.register;
import messy.tets.vimitil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class bsmin extends BlockContainer {

	@SideOnly(Side.CLIENT)
	public IIcon icont;
	@SideOnly(Side.CLIENT)
	public IIcon[] icons;
	@SideOnly(Side.CLIENT)
	public IIcon iconb;
	
	
	public bsmin() {
		super(Material.iron);
		setCreativeTab(tetscore.tet);
		setBlockName("supermincer");
		setTickRandomly(true);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new vimitil();

	}
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void  registerBlockIcons(IIconRegister par1IconRegister){
		
		String md="tete:vm_";
		icons=new IIcon[4];
		
		icons[0]=par1IconRegister.registerIcon(md+"s");
		icons[1]=par1IconRegister.registerIcon(md+"st");
		icons[2]=par1IconRegister.registerIcon(md+"sm");
		icons[3]=par1IconRegister.registerIcon(md+"sd");
		icont=par1IconRegister.registerIcon(md+"t");
		iconb=par1IconRegister.registerIcon(md+"b");
		
	}
	
	@Override
	public IIcon getIcon(int par1, int par2){
		
		if(par1==1){
			return icont;
			
		}else if(par1==0){
			return iconb;
			
		}else {
			return icons[par2];
		}
		
	}
	

 

	

	@Override
	 public boolean isOpaqueCube()
    {
        return false;
    }
	
	 @Override
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		 
		  if(!world.isRemote && world.getTileEntity(x, y, z) instanceof vimitil){
			  vimitil vim =(vimitil) world.getTileEntity(x, y, z);
			  if(player.inventory.getCurrentItem()!=null){
				  if(player.inventory.getCurrentItem().getItem() instanceof vilswep ){
				  
				  
					  if(vim.getvilso() == null){
					  
						  vim.setvilso(player.inventory.getCurrentItem());
						  player.inventory.setInventorySlotContents(player.inventory.currentItem, null);;
						  vim.setfli(1);
					  }
				  } else{
					  
					  
					  
				  }
			  }else if(player.inventory.getCurrentItem()==null){
				  
				  if(vim.getvilso() !=null){
					  
					  player.inventory.setInventorySlotContents(player.inventory.currentItem,vim.getvilso());
					  
					  vim.setvilso(null);
					  vim.setfli(0);
				  }else{
					  
					 // player.addChatComponentMessage(new ChatComponentText("test"+String.valueOf(vim.getfli())));
					  
				  }
				  
			  }
			  
		  }
		   
	        return false;
	    }
	 
	 public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int meta) {
	       if(world.getTileEntity(x, y, z) instanceof vimitil){
	    	   vimitil tile=(vimitil) world.getTileEntity(x, y, z);
	    	   if(tile.getvilso()!=null){
	    		   EntityItem ei= new EntityItem(world, x, y, z, tile.getvilso());
	    		   
	    		   world.spawnEntityInWorld(ei);
	    	   }
	    	   
	    	   world.removeTileEntity(x, y, z);
	    	   
	       }
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
		
		if(world.getBlock(x, y-1, z)!=register.vilmin && world.getBlock(x, y+1, z)!=register.vilmin){
			
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
			
		}
		
		if(world.getBlock(x, y+1, z)==register.vilmin){
			
			world.setBlockMetadataWithNotify(x, y, z, 3, 3);
			
		}
		
		if(world.getBlock(x, y-1, z)==register.vilmin){
			
			world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			
		}
		
		if(world.getBlock(x, y-1, z)==register.vilmin && world.getBlock(x, y+1, z)==register.vilmin){
			
			world.setBlockMetadataWithNotify(x, y, z, 2, 3);
			
		}
		
	}
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		
		
		
	}
	
}
