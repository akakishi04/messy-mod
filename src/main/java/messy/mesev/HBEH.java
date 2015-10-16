package messy.mesev;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import messy.tetscore;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class HBEH {

	@SubscribeEvent
	public void onHarvestBlock(PlayerInteractEvent event) {
        Block block = event.world.getBlock(event.x, event.y, event.z);
        if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK ){
        	if(event.y == 0 && block ==Blocks.bedrock){
        		event.setCanceled(true);
        	}else if(block !=Blocks.bedrock &&equals(event.entityPlayer.getHeldItem()==new ItemStack(tetscore.bedrockStick))){
        		event.setCanceled(true);
        	}
        }
    }

}