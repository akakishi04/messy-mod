package messy.mesmagic;

import jp.plusplus.fbs.api.MagicBase;
import messy.tets.register;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class blacksummon extends MagicBase {

	int x, y, z,chance=20,in;

	@Override
	public boolean checkSuccess() {

		return check();
	}

	@Override
	public void success() {

		int ss;
		int c=rand.nextInt(100);
		
		if(c<=chance){
			if(icheck()){
				if(player.inventory.mainInventory[in].stackSize>=4){

					ss=4;

				player.inventory.mainInventory[in].stackSize-=ss;

				}else{

					ss=player.inventory.mainInventory[in].stackSize;
					player.inventory.mainInventory[in].stackSize-=ss;

				}

				EntityItem ei=new EntityItem(world, x, y+5, z);

				ei.setEntityItemStack(new ItemStack(register.HMM,ss));

				world.spawnEntityInWorld(ei);

				for(int X=-3;X<=3;X++){

					for(int Z=-3;Z<=3;Z++){

						if(world.getBlock(x+X, y, z+Z)==register.bdep){

							world.setBlockToAir(x+X, y, z+Z);

						}

					}

				}
			}else if(rand.nextInt(chance-20)%10>2){
				
				EntityWither ew=new EntityWither(world);
				ew.setPosition(x, y+5, z);
				world.spawnEntityInWorld(ew);
				
			}else{
				
				player.setFire(c);
				
			}
		}else if((c-chance)%10>2){
			
			if(rand.nextInt(10)>2){
				
				EntityWither eb=new EntityWither(world);
				eb.setPosition(x, y+5, z);
				world.spawnEntityInWorld(eb);
				
			}else{
				
				EntityDragon eb=new EntityDragon(world);
				eb.setPosition(x, y+5, z);
				world.spawnEntityInWorld(eb);
				
			}
			
			
			
		}else{
			
			
			
		}

		
	}

	@Override
	public void failure() {
		
		if(rand.nextInt(10)>2){
			
			EntityWither eb=new EntityWither(world);
			eb.setPosition(x, y+5, z);
			world.spawnEntityInWorld(eb);
			
		}else{
			
			EntityDragon eb=new EntityDragon(world);
			eb.setPosition(x, y+5, z);
			world.spawnEntityInWorld(eb);
			
		}

	}

	public boolean check() {

		if (checkMagicCircle("blsu")) {

			x = MathHelper.floor_double(player.posX);
			y = MathHelper.floor_double(player.posY);
			z = MathHelper.floor_double(player.posZ);

			for(int X=-3;X<=3;X++){

				for(int Z=-3;Z<=3;Z++){

					if(world.getBlock(x+X, y, z+Z)==register.bdep){

						chance+=2;
						
						if(!isSpelled){
							
							chance/=2;
							
						}

					}


				}

			}

			return true;

		}


		return false;
	}

	public boolean icheck(){

		for(int i=0;i<36;i++){
			if(player.inventory.mainInventory[i]!=null){
				if(player.inventory.mainInventory[i].getItem()==Item.getItemFromBlock(register.vilmin)){
	
					in=i;
	
					return true;
	
				}
			}

		}

		return false;
	}

}
