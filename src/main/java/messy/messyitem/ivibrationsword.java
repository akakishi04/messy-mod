package messy.messyitem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import messy.tetscore;
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

	private final String mode = "MODE", kdam = "K-dam";
	private final String[] MODE={"NOMAL","NO LIMIT"};

	public ivibrationsword() {

		super(ToolMaterial.EMERALD);
		setCreativeTab(tetscore.tet);
		setHasSubtypes(true);

	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {

		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setInteger(mode, 0);
		nbt.setInteger(kdam,0);
		
		itemStack.setTagCompound(nbt);// ItemStackにNBTTagCompoundを格納
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		int kd = 0,Mode=0;
		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) {
			
			nbt=new NBTTagCompound();
			
			nbt.setInteger(mode, 0);
			nbt.setInteger(kdam, 0);
			
		}
		
		kd=nbt.getInteger(kdam);
		Mode=nbt.getInteger(mode);
		if(player.isSneaking()){
			
			if(!world.isRemote){
				
				if(nbt.getInteger(mode)==0){
					
					if(nbt.getInteger(kdam)<nbt.getInteger("mxd")){
						
						nbt.setInteger(mode, 1);
						
					}
					
				}else if(nbt.getInteger(mode)==1){
					
					nbt.setInteger(mode,0);
					
				}
				
				player.addChatComponentMessage(new ChatComponentText(mode+MODE[nbt.getInteger(mode)]));
				
			}
			
			
			
		}else if(!player.isSneaking()){
			
			if(!world.isRemote){
				
				player.openGui(tetscore.instance, tetscore.gvibid, world, (int)player.posX,(int) player.posY,(int) player.posZ);
				
			}
			
		}
		
		nbt.setInteger(kdam, kd);
		
		itemStack.setTagCompound(nbt);
		
		return itemStack;
	}

	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int slot, boolean isHeld) {

		if (entity instanceof EntityPlayer) {
			EntityPlayer ep = (EntityPlayer) entity;
			
			if(ep.inventory.getCurrentItem() !=null &&ep.inventory.getCurrentItem().getItem() instanceof ivibrationsword){
				
				NBTTagCompound nbt=item.getTagCompound();
				
				if(nbt==null){
					
					nbt =new NBTTagCompound();
					
					nbt.setInteger(mode, 0);
					nbt.setInteger(kdam,0);
					nbt.setInteger("mxd", 0);					
				}
				
				if(nbt.getInteger(mode)==0){
					
					
					
				}else if(nbt.getInteger(mode)==1){
					
					nbt.setInteger(kdam,nbt.getInteger(kdam)+100);
					
					if(nbt.getInteger(kdam)>=nbt.getInteger("mxd")){
						
						nbt.setInteger(mode, 0);
						
					}
					
				}
				
				ep.addChatComponentMessage(new ChatComponentText(mode+MODE[nbt.getInteger(mode)]+":"+String.valueOf(nbt.getInteger(kdam))));
				
				item.setTagCompound(nbt);
				
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

		NBTTagCompound nbt = itemStack.getTagCompound() == null ? new NBTTagCompound() : itemStack.getTagCompound();

		if (nbt.getTag("MODE") == null) {

			nbt.setInteger("MODE", 0);

		}

		if (nbt.getTag("Hz") != null && nbt.getTag("rss") != null && nbt.getTag("mxd") != null) {
			if (nbt.getInteger("Hz") > 0 && nbt.getInteger("rss") > 0 && nbt.getDouble("mxd") > 0) {

				double damage = 0;
				if (itemStack.stackTagCompound.getInteger("MODE") == 0) {

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
