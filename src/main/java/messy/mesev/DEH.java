package messy.mesev;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import messy.tetscore;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class DEH {
	
	@SubscribeEvent
	public void digspeed(PlayerEvent.BreakSpeed event){
		
		if(event.entityPlayer.getHeldItem()==new ItemStack(tetscore.bedrockStick)){
			if(event.block ==  Blocks.bedrock){
			event.newSpeed = event.originalSpeed*50;
			}
			else if(event.block != Blocks.bedrock){
				event.newSpeed= event.originalSpeed*0;
			}
		}
		
		
	}
	
}
