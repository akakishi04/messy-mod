package messy.tets;

import cpw.mods.fml.common.network.IGuiHandler;
import messy.tetscore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIhandler implements IGuiHandler {
	
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == tetscore.gwid) {
            return new workcont(x, y, z);
        }
        return null;
    }
	
	 @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	        if (ID == tetscore.gwid) {
	            return new workguicon(x, y, z);
	        }
	        return null;
	    }
	
}
