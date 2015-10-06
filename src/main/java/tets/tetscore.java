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
import messyitem.inhd;
import messyitem.ivh;
import messyitem.ivm;
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
	
	static Block trte;
	static Block cross;
	static Item vh;
	static Item vm;
	static Item nhd;
	
	static CreativeTabs tet; 
	
	public static boolean rrecipe,cpsrd,trtecre,trtegen,crosscre,villagerskilllosesan,villagerkilladdsan;
	public static int crn;
	
	 @SidedProxy(clientSide = "tets.ClientProxy", serverSide = "tets.CommonProxy")
	 public static CommonProxy proxy;
	
	@SideOnly(Side.CLIENT)
	public static int blockcrossr = RenderingRegistry.getNextAvailableRenderId();

	
	@EventHandler
	static void preInit(FMLPreInitializationEvent event){
		
		cfload();
		
		trte=new Blocktrte();
		cross=new blockcross();
		vh=new ivh();
		vm=new ivm();
		nhd=new inhd();
		
		if(trtecre ==true){
		GameRegistry.registerBlock(trte, "trte");
		}
		
		GameRegistry.registerBlock(cross, "Cross");
		
		GameRegistry.registerItem(vh, "villager's heart");
		GameRegistry.registerItem(vm, "villager's meat");
		GameRegistry.registerItem(nhd, "No heart doll");
		
		
		if(cpsrd==false){
		RDelete.DeleteRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone));
		}
		
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
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			/*
			 * TileEntitySpecialRendererの登録.
			 */
			ClientRegistry.bindTileEntitySpecialRenderer(dtil.class, new croosr());;
			RenderingRegistry.registerBlockHandler(new bcrr());
		}
		
		 EntityPropertiesEventHandler enPro =new EntityPropertiesEventHandler();
		 MinecraftForge.EVENT_BUS.register(enPro);
		 FMLCommonHandler.instance().bus().register(enPro);
		
		 
		 
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
        rrecipe=cfg.getBoolean("add crafting philosStone recipe", "recipe", false , "私が独自に追加した賢者の石のレシピを使うか?");
        cpsrd=cfg.getBoolean("not delete defalt philiosstorne recipe", "recipe", false, "賢者の石のレシピを消さないでおくか?");
        trtecre=cfg.getBoolean("add trte", "blocks", true, "");
        trtegen=cfg.getBoolean("generate trte in world","generate" , true, "もし、trteの追加がされない場合はこれは無視される");
        villagerskilllosesan=cfg.getBoolean("Sanity lose when you have killed the villagers", "TFK", true, "村人を殺した時にSAN値が減るがよいか？");
        villagerkilladdsan=cfg.getBoolean("Sanity recovery when you have killed a lot of villagers", "TFK", true, "村人を殺せばSAN値が回復するようになるよ");
        
        crn=cfg.getInt("craftting philosstone recipe", "recipe", 1, 1, 1, "賢者の石のレシピはどれがいい?","もしレシピが追加されない場合はこれは無視される");
        cfg.save();
	}
	
	

}
