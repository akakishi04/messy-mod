package messy.messyblock;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.messyitem.vilswep;
import messy.tets.HMMtile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockHMM extends BlockContainer {

	@SideOnly(Side.CLIENT)
	public IIcon icont;
	@SideOnly(Side.CLIENT)
	public IIcon icons;
	@SideOnly(Side.CLIENT)
	public IIcon iconb;


	public BlockHMM(){
		super(Material.iron);
		setCreativeTab(tetscore.tet);
		setBlockName("hypermincer");
		setTickRandomly(true);
		
		setLightLevel(0.2F);
		
	}


	@Override
	public TileEntity createNewTileEntity(World world, int meta) {

		return new HMMtile();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void  registerBlockIcons(IIconRegister par1IconRegister){
		
		String md="tete:hmm_";
		
		
		icons=par1IconRegister.registerIcon(md+"s");
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
			return icons;
		}
		
	}
	
	@Override
	 public boolean isOpaqueCube()
   {
       return false;
   }
	
	 @Override
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		 
		  if(!world.isRemote && world.getTileEntity(x, y, z) instanceof HMMtile){
			  HMMtile vim =(HMMtile) world.getTileEntity(x, y, z);
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
	       if(world.getTileEntity(x, y, z) instanceof HMMtile){
	    	   HMMtile tile=(HMMtile) world.getTileEntity(x, y, z);
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
		
		
		
		
		double d4 =x+random.nextFloat();
		double d5=y-1.05;
		double d6=z+random.nextFloat();
		double d7=x-random.nextFloat();
		double d8=z-random.nextFloat();
		
			
			world.spawnParticle("portal",d4, y-0.5,d6, random.nextFloat(), random.nextFloat(), random.nextFloat());
			world.spawnParticle("portal",d7, y-0.5,d8, random.nextFloat(), random.nextFloat(), random.nextFloat());
		
		
		
		
		
		
	}

}
