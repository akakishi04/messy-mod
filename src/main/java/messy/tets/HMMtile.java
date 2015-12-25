package messy.tets;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import messy.tetscore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;

public class HMMtile extends TileEntity {

	Random rand=new Random();
	private EntityVillager[] ev=new EntityVillager[10];
	private int[] run=new int[10];
	private int[] damagecount=new int[10];
	private int fli=0,dam=0,ct=0;
	private ItemStack vilso =null;

	public void setvillager(EntityVillager env,int i){

		if(i>=0 &&i<10){

			ev[i]=env;

		}

	}

	public EntityVillager getvillager(int i){

		if(i>=0 && i<10){

			return ev[i];

		}

		return null;

	}

	public void setrun(int i,int n){

		if(i>=0 && i<10){

			run[i]=n;

		}


	}

	public int getrun(int i){

		if(i>=0 && i<10){

			return run[i];

		}

		return -1;

	}

	public void setvilso(ItemStack item){

		

			vilso=item;

		

	}

	public ItemStack getvilso(){

		return vilso;

	}

	public void setfli(int i){

		fli=i;

	}

	public int getfli(){

		return fli;

	}

	@Override
	public void updateEntity(){

		if(worldObj.getBlock(xCoord, yCoord-1, zCoord) == register.HMM){
			
			if(ct>0){
				
				ct-=1;
				
			}
			
			
			for(int sl=0;sl<10;sl++){

				if(ev[sl]!=null){

					this.run[sl]+=1;
					
					ev[sl].setPosition(xCoord+0.5, yCoord-1, zCoord+0.5);

					if(getvillager(sl).isDead){

						this.ev[sl]=null;

						if(vilso!=null && fli ==1){

							NBTTagCompound nbt=vilso.stackTagCompound;

							if(nbt.getTag("vilsol") != null && !worldObj.isRemote){

								nbt.setInteger("vilsol", nbt.getInteger("vilsol")+1);


								vilso.setTagCompound(nbt);

								dam=vilso.stackTagCompound.getInteger("vilsol");
							}

						}else if(vilso ==null && fli==0){

							if(!worldObj.isRemote){

								EntityXPOrb eXPo=new EntityXPOrb(worldObj, xCoord, yCoord, zCoord, rand.nextInt(15));
								worldObj.spawnEntityInWorld(eXPo);

							}

						}else{

						}

					}

				}else{
					
						if(getonvilw()!=null){
							EntityVillager eve=getonvilw();
							if(ct==0){
							
							if(!eve.getEntityData().hasKey("mincer")){
								eve.setInvisible(true);
								
								this.ev[sl]=eve;
								this.ev[sl].getEntityData().setBoolean("mincer", true);
								this.run[sl]=0;
								this.damagecount[sl]=0;
								this.ct=1;
								ev[sl].setPosition(xCoord+0.5, yCoord-1, zCoord+0.5);
								worldObj.playSoundAtEntity(ev[sl], "mob.endermen.portal", 0.9F, 1.0F);
								
							}
						}
					}
					
					
					
				}

				

					

					if(ev[sl] !=null){
						
						if(run[sl]>20){
							
							stmin(sl);
						

					}
						
						ev[sl].setPosition(xCoord+0.5, yCoord-1, zCoord+0.5);
						
				}
				
				
			}
			
			
			
			
			
			
		}

		if(vilso==null && fli==1){
			vilso=new ItemStack(tetscore.vilswe);
			if(!worldObj.isRemote){

				NBTTagCompound nbt=new NBTTagCompound();

				nbt.setInteger("vilsol", dam);

				vilso.setTagCompound(nbt);

				dam=vilso.stackTagCompound.getInteger("vilsol");

			}
	 }


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

	public void stmin(int i){

		this.damagecount[i]+=1;


		if(this.damagecount[i]==5 && this.ev[i] !=null){


			EntityItem ei=new EntityItem(worldObj, xCoord, yCoord-1.5, zCoord, new ItemStack(tetscore.vm,rand.nextInt(1)+1));
			EntityItem ee=new EntityItem(worldObj, xCoord, yCoord-1.5, zCoord, new ItemStack(Items.emerald));

			if(!this.worldObj.isRemote){

				this.worldObj.spawnEntityInWorld(ei);
				worldObj.playSoundAtEntity(ei, "mob.endermen.portal", 0.9F, 1.0F);

				if(this.rand.nextInt(3)==0){
					this.worldObj.spawnEntityInWorld(ee);
					worldObj.playSoundAtEntity(ee, "mob.endermen.portal", 0.9F, 1.0F);
				}


				this.ev[i].attackEntityFrom(DamageSource.cactus,2);

				this.damagecount[i]=0;

			}

		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound){
		super.readFromNBT(nbtTagCompound);
		
		fli=nbtTagCompound.getInteger("fli");
		dam=nbtTagCompound.getInteger("dam");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound){
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setInteger("dam", dam);
		nbtTagCompound.setInteger("fli", fli);
		
	}

}
