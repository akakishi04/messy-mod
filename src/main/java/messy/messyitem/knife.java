package messy.messyitem;

import messy.tetscore;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import schr0.cleaver.item.ItemCleaverNormal;

public class knife extends ItemCleaverNormal {

	public static final EnumRarity RARITY=EnumHelper.addRarity("messyrari", EnumChatFormatting.DARK_RED, "Chinese kitchen knife");

	public knife() {
		super("Chinese kitchen knife",ToolMaterial.IRON,"",RARITY);

		setCreativeTab(tetscore.tet);

	}



}
