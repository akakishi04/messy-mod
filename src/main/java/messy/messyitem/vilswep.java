package messy.messyitem;

import java.util.List;

import messy.tetscore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class vilswep extends ItemSword {

	public static int sol=0;
	
	public vilswep() {
		super(tetscore.ttrte);
		setCreativeTab(tetscore.tet);
	}

	@Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
       
        NBTTagCompound nbt = new NBTTagCompound();
      
            nbt.setInteger("vilsol", 0);
            itemStack.setTagCompound(nbt);
        
        itemStack.setTagCompound(nbt);//ItemStackにNBTTagCompoundを格納
    }
	
	@Override
	    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHeld) {
		  NBTTagCompound nbt = new NBTTagCompound();
	  
	            nbt.setInteger("vilsol", sol);
	            itemStack.setTagCompound(nbt);
	        
	 
	    }
	  @Override
	  public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
		  
		  NBTTagCompound nbt = itemStack.getTagCompound();
		  if(nbt!=null){
		  list.add(String.valueOf(nbt.getInteger("vilsol")));
		  }
	  }
	
}
