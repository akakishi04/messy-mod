package messy.tets;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import messy.tetscore;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class Ibasesword extends ItemSword {
	
	public Ibasesword(){
		
		super(ToolMaterial.EMERALD);
		setCreativeTab(tetscore.tet);
	
		setUnlocalizedName("BaseSword");
		
	}
	@Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		
		player.addStat(achire.basesword, 1);
		
    }
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier",4, 0));
		return multimap;
	}
	
}
