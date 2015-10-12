package messy;

import java.io.File;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.plusplus.fbs.Registry;
import jp.plusplus.fbs.api.FBSRecipeAPI;
import messy.mesev.LDEH;
import messy.mesev.LDeEH;
import messy.messyblock.Blocktrte;
import messy.messyblock.blockcross;
import messy.messyblock.brof;
import messy.messyitem.forceofredlife;
import messy.messyitem.icry;
import messy.messyitem.irnhd;
import messy.messyitem.ivh;
import messy.messyitem.ivm;
import messy.tets.CommonProxy;
import messy.tets.EntityPropertiesEventHandler;
import messy.tets.PacketHandler;
import messy.tets.RDelete;
import messy.tets.Recipe;
import messy.tets.ViSu;
import messy.tets.achire;
import messy.tets.bcrr;
import messy.tets.croosr;
import messy.tets.dtil;
import messy.tets.tetsoregen;
import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

@Mod(modid=tetscore.MODID)
public class tetscore {

	public static final String MODID = "MessyMOD";

	public static Block trte;
	public static Block cross;
	public static Block rofb;
	public static Item vh;
	public static Item vm;
	public static Item rnhd;
	public static Item ckvm;
	public static Item fotrl;
	public static Item bakedbed;
	public static Item endercrystal,endercrystalsingle;


	public static CreativeTabs tet;







	public static boolean rrecipe,cpsrd,trtecre,trtegen,crosscre,villagerskilllosesan,villagerkilladdsan;
	public static boolean cb;
	public static int crn;

	 @SidedProxy(clientSide = "messy.tets.ClientProxy", serverSide = "messy.tets.CommonProxy")
	 public static CommonProxy proxy;

	@SideOnly(Side.CLIENT)
	public static int blockcrossr = RenderingRegistry.getNextAvailableRenderId();


	@EventHandler
	static void preInit(FMLPreInitializationEvent event){

		cfload();


		tet=new CreativeTabs("messy") {

			@Override
			public Item getTabIconItem() {
				// TODO 自動生成されたメソッド・スタブ
				return vh;
			}
		};

		trte=new Blocktrte();
		cross=new blockcross();
		vh=new ivh();
		vm=new ivm();
		rnhd=new irnhd();
		rofb=new brof();
		ckvm=new messy.messyitem.ckvm();
		fotrl=new forceofredlife();
		bakedbed=new messy.messyitem.bakedbed();
		endercrystal=new icry().setUnlocalizedName("mendercrystal").setMaxDamage(8);
		endercrystalsingle=new icry().setUnlocalizedName("mendercrystalsingle").setMaxDamage(1);




		if(trtecre ==true){
		GameRegistry.registerBlock(trte, "trte");
		}

		if(cb==true){
		GameRegistry.registerBlock(cross, "Cross");
		}
		GameRegistry.registerBlock(rofb, "rotten flesh block");
		GameRegistry.registerItem(vh, "villager's heart");
		GameRegistry.registerItem(vm, "villager's meat");
		GameRegistry.registerItem(rnhd, "rotten no heart doll");
		GameRegistry.registerItem(ckvm, "cooked Villager's meat");
		GameRegistry.registerItem(fotrl, "force of red life");
		GameRegistry.registerItem(bakedbed, "bakedbed");
		GameRegistry.registerItem(endercrystal, "endercrystal");
		GameRegistry.registerItem(endercrystalsingle, "endercrystal (singleuse)");
	

		
		achire.register();



		 PacketHandler.init();

	}
	@EventHandler
	public void Init(FMLInitializationEvent event){

		GameRegistry.registerTileEntityWithAlternatives(dtil.class, "dtil");


		if(cpsrd==false && Loader.isModLoaded("ProjectE")){
		RDelete.DeleteRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone));
		}

		MinecraftForge.ORE_GEN_BUS.register(this);



		MinecraftForge.EVENT_BUS.register(new LDEH());
		MinecraftForge.EVENT_BUS.register(new LDeEH());

		if(rrecipe==true && Loader.isModLoaded("ProjectE")){
		Recipe.addrecipe(crn);
		}

		Recipe.recipe();
		Recipe.smelterrecipe();
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			ClientRegistry.bindTileEntitySpecialRenderer(dtil.class, new croosr());;
			RenderingRegistry.registerBlockHandler(new bcrr());
		}

		 EntityPropertiesEventHandler enPro =new EntityPropertiesEventHandler();
		 MinecraftForge.EVENT_BUS.register(enPro);
		 FMLCommonHandler.instance().bus().register(enPro);
		 if(Loader.isModLoaded("DCsAppleMilk")){
		 RecipeRegisterManager.plateRecipe.register(new ItemStack(vm), new ItemStack(ckvm), 160, false);
		 }
		 if(Loader.isModLoaded("jp-plusplus-fbs")){
		 Registry.RegisterBook("ViSu", 1, true, 1, 1, 1, 1, 1);
		 Registry.RegisterMagic("ViSu", "ViSu", 20, 1, 3, 4, ViSu.class);
		 //FBSRecipeAPI.AddMagic("ViSu", 1, 1f, 0.3F, 1, 3, 10, "ViSu", 100, 60, 10, 15, ViSu.class);
		
		 FBSRecipeAPI.AddMagicCircle("ViSu",
				 		"0f1f0",
				 		"f010f",
				 		"11 11",
				 		"f010f",
				 		"0f1f0");
		 }
	}


	@SubscribeEvent
	public void generateOrePost(OreGenEvent.Post event){

		if(trtecre == true){

		WorldGenerator generator=new WorldGenMinable(trte, 9);
		if(TerrainGen.generateOre(event.world, event.rand, generator, event.worldX, event.worldZ, OreGenEvent.GenerateMinable.EventType.CUSTOM));

		if(trtegen==true){
			GameRegistry.registerWorldGenerator(new tetsoregen(), 0);
			}
		}
	}




	public static void cfload(){
		Configuration cfg=new Configuration(new File("./config/"+"messy.cfg"));
        cfg.load();
        cb=cfg.getBoolean("c", "block", false, "");
        rrecipe=cfg.getBoolean("add crafting philosStone recipe", "ProjectE", true , "私が独自に追加した賢者の石のレシピを使うか?");
        cpsrd=cfg.getBoolean("not delete defalt philiosstorne recipe", "ProjectE", false, "賢者の石のレシピを消さないでおくか?");
        trtecre=cfg.getBoolean("add trte", "blocks", true, "");
        trtegen=cfg.getBoolean("generate trte in world","generate" , true, "もし、trteの追加がされない場合はこれは無視される");
        villagerskilllosesan=cfg.getBoolean("Sanity lose when you have killed the villagers", "TFK", true, "村人を殺した時にSAN値が減るがよいか？");
        villagerkilladdsan=cfg.getBoolean("Sanity recovery when you have killed a lot of villagers", "TFK", true, "村人を殺せばSAN値が回復するようになるよ");

        crn=cfg.getInt("craftting philosstone recipe", "ProjectE", 2, 1, 2, "賢者の石のレシピはどれがいい? もしレシピが追加されない場合はこれは無視される 現在２つしかないよ");
        cfg.save();
	}



}
