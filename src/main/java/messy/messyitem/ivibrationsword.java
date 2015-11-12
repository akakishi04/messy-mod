package messy.messyitem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
	
	public double test(ItemStack itemStack){
		
		NBTTagCompound nbt= itemStack.getTagCompound();
		
		if(nbt.getTag("Hz")!=null&& nbt.getTag("rss")!=null && nbt.getTag("mxd")!=null){
			if(nbt.getInteger("Hz")>0 && nbt.getInteger("rss")>0 &&nbt.getDouble("mxd")>0){
			
				double damage=0;
				double n=(nbt.getDouble("mxd")/(20*100))/60;
				
				damage=nbt.getInteger("Hz")/nbt.getInteger("rss")*n;
			
			return damage;
			}else{
				
				return 4;
				
			}
		}else {
			
			return 4;
			
		}
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		
		if(par1ItemStack.stackTagCompound.getTag("Hz")!=null){
			if(par1ItemStack.stackTagCompound.getInteger("Hz")>0){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
			
		}else{
			
			return false;
			
		}
		
	}
	
}
