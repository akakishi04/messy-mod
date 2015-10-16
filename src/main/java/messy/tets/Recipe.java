package messy.tets;

import cpw.mods.fml.common.registry.GameRegistry;
import messy.tetscore;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipe{


	public static void addrecipe(int rcp){

		if(rcp==1){

			GameRegistry.addRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone),
					"xxx",
					"xyx",
					"xxx",
					'x',Items.nether_star,
					'y',Items.apple);

		}else if(rcp==2){
			GameRegistry.addRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone),
					"xyx",
					"yxy",
					"xyx",
					'x',Items.nether_star,
					'y',messy.tetscore.fotrl);

		}



	}
	public static void recipe(){

		GameRegistry.addRecipe(new ItemStack(tetscore.rnhd),
				"xxx",
				"x x",
				"x x",
				'x',tetscore.rofb
				);

		GameRegistry.addRecipe(new ItemStack(tetscore.rofb),
				"xxx",
				"xxx",
				"xxx",
				'x',Items.rotten_flesh
				);
		GameRegistry.addRecipe(new ItemStack(tetscore.fotrl),
				"xyx",
				"zab",
				"xyx",
				'x',Items.redstone,
				'y',Items.glowstone_dust,
				'z',tetscore.vh,
				'a',Items.diamond,
				'b',tetscore.vm
				);
		GameRegistry.addRecipe(new ItemStack(tetscore.endercrystal),
				"xxx",
				"xyx",
				"zzz",
				'x',Items.nether_star,
				'y',Blocks.diamond_block,
				'z',Blocks.bedrock);
		GameRegistry.addRecipe(new ItemStack(tetscore.endercrystalsingle),
				"xxx",
				"xyx",
				"zzz",
				'x',Items.ghast_tear,
				'y',Items.nether_star,
				'z',Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(tetscore.bedrockStick),
				"xyx",
				" z ",
				" z ",
				'x',tetscore.trte,
				'y',Blocks.beacon,
				'z',Items.stick);
		GameRegistry.addRecipe(new ItemStack(tetscore.villagermeteo),
				"xxx",
				"zyz",
				"xxx",
				'x',tetscore.fotrl,
				'y',tetscore.rnhd,
				'z',Items.nether_star);



		GameRegistry.addShapelessRecipe(new ItemStack(tetscore.endercrystal),
				new ItemStack(tetscore.endercrystal, 1,OreDictionary.WILDCARD_VALUE),
				new ItemStack(Items.nether_star, 1,OreDictionary.WILDCARD_VALUE));

	}
	public static void smelterrecipe(){
		GameRegistry.addSmelting(tetscore.vm, new ItemStack(tetscore.ckvm), 0.3F);
		GameRegistry.addSmelting(Items.bed, new ItemStack(tetscore.bakedbed), 0.3F);
	}


}
