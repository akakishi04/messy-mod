package messy.mesev;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jp.plusplus.fbs.api.event.PlayerUseMagicEvent;
import messy.mesmagic.ViSu;
import messy.tets.achire;

public class VMEH {

	@SubscribeEvent
	public void PlayerUseMagicEvent(PlayerUseMagicEvent event){
		if (event.magic instanceof ViSu){
			
			event.entityPlayer.addStat(achire.Haid, 1);
			
		}
			
	}
	
	
}
