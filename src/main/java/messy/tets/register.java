package messy.tets;


import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.economy.api.RecipeManagerEMT;
import defeatedcrow.addonforamt.economy.api.order.OrderBiome;
import defeatedcrow.addonforamt.economy.api.order.OrderSeason;
import defeatedcrow.addonforamt.economy.api.order.OrderType;
import jp.plusplus.fbs.Registry;
import jp.plusplus.fbs.spirit.SpiritManager;
import jp.plusplus.ir2.Recipes;
import jp.plusplus.ir2.Recipes.RecipeItemStack;
import jp.plusplus.ir2.api.IR3RecipeAPI;
import jp.plusplus.ir2.api.ItemCrystalUnit;
import messy.tetscore;
import messy.mesmagic.blacksummon;
import messy.mesmagic.dragonsummon;
import messy.messyblock.BlockHMM;
import messy.messyblock.bdr;
import messy.messyblock.bsmin;
import messy.messyblock.bworkb;
import messy.messyitem.crystaldust;
import messy.messyitem.idemd;
import messy.messyitem.isspsw;
import messy.messyitem.ivibrationsword;
import messy.messyitem.knife;
import messy.messyitem.vilswep;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.proxy.IEMCProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import shift.mceconomy2.api.MCEconomyAPI;
import shift.sextiarysector.api.recipe.RecipeAPI;

public class register {

	public Random rand=new Random();

	public static Item Blade,Handle,SIM,IP,IrPl,baseSword,CL,Ctei,Ctrpw,trpow,IMoB,SIMA,cutter,trsti,CuBl,Irdu,trstdu;
	public static Item dep,demd;
	public static Item vibrationsword,Vfs,CKK,bloodtea;
	public static Item crystaldustvillager,isspe,cupd,cupdcu,cupm;
	public static Block vilmin,workbench,HMM;
	public static Block bdep;

	private static IEMCProxy emcProxy = ProjectEAPI.getEMCProxy();

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
		dep=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:dragonep").setUnlocalizedName("messy.dragon egg powder");
		demd=new idemd();
		
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
		GameRegistry.registerItem(dep, "dragon egg powder");
		GameRegistry.registerItem(demd, "magic dust of dragon eggs");


		OreDictionary.registerOre("plateIron", IrPl);
		OreDictionary.registerOre("dustIron", Irdu);
		OreDictionary.registerOre("dragoneggpowder", dep);


	}

	public void messyregistblock(){
		vilmin=new bsmin();
		workbench=new bworkb();
		HMM=new BlockHMM();
		bdep=new bdr();

		GameRegistry.registerBlock(vilmin, "VillagerMincer");
		GameRegistry.registerBlock(HMM, "Hypervillagermincer");
		GameRegistry.registerBlock(bdep, "dragon egg magic powder");
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
			IR3RecipeAPI.AddCrushing(new ItemStack(Blocks.dragon_egg),
					new IR3RecipeAPI.CrushPair(1.0F, new ItemStack(dep,64)),
					new IR3RecipeAPI.CrushPair(0.8f, new ItemStack(dep,32)),
					new IR3RecipeAPI.CrushPair(0.8f, new ItemStack(dep,32)));

		}
		if(Loader.isModLoaded("SextiarySector")){

			RecipeAPI.pulverizer.add(new ItemStack(tetscore.trte), new ItemStack(trpow));
			RecipeAPI.pulverizer.add(new ItemStack(Blocks.dragon_egg), new ItemStack(dep,64));

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
		if(!Loader.isModLoaded("jp-plusplus-ir2")){

		GameRegistry.addShapelessRecipe(new ItemStack(Irdu),
				Items.iron_ingot);

		}
		GameRegistry.addSmelting(trstdu, new ItemStack(trsti), 0.5F);

		GameRegistry.addRecipe(new ItemStack(IMoB),
				"xyx",
				"yzy",
				"xyy",
				'x',Ctei,
				'y',IP,
				'z',CL);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Handle),
				new Object[]{
						"xyx",
						"xyx",
						"xzx",
						'x',"plateIron",
						'y',IP,
						'z',trsti
				}));
		GameRegistry.addRecipe(new ItemStack(Items.spawn_egg,1,120),
				"xyx",
				"xzx",
				"xyx",
				'x',tetscore.vm,
				'y',Items.emerald,
				'z',Items.egg);

	}

	public void omodcooreg(){

		if(Loader.isModLoaded("jp-plusplus-ir2")){
			Vfs=new ItemCrystalUnit((short)16,(short)256,60*5).setCreativeTab(null).setTextureName("tete:").setUnlocalizedName("vibrate faintly stone");
			crystaldustvillager=new crystaldust().setCreativeTab(null).setTextureName("tete:dustvillager").setUnlocalizedName("messy.dustvillager");
			cupd=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:cupd").setUnlocalizedName("messy.CrystalUnitProtectionDevice");
			cupdcu=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:cupdcu").setUnlocalizedName("messy.CrystalUnitProtectionDeviceControlUnit");
			cupm=new Item().setCreativeTab(tetscore.tet).setTextureName("tete:cupm").setUnlocalizedName("messy.CrystalUnitProtectionmechanism");

			vibrationsword=new ivibrationsword();


			GameRegistry.registerItem(Vfs, "vibrate faintly stone");
			GameRegistry.registerItem(tetscore.sop, "sop");
			GameRegistry.registerItem(crystaldustvillager, "Crystal Unit Dust Villager");
			GameRegistry.registerItem(vibrationsword, "Vibration sword");


			SpiritManager.registerTool(isspe,vilswep.class);



		}
		if(Loader.isModLoaded("jp-plusplus-fbs")){


			isspe=new isspsw();

			GameRegistry.registerItem(isspe, "iss");

			//SpiritManager.registerSpiritCharacter(true, "");

			Registry.RegisterMagic("", "summon", 270, 5000, 1, 3, dragonsummon.class);
			Registry.RegisterMagic("Κλήτευση του μαύρου πόρτα", "summon", 100, 10000, 3, 10, blacksummon.class);

			Registry.RegisterChestContent(0, new ItemStack(dep,rand.nextInt(15)), 1);
			Registry.RegisterChestContent(1, new ItemStack(dep,rand.nextInt(15)), 1);

		}

		if(Loader.isModLoaded("Schr0sCleaver")){
			CKK=new knife();

			GameRegistry.registerItem(CKK, "Chinese kitchen knife");


		}



	}

	public void EMCrg(){



		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Items.spawn_egg,1,120), 32860);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vh,1), 5000);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vm,1), 10);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.trte,1),200);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Irdu,1), 256);

		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vilswe), 0);

		ProjectEAPI.getEMCProxy().registerCustomEMC("plateIron", 256);
		ProjectEAPI.getEMCProxy().registerCustomEMC("dustIron", 256);

	}

	public void MCE2(){

		if(Loader.isModLoaded("mceconomy2")){

			MCEconomyAPI.addPurchaseItem(new ItemStack(Vfs), 120000);

		}

	}
	public void EMT(){
		if(Loader.isModLoaded("DCsEcoMT")){

			RecipeManagerEMT.orderRegister.addRecipe(new ItemStack(tetscore.vh), 100, 6000000, OrderType.LONG, OrderSeason.NONE, OrderBiome.NONE, "messy.order1");

		}


	}



}
