package messy.tets;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIhandler implements IGuiHandler {
	
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tile=world.getTileEntity(x, y, z);
		
        if (tile instanceof wotil) {
            return new workcont(player,(wotil) world.getTileEntity(x, y, z));
        }
        return null;
    }
	
	 @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		 TileEntity tile =world.getTileEntity(x, y, z);
		 if (tile instanceof wotil) {
	            return new workguicon(player,(wotil) tile);
	        }
	        return null;
	    }
	
}
