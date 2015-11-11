package messy.tets;

import jp.plusplus.ir2.items.ItemCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class vibratcon extends Container {
	
	private vibin vibin;
	
	public vibratcon(InventoryPlayer inventoryPlayer) {
		
		vibin =new vibin(inventoryPlayer);
		vibin.openInventory();
		
		this.addSlotToContainer(new Slot(vibin, 1,79,43));
		
		 //player inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                
                    this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 99 + i * 18));
                
                
            }
        }

        //player slots
        for (int i = 0; i < 9; i++) {
      
                this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 157));
        }
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		return true;
	}
	
	
	 @Override
	    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
	        ItemStack itemstack = null;
	        Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

	        if (slot != null && slot.getHasStack()) {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (p_82846_2_ < this.vibin.getSizeInventory()) {
	                if (!this.mergeItemStack(itemstack1, this.vibin.getSizeInventory(), this.inventorySlots.size(), true)) {
	                    return null;
	                }
	            }

	            else if (slot.getStack() != null && slot.getStack().getItem() == ItemCore.bag) {
	                return null;
	            } else if (!this.mergeItemStack(itemstack1, 0, this.vibin.getSizeInventory(), false)) {
	                return null;
	            }
	            if (itemstack1.stackSize == 0) {
	                slot.putStack((ItemStack) null);
	            } else {
	                slot.onSlotChanged();
	            }
	        }

	        return itemstack;
	    }
	 
	 @Override
	    public void onContainerClosed(EntityPlayer p_75134_1_) {
	        super.onContainerClosed(p_75134_1_);
	        this.vibin.closeInventory();
	    }

}
