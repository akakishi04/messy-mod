package mesev;

import jp.plusplus.fbs.api.event.PlayerUseMagicEvent;
import net.minecraft.util.ChatComponentText;
import tets.ViSu;

public class VMEH {

	public void PUME(PlayerUseMagicEvent event){
		if (event.magic instanceof ViSu){
			
			event.entityPlayer.addChatMessage(new ChatComponentText("tesuto"));
			
		}
			
	}
	
	
}
