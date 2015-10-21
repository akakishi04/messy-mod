package messy.mesmagic;

import jp.plusplus.fbs.api.MagicBase;
import messy.tetscore;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;

public class vilsum extends MagicBase{

	@Override
	public boolean checkSuccess() {
		if(isSpelled && checkMagicCircle("expl")){
			return true;
		}
		return true;
	}

	@Override
	public void success() {
		int n=-3,i=-3;

	if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ+3)==Blocks.gravel){

		    EntityHorse eh=new EntityHorse(world);
			world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ+3);
			eh.setPosition(player.posX+3, player.posY, player.posZ+3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
			//player.addChatMessage(new ChatComponentText("a"));

	}else if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ+3)==tetscore.rofb){
				EntityGiantZombie eh=new EntityGiantZombie(world);
				world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ+3);
				eh.setPosition(player.posX+3, player.posY, player.posZ+3);
				world.spawnEntityInWorld(eh);
				player.setHealth(player.getHealth()-5F);

	}else if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ+3)==tetscore.cross){
		 EntityVillager eh=new EntityVillager(world,rand.nextInt(4));
			world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ+3);
			eh.setPosition(player.posX+3, player.posY, player.posZ+3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
	}
	
	if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ+3)==Blocks.gravel){

		 EntityHorse eh=new EntityHorse(world);
			world.setBlockToAir((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
			eh.setPosition((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);

	}else if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ+3)==tetscore.rofb){
		EntityGiantZombie eh=new EntityGiantZombie(world);
		world.setBlockToAir((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
		eh.setPosition((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
		world.spawnEntityInWorld(eh);
		player.setHealth(player.getHealth()-5F);

	}else if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ+3)==tetscore.cross){
		 EntityVillager eh=new EntityVillager(world,rand.nextInt(4));
			world.setBlockToAir((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
			eh.setPosition((int)player.posX-3,(int) player.posY, (int)player.posZ+3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
	}
	
	if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ-3)==Blocks.gravel){

		 EntityHorse eh=new EntityHorse(world);
			world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ+3);
			eh.setPosition((int)player.posX-3,(int) player.posY, (int)player.posZ-3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
			
	}else if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ-3)==tetscore.rofb){
		EntityGiantZombie eh=new EntityGiantZombie(world);
		world.setBlockToAir((int)player.posX-3,(int) player.posY, (int)player.posZ-3);
		eh.setPosition(player.posX+3, player.posY, player.posZ+3);
		world.spawnEntityInWorld(eh);
		player.setHealth(player.getHealth()-5F);

	}else if(world.getBlock((int)player.posX-3,(int) player.posY, (int)player.posZ-3)==tetscore.cross){
		 EntityVillager eh=new EntityVillager(world,rand.nextInt(4));
			world.setBlockToAir((int)player.posX-3,(int) player.posY, (int)player.posZ-3);
			eh.setPosition((int)player.posX-3,(int) player.posY, (int)player.posZ-3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
	}

	if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ-3)==Blocks.gravel){

		 EntityHorse eh=new EntityHorse(world);
			world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
			eh.setPosition((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
			
	}else if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ-3)==tetscore.rofb){
		EntityGiantZombie eh=new EntityGiantZombie(world);
		world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
		eh.setPosition((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
		world.spawnEntityInWorld(eh);
		player.setHealth(player.getHealth()-5F);
		

	}else if(world.getBlock((int)player.posX+3,(int) player.posY, (int)player.posZ-3)==tetscore.cross){
		 EntityVillager eh=new EntityVillager(world,rand.nextInt(4));
			world.setBlockToAir((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
			eh.setPosition((int)player.posX+3,(int) player.posY, (int)player.posZ-3);
			world.spawnEntityInWorld(eh);
			player.setHealth(player.getHealth()-5F);
			
	}



	}

	@Override
	public void failure() {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public String getMagicCircleName(){
        return "expl";
    }


}
