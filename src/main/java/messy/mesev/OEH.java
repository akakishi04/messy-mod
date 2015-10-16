package messy.mesev;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jp.plusplus.fbs.tileentity.render.RenderMagicCircle;
import net.minecraftforge.client.event.TextureStitchEvent;

public class OEH {

	
	 @SubscribeEvent
	    public void onSwitchTexture(TextureStitchEvent.Pre e){
	       
	        if(e.map.getTextureType()==0){
	            
	          
	            RenderMagicCircle.RegisterMagicCircleIcon("rainvil", e.map, "tete:circlevil");
	        }
	    }
	
	
}
