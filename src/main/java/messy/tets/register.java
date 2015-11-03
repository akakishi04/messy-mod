package messy.tets;

import cpw.mods.fml.common.registry.GameRegistry;
import messy.tetscore;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class register {

	public static Item Blade,Handle,SIM,IP,IrPl;
	

	
	public void messyregistItem(){
		Blade=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:").setUnlocalizedName("messy.blade");
		Handle=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:").setUnlocalizedName("messy.Handle");
		SIM=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:").setUnlocalizedName("messy.SIM");
		IP=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:").setUnlocalizedName("messy.IP");
		IrPl=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:").setUnlocalizedName("messy.IrPl");
		
		GameRegistry.registerItem(Blade, "Blade");
		GameRegistry.registerItem(Handle, "Handle");
		GameRegistry.registerItem(SIM, "Soul inclusion machine");
		GameRegistry.registerItem(IP, "Iron Pipe");
		GameRegistry.registerItem(IrPl, "Iron Plate");
		
		OreDictionary.registerOre("plateIron", IrPl);
	
	}
	
	public void messyregistrecipe(){
		
		GameRegistry.addRecipe(new ItemStack(tetscore.vilswe),
				" x ",
				" xy",
				" z ",
				'x',Blade,
				'y',SIM,
				'z',Handle);
		GameRegistry.addRecipe(new ItemStack(IP), 
				"x x",
				"x x",
				"x x",
				'x',Items.iron_ingot);
		
			
		
		
	}
}