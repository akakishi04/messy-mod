package tets;

import java.io.File;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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


@Mod(modid="tetstert")
public class tetscore {

	
	static Block trte;
	static Block cross;
	static Item vh;
	
	static CreativeTabs tet; 
	
	public static boolean rrecipe,cpsrd;
	public static int crn;
	
	@SideOnly(Side.CLIENT)
	public static ClientProxy proxy; 
	
	@SideOnly(Side.CLIENT)
	public static int blockcrossr = RenderingRegistry.getNextAvailableRenderId();

	
	@EventHandler
	static void preInit(FMLPreInitializationEvent event){
		
		cfload();
		
		trte=new Blocktrte();
		cross=new blockcross();
		vh=new ivh();
		
		GameRegistry.registerBlock(trte, "trte");
		GameRegistry.registerBlock(cross, "Cross");
		
		GameRegistry.registerItem(vh, "villager's heart");
	
		if(cpsrd==false){
		RDelete.DeleteRecipe(new ItemStack(moze_intel.projecte.gameObjs.ObjHandler.philosStone));
		}
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		GameRegistry.registerTileEntityWithAlternatives(dtil.class, "dtil");
		
		MinecraftForge.ORE_GEN_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new LDEH());
		if(rrecipe==true){
		Recipe.recipe(crn);
		}
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			/*
			 * TileEntitySpecialRendererの登録.
			 */
			ClientRegistry.bindTileEntitySpecialRenderer(dtil.class, new croosr());;
			RenderingRegistry.registerBlockHandler(new bcrr());
		}
	}
		
	
	@SubscribeEvent
	public void generateOrePost(OreGenEvent.Pre event){
		WorldGenerator generator=new WorldGenMinable(trte, 9);
		if(TerrainGen.generateOre(event.world, event.rand, generator, event.worldX, event.worldZ, OreGenEvent.GenerateMinable.EventType.CUSTOM));

	
			GameRegistry.registerWorldGenerator(new tetsoregen(), 0);
	
	
	}

	
	
	public static void cfload(){
		Configuration cfg=new Configuration(new File("./config/"+"tets.cfg"));
        cfg.load();
        rrecipe=cfg.getBoolean("add crafting philosStone recipe", "recipe", false , "");
        cpsrd=cfg.getBoolean("not delete defalt philiosstorne recipe", "recipe", false, "");
        
        crn=cfg.getInt("craftting philosstone recipe", "recipe", 1, 1, 1, "");
        cfg.save();
	}
	
	

}
