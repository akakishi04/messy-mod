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
			
		}
		
		
		
	}
	public static void recipe(){
		
		GameRegistry.addRecipe(new ItemStack(tetscore.nhd), 
				
				"xxx",
				"x x",
				"x x",
				'x',tetscore.vm
				);
		
		
		
		
		
		
	}
	
	

}
