package messy.mesmagic;

import jp.plusplus.fbs.api.MagicBase;
import messy.tets.EnPro;
import messy.tets.achire;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ChatComponentText;

public class vil extends MagicBase {

	@Override
	public boolean checkSuccess() {

		if(rand.nextInt()/10<3){
			return false;
		}

		return true;
	}

	@Override
	public void success() {

		player.addStat(achire.villagerfall, 1);
		
		int i=0;
		int n=0;
		boolean xz;
		EnPro epr =EnPro.get(player);
		if(checkMagicCircle("rainvil")){
			int kil=epr.getkillcount()/100;
			n=128+(rand.nextInt(property.getMagicLevel()+16)*property.getMagicLevel()*16+kil)/10;
			xz=true;
			epr.setkillcount(epr.getkillcount()-kil);
		}else if(!checkMagicCircle("rainvil")){
			int kil=epr.getkillcount()/100;
			n=64+(rand.nextInt(16)*property.getMagicLevel()*4+kil)/10;
			xz=false;
			epr.setkillcount(epr.getkillcount()-kil);
		}else{
			n=25;
			xz=false;
		}
		while (i<n) {
			int x;
			int z;
			int y;
		if(xz==false){
			x=rand.nextInt(64)-32;
			z=rand.nextInt(64)-32;
			y=rand.nextInt(32)-16;
		}else if(xz==true){
			x=rand.nextInt(128)-64;
			z=rand.nextInt(128)-64;
			y=rand.nextInt(64)-32;
		}else{
			x=rand.nextInt(64)-32;
			z=rand.nextInt(64)-32;
			y=rand.nextInt(32)-16;
		}
		EntityVillager ev= new EntityVillager(world);
		ev.setPositionAndRotation(player.posX+x, player.posY+400+y, player.posZ+z, rand.nextFloat(), rand.nextFloat());
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
