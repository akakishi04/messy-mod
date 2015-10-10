package tets;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
					'y',tetscore.fotrl);
			
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
		



	}
	public static void smelterrecipe(){
		GameRegistry.addSmelting(tetscore.vm, new ItemStack(tetscore.ckvm), 0.3F);
		GameRegistry.addSmelting(Items.bed, new ItemStack(tetscore.bakedbed), 0.3F);
	}


}
