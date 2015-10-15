package messy;

import jp.plusplus.fbs.api.MagicBase;
import messy.tets.EnPro;
import net.minecraft.entity.passive.EntityVillager;

public class vil extends MagicBase {

	@Override
	public boolean checkSuccess() {


		return rand.nextBoolean();
	}

	@Override
	public void success() {

		int i=0;
		EnPro epr =EnPro.get(player);
		if(getMagicCircleName()=="rainvil"){
		while (i<128+rand.nextInt(property.getMagicLevel()+16)*16) {

		int x=rand.nextInt(64)-32;
		int z=rand.nextInt(64)-32;
		EntityVillager ev= new EntityVillager(world);
		ev.setPosition(player.posX+x, player.posY+30, player.posZ+z);
		world.spawnEntityInWorld(ev);
		i+=1;
		}}else{
			while (i<64+rand.nextInt(16)*property.getMagicLevel()*4) {

				int x=rand.nextInt(64)-32;
				int z=rand.nextInt(64)-32;
				int y=rand.nextInt(16)-8;
				
				EntityVillager ev= new EntityVillager(world);
				ev.setAlwaysRenderNameTag(true);
				ev.setCustomNameTag("爆弾");
				ev.setHealth(1);
				ev.setPosition(player.posX+x, player.posY+300+y, player.posZ+z);
				world.spawnEntityInWorld(ev);
				
				i+=1;

		}}
		if(epr.getkillcount()>0){
			int n = 0;
			while (n==epr.getkillcount()/100) {
				int x=rand.nextInt(64)-32;
				int z=rand.nextInt(64)-32;
				int y=rand.nextInt(16)-8;
				
				EntityVillager ev= new EntityVillager(world);
				ev.setAlwaysRenderNameTag(true);
				ev.setCustomNameTag("爆弾");
				
				ev.setHealth(1);
				ev.setPosition(player.posX+x, player.posY+300+y, player.posZ+z);
				world.spawnEntityInWorld(ev);
				n += 1;
				
			}
		}
	}

	@Override
	public void failure() {
		sanity(1, 64+rand.nextInt(16));

	}


}
