package messy.mesev;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import jp.plusplus.fbs.tileentity.render.RenderMagicCircle;
import messy.tets.EnPro;
import net.minecraftforge.client.event.TextureStitchEvent;

public class OEH {


	 @SubscribeEvent
	    public void onSwitchTexture(TextureStitchEvent.Pre e){

	        if(e.map.getTextureType()==0){

	        	if(Loader.isModLoaded("jp-plusplus-fbs")){
	            RenderMagicCircle.RegisterMagicCircleIcon("rainvil", e.map, "tete:circlevil");
	            RenderMagicCircle.RegisterMagicCircleIcon("expl", e.map, "tete:circlesom");
	        	}
	        }
	    }
	 @SubscribeEvent
	 public void onPlayerTick(TickEvent.PlayerTickEvent event){
		 
		 EnPro epro=EnPro.get(event.player);
		 
		 if(event.phase==TickEvent.Phase.START && !event.player.worldObj.isRemote){
		 if(epro.ispomil()){
			
			 if(new Random().nextInt(16)<3 && epro.getAcount()>0){
				 epro.setAcount(epro.getAcount()-1);
				
			 }
			 if(epro.getAcount()==0){
				 epro.setpomil(false);
			 }
			
		 }

	 }
	 
	 }
}
