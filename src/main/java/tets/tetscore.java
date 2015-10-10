package tets;

import java.io.File;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jp.plusplus.fbs.api.FBSRecipeAPI;
import mesev.LDEH;
import mesev.LDeEH;
import messyblock.Blocktrte;
import messyblock.blockcross;
import messyblock.brof;
import messyitem.bakedbed;
import messyitem.forceofredlife;
import messyitem.irnhd;
import messyitem.ivh;
import messyitem.ivm;
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



	public static CreativeTabs tet;







	public static boolean rrecipe,cpsrd,trtecre,trtegen,crosscre,villagerskilllosesan,villagerkilladdsan;
	public static int crn;

	 @SidedProxy(clientSide = "tets.ClientProxy", serverSide = "tets.CommonProxy")
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
		ckvm=new messyitem.ckvm();
		fotrl=new forceofredlife();
		bakedbed=new bakedbed();






		if(trtecre ==true){
		GameRegistry.registerBlock(trte, "trte");
		}

		GameRegistry.registerBlock(cross, "Cross");
		GameRegistry.registerBlock(rofb, "rotten flesh block");
		GameRegistry.registerItem(vh, "villager's heart");
		GameRegistry.registerItem(vm, "villager's meat");
		GameRegistry.registerItem(rnhd, "rotten no heart doll");
		GameRegistry.registerItem(ckvm, "cooked Villager's meat");
		GameRegistry.registerItem(fotrl, "force of red life");
		GameRegistry.registerItem(bakedbed, "bakedbed");



		if(cpsrd==false){
		RDelete.DeleteRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone));
		}

		achire.register();



		 PacketHandler.init();

	}
	@EventHandler
	public void Init(FMLInitializationEvent event){

		GameRegistry.registerTileEntityWithAlternatives(dtil.class, "dtil");




		MinecraftForge.ORE_GEN_BUS.register(this);



		MinecraftForge.EVENT_BUS.register(new LDEH());
		MinecraftForge.EVENT_BUS.register(new LDeEH());

		if(rrecipe==true){
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

		 RecipeRegisterManager.plateRecipe.register(new ItemStack(vm), new ItemStack(ckvm), 160, false);



		 FBSRecipeAPI.AddMagic("ViSu", 1, 1f, 0.3F, 1, 3, 10, "ViSu", 100, 60, 10, 15, ViSu.class);
		 FBSRecipeAPI.AddMagicCircle("ViSu",
				 		"111",
				 		"1 1",
				 		"111");
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
        rrecipe=cfg.getBoolean("add crafting philosStone recipe", "ProjectE", false , "私が独自に追加した賢者の石のレシピを使うか?");
        cpsrd=cfg.getBoolean("not delete defalt philiosstorne recipe", "ProjectE", false, "賢者の石のレシピを消さないでおくか?");
        trtecre=cfg.getBoolean("add trte", "blocks", true, "");
        trtegen=cfg.getBoolean("generate trte in world","generate" , true, "もし、trteの追加がされない場合はこれは無視される");
        villagerskilllosesan=cfg.getBoolean("Sanity lose when you have killed the villagers", "TFK", true, "村人を殺した時にSAN値が減るがよいか？");
        villagerkilladdsan=cfg.getBoolean("Sanity recovery when you have killed a lot of villagers", "TFK", true, "村人を殺せばSAN値が回復するようになるよ");

        crn=cfg.getInt("craftting philosstone recipe", "ProjectE", 2, 1, 2, "賢者の石のレシピはどれがいい? もしレシピが追加されない場合はこれは無視される 現在２つしかないよ");
        cfg.save();
	}



}
