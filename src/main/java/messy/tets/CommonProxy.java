package messy.tets;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler{

	public EntityPlayer getEntityPlayerInstance() {return null;}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	void init() {
		// TODO 自動生成されたメソッド・スタブ

	}

	


	
}
