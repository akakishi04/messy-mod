package messy.tets;

import jp.plusplus.fbs.api.MagicBase;
import net.minecraft.entity.item.EntityEnderCrystal;

public class ViSu extends MagicBase {





	@Override
	public boolean checkSuccess() {

		if(isSpelled) return true;
		player.addStat(achire.Haid, 1);
		float prob=0.4f+0.03f*property.getMagicLevel();
        return rand.nextFloat()<=prob;
		
	}

	@Override
	public void success() {
		

		
		world.spawnEntityInWorld(new EntityEnderCrystal(world, player.posX, player.posY+1, player.posZ));
		

		//world.setBlock((int)player.posX+1, (int)player.posY,(int) player.posZ,Blocks.diamond_ore);
	}

	@Override
	public void failure() {
		// TODO 自動生成されたメソッド・スタブ
		sanity(1, 1);
		//world.spawnEntityInWorld(new EntityEnderPearl(world, player.posX, player.posY, player.posZ));

	}
	/*@Override
	public String getMagicCircleName(){
		return "ViSu";

	}*/

}
