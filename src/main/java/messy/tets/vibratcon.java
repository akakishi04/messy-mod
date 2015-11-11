package messy.tets;

import jp.plusplus.fbs.container.slot.SlotInventory;
import jp.plusplus.ir2.api.ItemCrystalUnit;
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
		
		this.addSlotToContainer(new SlotInventory(vibin, 1,80,50,0));
		
		 //player inventory
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                
                    this.addSlotToContainer(new SlotInventory(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 112 + i * 18,2));
                
                
            }
        }

        //player slots
        for (int i = 0; i < 9; i++) {
      
                this.addSlotToContainer(new SlotInventory(inventoryPlayer, i, 8 + i * 18, 170,2));
        }
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		return true;
	}
	
	
	 @Override
	    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2) {
		 ItemStack itemStack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if(slot!=null && slot.getHasStack()){
	            ItemStack stack = slot.getStack();
	            itemStack = stack.copy();

	            if(par2==0){
	                if (!this.mergeItemStack(stack, 1, 37, true)){
	                    return null;
	                }
	                slot.onSlotChange(stack, itemStack);
	            }
	            else{
	                if(par2>=1 && par2<28){
	                    if(stack.getItem() instanceof ItemCrystalUnit){
	                        if(!this.mergeItemStack(stack, 0, 1, false)){
	                            return null;
	                        }
	                    }
	                    else if(!this.mergeItemStack(stack, 28, 37, false)){
	                        return null;
	                    }
	                }
	                else if (par2>=28 && par2<37){
	                    if(stack.getItem() instanceof ItemCrystalUnit){
	                        if(!this.mergeItemStack(stack, 0, 1, false)){
	                            return null;
	                        }
	                    }
	                    else if(!this.mergeItemStack(stack, 1, 28, false)){
	                        return null;
	                    }
	                }
	            }

	            if (stack.stackSize == 0){
	                slot.putStack((ItemStack)null);
	            }
	            else{
	                slot.onSlotChanged();
	            }

	            if (stack.stackSize == itemStack.stackSize){
	                return null;
	            }
	            slot.onPickupFromSlot(entityPlayer, stack);
	        }

	        return itemStack;
	    }
	 
	 @Override
	    public void onContainerClosed(EntityPlayer p_75134_1_) {
	        super.onContainerClosed(p_75134_1_);
	        this.vibin.closeInventory();
	    }

}
