package messy.tets;

import jp.plusplus.fbs.container.slot.SlotTakeOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class workcont extends Container {
	
	private wotil tile;
	
	public workcont(EntityPlayer player ,wotil wotil) {
        
		this.tile = wotil;
		
		for(int i=0;i<9;i++){
			
			this.addSlotToContainer(new Slot(tile, i,  30 + (i % 3) * 18, 17 + (i / 3) * 18));

		}
		
		this.addSlotToContainer(new SlotTakeOnly(this.tile, 11, 30, 71));
		
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18));
            }
        }
		
		for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 161));
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		
		return true;
	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemStack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            itemStack = stack.copy();

            

            if (stack.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (stack.stackSize == itemStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(par1EntityPlayer, stack);
        }

        return itemStack;
    }

}
