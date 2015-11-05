package messy.tets;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class workcont extends Container {
	
	int x,y,z;
	
	public workcont(int x, int y, int z) {
        this.x= x;
        this.y= y;
        this.z = z;
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		
		return true;
	}

}
