package messy.tets;

import jp.plusplus.fbs.Registry;
import jp.plusplus.fbs.container.ContainerDummy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class wotil extends TileEntity implements ISidedInventory{

	public ItemStack[] itemStacks=new ItemStack[10];
	private static final int[] slotsMaterial=new int[]{0,1,2,3,4,5,6,7,8}, slotsProduct=new int[]{9};
	public Registry.RecipePair product;
	public Container dummy=new ContainerDummy();
	public InventoryCrafting dummyInv=new InventoryCrafting(dummy,3,3);
	
	
	public void onInventoryChange() {
        for (int i = 0; i < slotsMaterial.length; i++) {
            dummyInv.setInventorySlotContents(i, itemStacks[slotsMaterial[i]]);
        }
       
        if (product != null){
        	setInventorySlotContents(slotsProduct[0], product.recipe.getCraftingResult(dummyInv));
        }
        else setInventorySlotContents(slotsProduct[0], null);
    }

	
	
	@Override
	public int getSizeInventory() {
		// TODO 自動生成されたメソッド・スタブ
		return 10;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return itemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		 if (itemStacks[i] != null){
	            ItemStack itemstack;

	            if (itemStacks[i].stackSize <= j){
	                itemstack = itemStacks[i];
	                itemStacks[i] = null;

	                
	                onInventoryChange();

	                markDirty();
	                return itemstack;
	            }
	            else{
	                itemstack = itemStacks[i].splitStack(j);

	                if (itemStacks[i].stackSize == 0){
	                    itemStacks[i] = null;
	                }

	                
	                onInventoryChange();

	                markDirty();
	                return itemstack;
	            }
		 	}else{
		 		return null;
		 	}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (itemStacks[i] != null){
            ItemStack itemstack = itemStacks[i];
            itemStacks[i] = null;
            markDirty();
            return itemstack;
        }
        else{
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		itemStacks[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = getInventoryStackLimit();
        }
        if(i!=slotsProduct[0]) onInventoryChange();
        markDirty();
	}

	@Override
	public String getInventoryName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO 自動生成されたメソッド・スタブ
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void openInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void closeInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		
        return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	
	
}
