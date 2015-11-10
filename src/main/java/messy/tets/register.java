package messy.tets;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import jp.plusplus.ir2.Recipes;
import jp.plusplus.ir2.Recipes.RecipeItemStack;
import jp.plusplus.ir2.api.IR3RecipeAPI;
import messy.tetscore;
import messy.messyblock.bsmin;
import messy.messyblock.bworkb;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import shift.sextiarysector.api.recipe.RecipeAPI;

public class register {

	public static Item Blade,Handle,SIM,IP,IrPl,baseSword,CL,Ctei,Ctrpw,trpow,IMoB,SIMA,cutter,trsti,CuBl,Irdu,trstdu;

	public static Block vilmin,workbench;


	public void messyregistItem(){
		Blade=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:ibla").setUnlocalizedName("messy.blade");
		Handle=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:ihan").setUnlocalizedName("messy.Handle");
		SIM=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:isoim").setUnlocalizedName("messy.SIM");
		IP=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:iip").setUnlocalizedName("messy.IP");
		IrPl=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:iple").setUnlocalizedName("messy.IrPl");
		CL=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:icl").setUnlocalizedName("messy.Conductive line");
		Ctei=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:ictei").setUnlocalizedName("messy.Conductive trte ingot");
		Ctrpw=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:icrpw").setUnlocalizedName("messy.Conductive trte powder");
		trpow=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:itrpow").setUnlocalizedName("messy.trte powder");
		IMoB=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:iimob").setUnlocalizedName("messy.Internal mechanism of blade");
		SIMA=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:isim").setUnlocalizedName("messy.SINAttachment");
		cutter=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:icu").setUnlocalizedName("messy.cutter");
		trsti=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:itrsti").setUnlocalizedName("messy.Tr steel");
		CuBl=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:icubl").setUnlocalizedName("messy.Cutter Blade");
		Irdu=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:iirdu").setUnlocalizedName("messy.Iron dust");
		trstdu=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:itrstdu").setUnlocalizedName("messy.tr steel dust");
		
		baseSword=new Ibasesword();
		
		GameRegistry.registerItem(Blade, "Blade");
		GameRegistry.registerItem(Handle, "Handle");
		GameRegistry.registerItem(SIM, "Soul inclusion machine");
		GameRegistry.registerItem(IP, "Iron Pipe");
		GameRegistry.registerItem(IrPl, "Iron Plate");
		GameRegistry.registerItem(baseSword, "BaseSword");
		GameRegistry.registerItem(CL, "Conductive lines");
		GameRegistry.registerItem(Ctei, "Conductive trte ingot");
		GameRegistry.registerItem(Ctrpw, "Conductive trte powder");
		GameRegistry.registerItem(trpow, "trte powder");
		GameRegistry.registerItem(IMoB, "Internal mechanism of blade");
		GameRegistry.registerItem(SIMA, "Soul inclusion machine attachment");
		GameRegistry.registerItem(cutter, "cutter");
		GameRegistry.registerItem(trsti, "Tr steel");
		GameRegistry.registerItem(CuBl, "Cutter Blade");
		GameRegistry.registerItem(Irdu, "Iron Dust");
		GameRegistry.registerItem(trstdu, "tr steel dust");

		OreDictionary.registerOre("plateIron", IrPl);
		OreDictionary.registerOre("dustIron", Irdu);

	}

	public void messyregistblock(){
		vilmin=new bsmin();
		workbench=new bworkb();
		
		GameRegistry.registerBlock(vilmin, "VillagerMincer");
		//GameRegistry.registerBlock(workbench, "workbench");
		
	}

	public void messyregistrecipe(){

		GameRegistry.addRecipe(new ItemStack(baseSword),
				" x ",
				" x ",
				" z ",
				'x',Blade,
				'z',Handle);
		GameRegistry.addRecipe(new ItemStack(IP),
				"xyx",
				"xyx",
				"xyx",
				'x',Items.iron_ingot,
				'y',this.CL);
		
		GameRegistry.addRecipe(new ItemStack(CL), 
				"xxx",
				'x',Ctei);
		
		GameRegistry.addSmelting(Ctrpw, new ItemStack(Ctei), 0.6F);
		
		
			
			GameRegistry.addShapelessRecipe(new ItemStack(register.Ctrpw),
					register.trpow,Items.redstone,register.trpow,Items.redstone
					);
					
			
		if(Loader.isModLoaded("jp-plusplus-ir2")){
			
			//IR3RecipeAPI.AddAlloying(new ItemStack(trpow), new ItemStack(Ctrpw));
			Recipes.addAlloying(new RecipeItemStack(new ItemStack(register.trpow,1), new ItemStack(register.Ctrpw,5)));
			
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(trpow), tetscore.trte);
		
		if(Loader.isModLoaded("jp-plusplus-ir2")){
			
			IR3RecipeAPI.AddCrushing(new ItemStack(tetscore.trte), 
					new IR3RecipeAPI.CrushPair(1.0F,new ItemStack(trpow,4)),
					new IR3RecipeAPI.CrushPair(0.3F, new ItemStack(trpow)),
					new IR3RecipeAPI.CrushPair(0.1F, new ItemStack(Items.quartz)));
			
		}
		if(Loader.isModLoaded("SextiarySector")){
			
			RecipeAPI.pulverizer.add(new ItemStack(tetscore.trte), new ItemStack(trpow));
			
		}
		
		GameRegistry.addRecipe(new ItemStack(SIM),
				"xxx",
				"yyx",
				"xyx",
				'x',tetscore.trte,
				'y',Ctei);
		GameRegistry.addRecipe(new ItemStack(SIMA),
				"xyz",
				"x y",
				"x z",
				'x',Ctei,
				'y',IP,
				'z',SIM);
		GameRegistry.addShapelessRecipe(new ItemStack(tetscore.vilswe),
				baseSword,SIMA);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blade),
				new Object[]{
			"xyx",
			"xyx",
			"xyx",
			'x',"plateIron",
			'y',IMoB
		}));
		
		GameRegistry.addRecipe(new ItemStack(vilmin),
				"xyx",
				"xzx",
				"xyx",
				'x',Blocks.quartz_block,
				'y',cutter,
				'z',Items.emerald);
		
		GameRegistry.addRecipe(new ItemStack(cutter),
				"xxx",
				"x x",
				"xxx",
				'x',CuBl);
		
		GameRegistry.addRecipe(new ItemStack(CuBl),
				"x",
				"x",
				'x',trsti);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(trstdu,2),
				new Object[]{
						"xy",
						"yx",
						'x',trpow,
						'y',"dustIron"
				}));
		GameRegistry.addShapelessRecipe(new ItemStack(Irdu),
				Items.iron_ingot);
		GameRegistry.addSmelting(trstdu, new ItemStack(trsti), 0.5F);
		
		
	}

	public void oregister(){

	

	}



}
