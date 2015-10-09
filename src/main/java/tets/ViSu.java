package tets;

import jp.plusplus.fbs.api.MagicBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;

public class ViSu extends MagicBase {

	EntityVillager Ev = new EntityVillager(player.worldObj);

	

	@Override
	public boolean checkSuccess() {
		
		return true;
		
	}

	@Override
	public void success() {
		world.spawnEntityInWorld(Ev);
		player.inventory.setItemStack(new ItemStack(tetscore.ckvm));
	}

	@Override
	public void failure() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
