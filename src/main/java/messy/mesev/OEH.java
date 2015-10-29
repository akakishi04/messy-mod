package messy.mesev;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import jp.plusplus.fbs.packet.MessagePlayerProperties;
import jp.plusplus.fbs.packet.PacketHandler;
import jp.plusplus.fbs.tileentity.render.RenderMagicCircle;
import messy.tetscore;
import messy.tets.EnPro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;


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
	 public void onPlayerTickEvent(TickEvent.PlayerTickEvent event){
		 
		 EnPro epro=EnPro.get(event.player);

		 if(event.phase==TickEvent.Phase.START && !event.player.worldObj.isRemote){
			 if(epro.ispomil()){
			
				 if( epro.getAcount()>0){
					 epro.setAcount(epro.getAcount()-1);
					
				
				 }
				 if(epro.getAcount()==0){
					 epro.setpomil(false);
				 }
			
			 }
		

		 }
	 
	 }
	 
	 @SubscribeEvent
	 public void oneatevent(PlayerUseItemEvent.Start event){
		 EntityPlayer enp=event.entityPlayer;
		 EnPro ep=EnPro.get(event.entityPlayer);
		 
		 if(event.item.getItem()==Items.milk_bucket && ep.ispomil() && !enp.capabilities.isCreativeMode){
			 event.setCanceled(true);
			 enp.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*60*2, 5));
			 enp.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*60*2, 10));
			 enp.addPotionEffect(new PotionEffect(Potion.harm.id, 2));
		 }
	 }
	 @SubscribeEvent
	 public void oneatenevent(PlayerUseItemEvent.Finish event){
		 EntityPlayer enp=event.entityPlayer;
		 EnPro ep=EnPro.get(event.entityPlayer);
		 
		 if(event.item.getItem()==tetscore.sop && ep.ispomil()&&!enp.worldObj.isRemote){
			   PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(enp), (EntityPlayerMP)enp);
		 }
	 }
}
