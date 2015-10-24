package messy.mesmagic;

import jp.plusplus.fbs.api.MagicBase;
import jp.plusplus.fbs.entity.EntityMagicArrow;
import messy.tets.EnPro;

public class rainomagic extends MagicBase {

	@Override
	public boolean checkSuccess() {

		return true;
	}

	@Override
	public void success() {
		int i=0;
		int n=0;
		boolean xz;
		EnPro epr =EnPro.get(player);
		if(checkMagicCircle("rainvil")){
			int kil=epr.getkillcount()/100;
			n=128+(rand.nextInt(property.getMagicLevel()+16)*property.getMagicLevel()*16+kil)/10;
			xz=true;

		}else if(!checkMagicCircle("rainvil")){
			int kil=epr.getkillcount()/100;
			n=64+(rand.nextInt(16)*property.getMagicLevel()*4+kil)/10;
			xz=false;

		}else{
			n=25;
			xz=false;
		}
		while (i<n) {
			double x;
			double z;
			int y;
		if(xz==false){
			x=rand.nextInt(16)-8+rand.nextFloat();
			z=rand.nextInt(16)-8+rand.nextDouble();
			y=rand.nextInt(8)-2;
		}else if(xz==true){
			x=rand.nextInt(16)-8;
			z=rand.nextInt(16)-8;
			y=rand.nextInt(8)-2;
		}else{
			x=rand.nextInt(64)-32;
			z=rand.nextInt(64)-32;
			y=rand.nextInt(32)-16;
		}
		EntityMagicArrow ev= new EntityMagicArrow(world,player,1F,1F,10);
		//EntityArrow ev=new EntityArrow(world, player, 20);
		ev.setPosition(player.posX+x, player.posY+y, player.posZ+z);
		ev.fallDistance=-1;
		
		
		world.spawnEntityInWorld(ev);
		i+=1;
		}

	}

	@Override
	public void failure() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
