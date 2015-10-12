package messy.mesev;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jp.plusplus.fbs.api.FBSEntityPropertiesAPI;
import messy.tetscore;
import messy.tets.EnPro;
import messy.tets.achire;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class LDeEH {

	@SubscribeEvent
	public void onLivingDeadEvent(LivingDeathEvent event){

		if (tetscore.villagerskilllosesan == true && event.entityLiving instanceof EntityVillager && event.source.getEntity() instanceof EntityPlayer) {

			EntityPlayer player=(EntityPlayer)event.source.getEntity();
			EnPro pro =EnPro.get(player);


				if(pro.getkillcount()>=1){

					player.addStat(achire.Murderer, 1);

				}
				if(pro.getkillcount()>=10000){

					player.addStat(achire.Homicidalmaniac, 1);

				}
				if(pro.getkillcount()>=1000000){

					player.addStat(achire.GOD, 1);

				}
			if(Loader.isModLoaded("jp-plusplus-fbs")){
			if(pro.getkillcount()<500){
			FBSEntityPropertiesAPI.LoseSanity(player, 1, 4, true);


			}else if (pro.getkillcount()>=500 && pro.getkillcount()<=5000) {

			}else if (pro.getkillcount()>5000 && tetscore.villagerkilladdsan==true){
			FBSEntityPropertiesAPI.AddSanity(player, 1, 4, true);
			}
			}

			if(pro != null){
				pro.setkillcount(pro.getkillcount()+1);

				//player.addChatComponentMessage(new ChatComponentText(pro.getkill()));
				}

		}

	}

}
