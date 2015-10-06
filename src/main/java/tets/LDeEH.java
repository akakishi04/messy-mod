package tets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jp.plusplus.fbs.api.FBSEntityPropertiesAPI;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class LDeEH {
	
	@SubscribeEvent
	public void onLivingDeadEvent(LivingDeathEvent event){
		
		if (tetscore.villagerskill == true && event.entityLiving instanceof EntityVillager && event.source.getEntity() instanceof EntityPlayer) {
			
			EntityPlayer player=(EntityPlayer)event.source.getEntity();
			
			FBSEntityPropertiesAPI.LoseSanity(player, 1, 3, true);
			EnPro pro =EnPro.get(player);
			//if(pro != null){
			pro.setkillcount(pro.getkillcount()+1);
			player.addChatComponentMessage(new ChatComponentText(pro.getkill()));
			//}
		}
		
	}

}
