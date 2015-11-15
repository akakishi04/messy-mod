package messy.tets;

import jp.plusplus.ir2.api.ItemCrystalUnit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class vibin implements IInventory {

	private InventoryPlayer ip;
	private ItemStack ci;
	private ItemStack[] item = new ItemStack[1];
	private double d=0;

	public vibin(InventoryPlayer inventory) {
		ip = inventory;
		ci = ip.getCurrentItem();

	}

	@Override
	public int getSizeInventory() {

		return item.length;

	}

	@Override
	public ItemStack getStackInSlot(int i) {

		return item[0];

	}

	@Override
	public ItemStack decrStackSize(int i, int size) {

		if (this.item[0] != null) {
			ItemStack itemstack;

			if (this.item[0].stackSize <= size) {
				itemstack = this.item[0];
				this.item[0] = null;
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.item[0].splitStack(size);

				if (this.item[0].stackSize == 0) {
					this.item[0] = null;
				}

				this.markDirty();
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {

		if (this.item[0] != null) {
			ItemStack itemstack = this.item[0];
			this.item[0] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack items) {

		this.item[0] = items;

		if (items != null && items.stackSize > this.getInventoryStackLimit()) {
			items.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();

	}

	@Override
	public String getInventoryName() {

		return "InventoryItem";

	}

	@Override
	public boolean hasCustomInventoryName() {

		return false;
	}

	@Override
	public int getInventoryStackLimit() {

		return 1;

	}

	@Override
	public void markDirty() {

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {

		return true;
	}

	@Override
	public void openInventory() {

		if (!ci.hasTagCompound()) {
			ci.setTagCompound(new NBTTagCompound());
			ci.getTagCompound().setTag("Items", new NBTTagList());

		} else if (!ci.getTagCompound().hasKey("Items")) {
			ci.getTagCompound().setTag("Items", new NBTTagList());
			
		}
		
		d=ci.getTagCompound().getInteger("k-dam");
		
		NBTTagList tags = (NBTTagList) ci.getTagCompound().getTag("Items");
		for (int i = 0; i < tags.tagCount(); i++) {
			NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
			int slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < item.length) {
				item[slot] = ItemStack.loadItemStackFromNBT(tagCompound);

				if (item[slot].getItem() instanceof ItemCrystalUnit) {
					
					
						ItemCrystalUnit ic = (ItemCrystalUnit) item[slot].getItem();
						item[0]=ic.setDamageNBT(item[0],d);
						
					
					
				}

			}
		}

	}

	@Override
	public void closeInventory() {

		NBTTagList tagList = new NBTTagList();
		int f = 0, rss = 0, kdam = 0;
		double mxd = 0;
		if (item[0] != null) {
			ItemCrystalUnit icu = (ItemCrystalUnit) item[0].getItem();
			NBTTagCompound compound = new NBTTagCompound();
			compound.setByte("Slot", (byte) 0);
			f = icu.frequency;
			mxd = icu.maxDamageNBT;
			rss = icu.rss;
			kdam = (int) icu.getDamageNBT(item[0]);
			item[0].writeToNBT(compound);
			tagList.appendTag(compound);
		}

		ItemStack result = new ItemStack(ci.getItem(), 1, ci.getItemDamage());
		result.setTagCompound(new NBTTagCompound());

		result.getTagCompound().setTag("Items", tagList);
		result.getTagCompound().setInteger("Hz", f);
		result.getTagCompound().setInteger("rss", rss);
		result.getTagCompound().setDouble("mxd", mxd);
		result.getTagCompound().setInteger("k-dam", kdam);

		ip.mainInventory[ip.currentItem] = result;

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack items) {

		return items.getItem() instanceof ItemCrystalUnit;

	}

}
