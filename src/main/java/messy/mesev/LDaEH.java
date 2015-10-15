package messy.mesev;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent;

public class LDaEH {
	@SubscribeEvent
	public void Damage(LivingEvent event){
		if(event.entityLiving instanceof EntityVillager){
			EntityVillager ev =(EntityVillager) event.entity;
			if(ev.getCustomNameTag()=="爆弾" && (ev.isInWater()==true || ev.handleLavaMovement())){
				int x=(int) ev.posX;
				int y=(int) ev.posY;
				int z=(int) ev.posZ;
				event.entityLiving.worldObj.setBlock(x, y, z, Blocks.gravel);
			
				ev.setDead();	
			}
			
		}
		
	}

}
