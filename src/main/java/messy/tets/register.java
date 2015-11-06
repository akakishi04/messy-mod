package messy.tets;

import cpw.mods.fml.common.registry.GameRegistry;
import messy.tetscore;
import messy.messyblock.bsmin;
import messy.messyblock.bworkb;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class register {

	public static Item Blade,Handle,SIM,IP,IrPl;

	public static Block vilmin,workbench;


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

	public void messyregistblock(){
		vilmin=new bsmin();
		workbench=new bworkb();
		
		GameRegistry.registerBlock(vilmin, "VillagerMincer");
		GameRegistry.registerBlock(workbench, "workbench");
		
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

	public void oregister(){

	

	}



}
