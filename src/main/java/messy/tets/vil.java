package messy.tets;

import jp.plusplus.fbs.api.MagicBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ChatComponentText;

public class vil extends MagicBase {

	@Override
	public boolean checkSuccess() {



		return true;
	}

	@Override
	public void success() {

		player.addStat(achire.villagerfall, 1);
		
		int i=0;
		int n=0;
		EnPro epr =EnPro.get(player);
		if(checkMagicCircle("rainvil")){
			n=128+(rand.nextInt(property.getMagicLevel()+16)*property.getMagicLevel()*16+epr.getkillcount()/100)/10;

		}else if(!checkMagicCircle("rainvil")){
			n=64+(rand.nextInt(16)*property.getMagicLevel()*4+epr.getkillcount()/100)/10;

		}
		if(n==0){
			n=25;
		}
		while (i<n) {

		int x=rand.nextInt(64)-32;
		int z=rand.nextInt(64)-32;
		int y=rand.nextInt(32)-16;
		EntityVillager ev= new EntityVillager(world);
		ev.setPositionAndRotation(player.posX+x, player.posY+300+y, player.posZ+z, rand.nextFloat(), rand.nextFloat());
		ev.setCustomNameTag("爆弾");
		ev.setHealth(120);
		world.spawnEntityInWorld(ev);
		i+=1;
		}
		player.addChatMessage(new ChatComponentText(player.getDisplayName()+"は"+n+"人召喚した"));
	}

	@Override
	public void failure() {
		sanity(1, 64+rand.nextInt(16));

	}


}
