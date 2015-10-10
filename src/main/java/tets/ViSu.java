package tets;

import jp.plusplus.fbs.api.MagicBase;
import net.minecraft.entity.item.EntityEnderCrystal;

public class ViSu extends MagicBase {

	

	

	@Override
	public boolean checkSuccess() {
		
		if(isSpelled) return true;
		
		float prob=0.4f+0.03f*property.getMagicLevel();
        return rand.nextFloat()<=prob;
		
	}

	@Override
	public void success() {
		world.spawnEntityInWorld(new EntityEnderCrystal(world, player.posX+1, player.posY, player.posZ));
		//world.setBlock((int)player.posX+1, (int)player.posY,(int) player.posZ,Blocks.diamond_ore);
	}

	@Override
	public void failure() {
		// TODO 自動生成されたメソッド・スタブ
		sanity(1, 1);
		world.spawnEntityInWorld(new EntityEnderCrystal(world, player.posX, player.posY, player.posZ));
		
	}
	@Override
	public String getMagicCircleName(){
		return "ViSu";
		
	}

}
