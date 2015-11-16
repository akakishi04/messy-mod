package messy.tets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.model.abadon;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Iabah extends ItemArmor {
	
	private final static ArmorMaterial abad=EnumHelper.addArmorMaterial("abadonhat", -1,new int[]{1,1,1,1}, 5);
	
	@SideOnly(Side.CLIENT)
	abadon abadon=new abadon();
	
	public Iabah() {
		super(abad,0,0);
		setCreativeTab(tetscore.tet);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "tete:textures/items/abadobo.png";
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		
        return abadon;
        		
    }
	
}
