package messy.tets;


import java.util.Random;

import appeng.api.AEApi;
import appeng.api.definitions.IBlocks;
import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IItems;
import appeng.api.definitions.IMaterials;
import appeng.api.definitions.IParts;
import appeng.api.util.AEColor;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.economy.api.RecipeManagerEMT;
import defeatedcrow.addonforamt.economy.api.order.OrderBiome;
import defeatedcrow.addonforamt.economy.api.order.OrderSeason;
import defeatedcrow.addonforamt.economy.api.order.OrderType;
import jp.plusplus.fbs.Registry;
import jp.plusplus.fbs.api.FBSRecipeAPI;
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
import messy.messyitem.hknife;
import messy.messyitem.idemd;
import messy.messyitem.isspsw;
import messy.messyitem.ivibrationsword;
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
	public static Item dep,demd,trswe;
	public static Item vibrationsword,Vfs,CKK,bloodtea,kni;
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
		kni=new hknife();

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
		GameRegistry.registerItem(kni, "knife");

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
		GameRegistry.addShapelessRecipe(new ItemStack(demd,4), tetscore.fotrl,register.dep,register.dep,register.dep,register.dep);

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

		GameRegistry.addRecipe(new ItemStack(kni),
				"x",
				"y",
				'x',CuBl,
				'y',Items.stick);

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
			FBSRecipeAPI.AddMagic("Κλήτευση του μαύρου πόρτα",25,0.2F,5200,4,2,5, "summon", 100, 10000, 3, 10, blacksummon.class);
			//Κλήτευση του μαύρου πόρτα
			 FBSRecipeAPI.AddMagicCircle("blsu",
					 "55555",
					 "5DAD5",
					 "5D D5",
					 "5DDD5",
					 "55555"
					 );

			Registry.RegisterChestContent(0, new ItemStack(dep,rand.nextInt(15)), 1);
			Registry.RegisterChestContent(1, new ItemStack(dep,rand.nextInt(15)), 1);

			Registry.RegisterShapelessRecipe(new ItemStack(demd), 100, dep);


		}

		if(Loader.isModLoaded("Schr0sCleaver")){
			//CKK=new knife();

			//GameRegistry.registerItem(CKK, "Chinese kitchen knife");


		}



	}

	public void EMCrg(){



		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Items.spawn_egg,1,120), 32860);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vh,1), 5000);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vm,1), 10);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.trte,1),200);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(Irdu,1), 256);
		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(dep,1), 410);

		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(tetscore.vilswe), 0);
		
		registEMC(Items.sugar, 32);

		ProjectEAPI.getEMCProxy().registerCustomEMC("plateIron", 256);
		ProjectEAPI.getEMCProxy().registerCustomEMC("dustIron", 256);

		if(tetscore.issettingEMC){

			AE2EMC();

		}


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

	public void AE2EMC(){
		if(Loader.isModLoaded("appliedenergistics2")){
			
			/*
			 * Transparent	:   0
			 * Black		:   2
			 * Blue			: 108
			 * Brown		:  16
			 * Cyan			:  54
			 * Gray			:   4
			 * Green		:   0
			 * LightBlue	:   2
			 * LightGray	:   2
			 * Lime			:   3
			 * Magenta		:   2
			 * Orange		:   1
			 * Pink			:	2
			 * Purple		:  54
			 * Red			:	0
			 * White		:	6
			 * Yellow		:	2
			 */
			
			
			final IDefinitions definitions = AEApi.instance().definitions();
			final IMaterials materials =definitions.materials();
			final IItems items = definitions.items();
			final IBlocks blocks =definitions.blocks();
			final IParts parts =definitions.parts();
			
			
			//Materials
			registEMC(materials.certusQuartzCrystal().maybeStack(1).get(),64);
			registEMC(materials.certusQuartzCrystalCharged().maybeStack(1).get(), 256);
			registEMC(materials.fluixCrystal().maybeStack(1).get(),256);
			registEMC(materials.purifiedCertusQuartzCrystal().maybeStack(1).get(), 32);
			registEMC(materials.purifiedFluixCrystal().maybeStack(1).get(), 128);
			registEMC(materials.purifiedNetherQuartzCrystal().maybeStack(1).get(), 128);
			registEMC(materials.certusQuartzDust().maybeStack(1).get(),32);
			registEMC(materials.netherQuartzDust().maybeStack(1).get(),64);
			registEMC(materials.fluixDust().maybeStack(1).get(),128);
			registEMC(materials.flour().maybeStack(1).get(), 24);
			registEMC(materials.enderDust().maybeStack(1).get(),1024);
			registEMC(materials.skyDust().maybeStack(1).get(),2);
			registEMC(materials.logicProcessorPrint().maybeStack(1).get(), 2048);
			registEMC(materials.engProcessorPrint().maybeStack(1).get(),8192);
			registEMC(materials.calcProcessorPrint().maybeStack(1).get(), 32);
			registEMC(materials.siliconPrint().maybeStack(1).get(), 32);
			registEMC(materials.logicProcessor().maybeStack(1).get(),2144);
			registEMC(materials.engProcessor().maybeStack(1).get(), 8288);
			registEMC(materials.calcProcessor().maybeStack(1).get(),128);
			registEMC(materials.formationCore().maybeStack(1).get(), 1168);
			registEMC(materials.annihilationCore().maybeStack(1).get(), 1264);
			registEMC(materials.fluixPearl().maybeStack(1).get(), 2560);
			registEMC(materials.wireless().maybeStack(1).get(),3522);
			
			registEMC(materials.emptyStorageCell().maybeStack(1).get(), 1282);
			
			registEMC(materials.cell1kPart().maybeStack(1).get(), 2656);
			registEMC(materials.cell4kPart().maybeStack(1).get(),8513 );
			registEMC(materials.cell16kPart().maybeStack(1).get(), 35524);
			registEMC(materials.cell64kPart().maybeStack(1).get(), 116557);
			
			registEMC(materials.cell2SpatialPart().maybeStack(1).get(),20064 );
			registEMC(materials.cell16SpatialPart().maybeStack(1).get(),90080);
			registEMC(materials.cell128SpatialPart().maybeStack(1).get(),370144);
			
			registEMC(materials.blankPattern().maybeStack(1).get(), 2306);
			
			//Blocks
			
			registEMC(blocks.skyStone().maybeStack(1).get(),2);
			registEMC(blocks.quartzGlass().maybeStack(1).get(),161);
			registEMC(blocks.quartzVibrantGlass().maybeStack(1).get(),1090);
			registEMC(blocks.quartz().maybeStack(1).get(), 256);
			registEMC(blocks.quartzChiseled().maybeStack(1).get(),256);
			registEMC(blocks.quartzPillar().maybeStack(1).get(),256);
			registEMC(blocks.quartzStair().maybeStack(1).get(), 384);
			registEMC(blocks.chiseledQuartzStair().maybeStack(1).get(),384);
			registEMC(blocks.quartzPillarStair().maybeStack(1).get(), 384);
			registEMC(blocks.fluix().maybeStack(1).get(), 256);
			registEMC(blocks.fluixStair().maybeStack(1).get(), 384);
			registEMC(blocks.chest().maybeStack(1).get(),6224);
			registEMC(blocks.wireless().maybeStack(1).get(),3827);
			registEMC(blocks.energyCell().maybeStack(1).get(), 929);
			registEMC(blocks.energyCellDense().maybeStack(1).get(),7560);
			
			//Parts
			registEMC(parts.quartzFiber().maybeStack(1).get(), 194);
			registEMC(parts.cableAnchor().maybeStack(1).get(), 47);
			
			registEMC(parts.cableGlass().stack(AEColor.Transparent,1),177);
			registEMC(parts.cableGlass().stack(AEColor.Black,1),179);
			registEMC(parts.cableGlass().stack(AEColor.Blue, 1),285);
			registEMC(parts.cableGlass().stack(AEColor.Brown, 1), 193);
			registEMC(parts.cableGlass().stack(AEColor.Cyan, 1), 231);
			registEMC(parts.cableGlass().stack(AEColor.Gray, 1), 181);
			registEMC(parts.cableGlass().stack(AEColor.Green, 1), 177);
			registEMC(parts.cableGlass().stack(AEColor.LightBlue, 1), 179);
			registEMC(parts.cableGlass().stack(AEColor.LightGray, 1), 179);
			registEMC(parts.cableGlass().stack(AEColor.Lime, 1), 180);
			registEMC(parts.cableGlass().stack(AEColor.Magenta, 1), 179);
			registEMC(parts.cableGlass().stack(AEColor.Orange, 1), 178);
			registEMC(parts.cableGlass().stack(AEColor.Pink, 1), 179);
			registEMC(parts.cableGlass().stack(AEColor.Purple, 1), 231);
			registEMC(parts.cableGlass().stack(AEColor.Red, 1), 177);
			registEMC(parts.cableGlass().stack(AEColor.White, 1), 183);
			registEMC(parts.cableGlass().stack(AEColor.Yellow, 1), 179);
			
			registEMC(parts.cableCovered().stack(AEColor.Transparent,1),225);  
			registEMC(parts.cableCovered().stack(AEColor.Green, 1), 225);
			registEMC(parts.cableCovered().stack(AEColor.Red, 1), 225);//0
			registEMC(parts.cableCovered().stack(AEColor.Orange, 1), 226);//1
			registEMC(parts.cableCovered().stack(AEColor.Yellow, 1), 227);
			registEMC(parts.cableCovered().stack(AEColor.Black,1),227);
			registEMC(parts.cableCovered().stack(AEColor.LightBlue, 1), 227);
			registEMC(parts.cableCovered().stack(AEColor.LightGray, 1), 227);
			registEMC(parts.cableCovered().stack(AEColor.Magenta, 1), 227);
			registEMC(parts.cableCovered().stack(AEColor.Pink, 1), 227);//2
			registEMC(parts.cableCovered().stack(AEColor.Lime, 1), 228);//3
			registEMC(parts.cableCovered().stack(AEColor.Gray, 1), 229);//4
			registEMC(parts.cableCovered().stack(AEColor.White, 1), 231);//6
			registEMC(parts.cableCovered().stack(AEColor.Brown, 1), 241);//16
			registEMC(parts.cableCovered().stack(AEColor.Cyan, 1), 279);
			registEMC(parts.cableCovered().stack(AEColor.Purple, 1), 279);//54
			registEMC(parts.cableCovered().stack(AEColor.Blue, 1),333);//108
			
			registEMC(parts.cableDense().stack(AEColor.Transparent,1),1348);  
			registEMC(parts.cableDense().stack(AEColor.Green, 1), 1348);
			registEMC(parts.cableDense().stack(AEColor.Red, 1), 1348);//0
			registEMC(parts.cableDense().stack(AEColor.Orange, 1), 1349);//1
			registEMC(parts.cableDense().stack(AEColor.Yellow, 1), 1350);
			registEMC(parts.cableDense().stack(AEColor.Black,1),1350);
			registEMC(parts.cableDense().stack(AEColor.LightBlue, 1), 1350);
			registEMC(parts.cableDense().stack(AEColor.LightGray, 1), 1350);
			registEMC(parts.cableDense().stack(AEColor.Magenta, 1), 1350);
			registEMC(parts.cableDense().stack(AEColor.Pink, 1), 1350);//2
			registEMC(parts.cableDense().stack(AEColor.Lime, 1), 1351);//3
			registEMC(parts.cableDense().stack(AEColor.Gray, 1), 1352);//4
			registEMC(parts.cableDense().stack(AEColor.White, 1), 1354);//6
			registEMC(parts.cableDense().stack(AEColor.Brown, 1), 1364);//16
			registEMC(parts.cableDense().stack(AEColor.Cyan, 1), 1402);
			registEMC(parts.cableDense().stack(AEColor.Purple, 1), 1402);//54
			registEMC(parts.cableDense().stack(AEColor.Blue, 1),1456);//108
			
			registEMC(parts.cableSmart().stack(AEColor.Transparent,1),673);  
			registEMC(parts.cableSmart().stack(AEColor.Green, 1), 673);
			registEMC(parts.cableSmart().stack(AEColor.Red, 1), 673);//0
			registEMC(parts.cableSmart().stack(AEColor.Orange, 1), 674);//1
			registEMC(parts.cableSmart().stack(AEColor.Yellow, 1), 675);
			registEMC(parts.cableSmart().stack(AEColor.Black,1),675);
			registEMC(parts.cableSmart().stack(AEColor.LightBlue, 1), 675);
			registEMC(parts.cableSmart().stack(AEColor.LightGray, 1), 675);
			registEMC(parts.cableSmart().stack(AEColor.Magenta, 1), 675);
			registEMC(parts.cableSmart().stack(AEColor.Pink, 1), 675);//2
			registEMC(parts.cableSmart().stack(AEColor.Lime, 1), 676);//3
			registEMC(parts.cableSmart().stack(AEColor.Gray, 1), 677);//4
			registEMC(parts.cableSmart().stack(AEColor.White, 1), 679);//6
			registEMC(parts.cableSmart().stack(AEColor.Brown, 1), 689);//16
			registEMC(parts.cableSmart().stack(AEColor.Cyan, 1), 727);
			registEMC(parts.cableSmart().stack(AEColor.Purple, 1), 727);//54
			registEMC(parts.cableSmart().stack(AEColor.Blue, 1),781);//108
			
			registEMC(parts.semiDarkMonitor().maybeStack(1).get(), 524);
			registEMC(parts.darkMonitor().maybeStack(1).get(), 524);
			registEMC(parts.monitor().maybeStack(1).get(), 524);
			
			registEMC(parts.terminal().maybeStack(1).get(),5100);
			registEMC(parts.craftingTerminal().maybeStack(1).get(),5260);
			registEMC(parts.patternTerminal().maybeStack(1).get(),13548);
			
			//Items
			registEMC(items.wirelessTerminal().maybeStack(1).get(), 16182);
			
			registEMC(items.cell1k().maybeStack(1).get(), 3938);
			registEMC(items.cell4k().maybeStack(1).get(), 9795);
			registEMC(items.cell16k().maybeStack(1).get(), 36806);
			registEMC(items.cell64k().maybeStack(1).get(),117839);
			
			registEMC(items.spatialCell2().maybeStack(1).get(), 21346);
			registEMC(items.spatialCell16().maybeStack(1).get(),91362 );
			registEMC(items.spatialCell128().maybeStack(1).get(),371426);
			
			registEMC(items.viewCell().maybeStack(1).get(), 1346);
			
		
		}


	}


	private void registEMC(Object Object, int EMC){

		ProjectEAPI.getEMCProxy().registerCustomEMC(Object, EMC);

	}
	
	private int getEMC(ItemStack istack){
		
		return ProjectEAPI.getEMCProxy().getValue(istack);
		
	}
	

}
