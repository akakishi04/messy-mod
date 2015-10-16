package messy.mesev;



import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import messy.tetscore;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;


public class LDEH {

	@SubscribeEvent
	public void  onLivingDropsEvent(LivingDropsEvent event ){
		if(event.entity instanceof EntityVillager && event.source.getEntity() instanceof EntityPlayer){



			if(event.entityLiving.worldObj.rand.nextInt(10)==0){
			event.entityLiving.dropItem(tetscore.vh, 1);
			}
			event.entityLiving.dropItem(tetscore.vm, event.entityLiving.worldObj.rand.nextInt(5)+3);
		}
		
		if(event.entityLiving instanceof EntityVillager && event.source==DamageSource.fall){
			event.drops.clear();
		}
	}
 

}
