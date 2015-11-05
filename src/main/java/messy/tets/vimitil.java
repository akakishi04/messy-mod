package messy.tets;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import messy.tetscore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;

public class vimitil extends TileEntity {

	Random rand =new Random();
	private EntityVillager ev=null;
	private int runtime;
	private int damagecount;

	public void setvillager(EntityVillager entity){

		this.ev=entity;

	}

	public EntityVillager getvillager(){

		return this.ev;

	}

	public void setruntime(int i){

		this.runtime=i;

	}

	public int getruntime(){

		return this.runtime;

	}

	@Override
	public void updateEntity(){


		if(worldObj.getBlock(xCoord, yCoord - 1, zCoord)==register.vilmin){

			if(getvillager()!=null){

				this.runtime += 1;

				if(getvillager().isDead){

					this.ev=null;

				}

				}else {
				
				this.ev=this.getonvilw();
				this.runtime=0;
				this.damagecount=0;
				
				
				
				
				
				}
			
				if(this.runtime>20){
					
					stmin();
					
					if(ev !=null){
						
						ev.setPosition(xCoord-0.5, yCoord-1, zCoord-0.5);
						
						
					}
					
				}else{
				
				
			}

		}
		
		super.updateEntity();
		
	}


	public EntityVillager getonvilw(){
		  AxisAlignedBB aa = AxisAlignedBB.getBoundingBox(this.xCoord,this.yCoord,this.zCoord,this.xCoord,this.yCoord+1,this.zCoord)
				  .expand(1.0D, 1.0D, 1.0D);

		  List list=this.worldObj.getEntitiesWithinAABB(EntityVillager.class, aa);
		  for(Iterator i=list.iterator();i.hasNext();){
			  Entity entity=(Entity)i.next();

			  if(entity instanceof EntityVillager) {
				  
				  return (EntityVillager)entity;

			  }

		  }
		  return null;

	}

	public void stmin(){
		
		this.damagecount+=1;
		
		
		if(this.damagecount==5 && this.ev !=null){
			
			
			EntityItem ei=new EntityItem(worldObj, xCoord, yCoord-1.5, zCoord, new ItemStack(tetscore.vm,rand.nextInt(1)+1));
			EntityItem ee=new EntityItem(worldObj, xCoord, yCoord-1.5, zCoord, new ItemStack(Items.emerald));
			
			if(!this.worldObj.isRemote){
				
				this.worldObj.spawnEntityInWorld(ei);
				
				if(this.rand.nextInt(3)==0){
					this.worldObj.spawnEntityInWorld(ee);
				}
				
				
				this.ev.attackEntityFrom(DamageSource.cactus,2);
				
				this.damagecount=0;
				
			}
			
		}
		
	}
	
	
}
