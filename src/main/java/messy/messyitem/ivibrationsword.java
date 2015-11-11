package messy.messyitem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import messy.tetscore;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ivibrationsword extends ItemSword {
	
	public ivibrationsword(){
		
		super(ToolMaterial.EMERALD);
		setCreativeTab(tetscore.tet);
		
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.openGui(tetscore.instance, tetscore.gvibid, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return itemStack;
    }
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier",test(stack), 0));
		return multimap;
	}
	
	public int test(ItemStack itemStack){
		
		NBTTagCompound nbt= itemStack.getTagCompound();
		
		return nbt.getInteger("Hz");
		
	}
	
}
