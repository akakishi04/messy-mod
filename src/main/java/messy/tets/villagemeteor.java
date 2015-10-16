package messy.tets;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class villagemeteor {


	public static void villmete(World world,int x,int y,int z,EntityPlayer player){

		int i=10;
		int n=100+new Random().nextInt(32);
		player.addChatMessage(new ChatComponentText(player.getDisplayName()+"は"+n*i+"人召喚した"));
		while(i>0){

			while (n>0) {
				int Y =new Random().nextInt(32)-16+300+i*10;
				EntityVillager ev = new EntityVillager(world);
				ev.setCustomNameTag("爆弾");
				ev.setHealth(100);
				ev.setPositionAndRotation(x+new Random().nextInt(64)-32, y+Y, z+new Random().nextInt(64)-32, new Random().nextFloat(),new Random().nextFloat() );


				world.spawnEntityInWorld(ev);

				n-=1;
			}

			i -=1;
		}
		

	}



}
