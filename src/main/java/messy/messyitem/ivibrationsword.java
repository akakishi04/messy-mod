package messy.messyitem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import messy.tetscore;
import messy.tets.register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ivibrationsword extends ItemSword {

	public ivibrationsword() {

		super(ToolMaterial.EMERALD);
		setCreativeTab(tetscore.tet);
		setHasSubtypes(true);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		
		if(itemStack.stackTagCompound.getTag("MODE")==null){
			
			itemStack.stackTagCompound.setInteger("MODE", 0);
			
		}
		
			if (!player.isSneaking()) {
				
					player.openGui(tetscore.instance, tetscore.gvibid, world, (int) player.posX, (int) player.posY,
							(int) player.posZ);

				
			} else if (player.isSneaking()) {
				if(itemStack.stackTagCompound.getInteger("MODE")==1){
					
					player.addChatComponentMessage(new ChatComponentText("mode-NOMAL"));
					itemStack.stackTagCompound.setInteger("MODE", 0);
					super.getAttributeModifiers(itemStack);
					
				}else if(itemStack.stackTagCompound.getInteger("MODE")==0){
					
					player.addChatComponentMessage(new ChatComponentText("mode-NO LIMIT"));
					itemStack.stackTagCompound.setInteger("MODE", 1);
					super.getAttributeModifiers(itemStack);
					
				}
				
				
		}
		return itemStack;
	}

	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int slot, boolean isHeld) {
		
		if (entity instanceof EntityPlayer) {
			EntityPlayer ep = (EntityPlayer) entity;
			if (world.isRemote) {
				if (ep.inventory.getCurrentItem() == null) {
				} else if (ep.inventory.getCurrentItem().getItem() == register.vibrationsword) {
					
					if (item.getItem() == register.vibrationsword) {
						
						if(item.stackTagCompound.getTag("MODE")==null){
							
							item.stackTagCompound.setInteger("MODE", 0);
							
						}
						ep.addChatComponentMessage(new ChatComponentText(String.valueOf(item.stackTagCompound.getInteger("MODE"))+String.valueOf(damage(item))));
						if (item.stackTagCompound.getInteger("MODE")==0) {

						} else if (item.stackTagCompound.getInteger("MODE")==1) {

							ep.addChatComponentMessage(new ChatComponentText("mode-NO"));

							if (item.stackTagCompound.getTag("k-dam") != null) {
								
								item.stackTagCompound.setDouble("k-dam",item.stackTagCompound.getDouble("k-dam") + 1);

								if (item.stackTagCompound.getDouble("k-dam") >= item.stackTagCompound.getDouble("mxd")) {

									

								}
							}

						}

					}
				}
			}

		}
	}

	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon modifier", damage(stack), 0));
		return multimap;
	}

	public double damage(ItemStack itemStack) {

		NBTTagCompound nbt = itemStack.getTagCompound();
		
		if(itemStack.stackTagCompound.getTag("MODE")==null){
			
			itemStack.stackTagCompound.setInteger("MODE", 0);
			
		}
		
		if (nbt.getTag("Hz") != null && nbt.getTag("rss") != null && nbt.getTag("mxd") != null) {
			if (nbt.getInteger("Hz") > 0 && nbt.getInteger("rss") > 0 && nbt.getDouble("mxd") > 0) {

				double damage = 0;
				if (itemStack.stackTagCompound.getInteger("MODE")==0) {

					double n = (nbt.getDouble("mxd") / (20 * 100)) / 60;

					damage = nbt.getInteger("Hz") / nbt.getInteger("rss") * n;

					return damage;
				} else if (itemStack.stackTagCompound.getInteger("MODE") == 1) {

					double n = (nbt.getDouble("mxd") / (20 * 100)) / 60;

					damage = nbt.getInteger("Hz") / (nbt.getInteger("rss") / 5) * n;

					return damage;
				} else {

					return 4;

				}
			} else {

				return 4;

			}
		} else {

			return 4;

		}

	}

}
