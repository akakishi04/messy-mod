package messy.mesev;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import jp.plusplus.fbs.api.FBSEntityPropertiesAPI;
import jp.plusplus.fbs.api.event.PlayerUseMagicEvent;
import jp.plusplus.fbs.packet.MessagePlayerProperties;
import jp.plusplus.fbs.packet.PacketHandler;
import jp.plusplus.fbs.tileentity.render.RenderMagicCircle;
import messy.tetscore;
import messy.mesmagic.ViSu;
import messy.tets.EnPro;
import messy.tets.achire;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class OEH {

	@SubscribeEvent
	public void onSwitchTexture(TextureStitchEvent.Pre e) {

		if (e.map.getTextureType() == 0) {

			if (Loader.isModLoaded("jp-plusplus-fbs")) {
				RenderMagicCircle.RegisterMagicCircleIcon("rainvil", e.map, "tete:circlevil");
				RenderMagicCircle.RegisterMagicCircleIcon("expl", e.map, "tete:circlesom");
				RenderMagicCircle.RegisterMagicCircleIcon("blsu", e.map, "tete:blmg");
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {

		EnPro epro = EnPro.get(event.player);

		if (event.phase == TickEvent.Phase.START && !event.player.worldObj.isRemote) {
			if (epro.ispomil()) {

				if (epro.getAcount() > 0) {
					epro.setAcount(epro.getAcount() - 1);

				}
				if (epro.getAcount() == 0) {
					epro.setpomil(false);
				}

			}

		}

	}

	@SubscribeEvent
	public void oneatevent(PlayerUseItemEvent.Start event) {
		EntityPlayer enp = event.entityPlayer;
		EnPro ep = EnPro.get(event.entityPlayer);

		if (event.item.getItem() == Items.milk_bucket && ep.ispomil() && !enp.capabilities.isCreativeMode) {
			event.setCanceled(true);
			enp.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 60 * 2, 5));
			enp.addPotionEffect(new PotionEffect(Potion.weakness.id, 20 * 60 * 2, 10));
			enp.addPotionEffect(new PotionEffect(Potion.harm.id, 2));
		}
	}

	@SubscribeEvent
	public void oneatenevent(PlayerUseItemEvent.Finish event) {
		EntityPlayer enp = event.entityPlayer;
		EnPro ep = EnPro.get(event.entityPlayer);

		if (event.item.getItem() == tetscore.sop && ep.ispomil() && !enp.worldObj.isRemote) {
			PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(enp), (EntityPlayerMP) enp);
		}
	}

	@SubscribeEvent
	public void ohe(LivingHurtEvent event) {
		if (!event.entityLiving.worldObj.isRemote && event.source.getEntity() instanceof EntityPlayer
				&& event.entityLiving instanceof EntityVillager) {

			EntityPlayer ep = (EntityPlayer) event.source.getEntity();
			if (ep.inventory.getCurrentItem() != null) {
				if (ep.getHeldItem().getItem() == tetscore.vilswe) {
					NBTTagCompound nbt = ep.getHeldItem().stackTagCompound;
					float damage = event.ammount;
					if (nbt != null) {
						event.ammount = 0;

					}

				}
			}

		}

	}

	@SubscribeEvent
	public void ohe(PlaySoundAtEntityEvent event){

		if(event.entity instanceof EntityVillager && event.entity.getEntityData().hasKey("mincer")&& event.name.equals("mob.villager.hit") ){

			event.setCanceled(true);

		}

	}

	@SubscribeEvent
	public void PlayerUseMagicEvent(PlayerUseMagicEvent event){
		if (event.magic instanceof ViSu){

			event.entityPlayer.addStat(achire.Haid, 1);

		}

	}

	@SubscribeEvent
	public void onLivingDropsEvent(LivingDropsEvent event) {
		if (event.entity instanceof EntityVillager) {

			EntityVillager ev = (EntityVillager) event.entity;
			EntityPlayer ep = null;
			MerchantRecipeList mrl = ev.getRecipes(ep);

			if (mrl != null && !Loader.isModLoaded("tragicVillager")) {

				for (Object lo : mrl) {
					MerchantRecipe lml = (MerchantRecipe) lo;
					ev.entityDropItem(lml.getItemToSell(), 0.0F);
				}

			}
			if (event.source.getEntity() instanceof EntityPlayer) {

				event.entityLiving.dropItem(tetscore.vm, event.entityLiving.worldObj.rand.nextInt(5) + 3);
			}
		}
		if (event.entityLiving instanceof EntityVillager && event.source == DamageSource.fall) {
			EntityVillager ev=(EntityVillager)event.entityLiving;
			if(ev.getCustomNameTag()=="爆弾"){
				event.drops.clear();
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeadEvent(LivingDeathEvent event){

		if ( event.entityLiving instanceof EntityVillager && event.source.getEntity() instanceof EntityPlayer) {

			EntityPlayer player=(EntityPlayer)event.source.getEntity();
			EnPro pro =EnPro.get(player);
			EntityVillager EnV=(EntityVillager)event.entityLiving;



			if(pro != null){
				pro.setkillcount(pro.getkillcount()+1);

				//player.addChatComponentMessage(new ChatComponentText(pro.getkill()));
				}

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



		}
		if(event.entityLiving instanceof EntityVillager ){

			EntityVillager ev =(EntityVillager) event.entity;
			if( event.source==DamageSource.fall){
			if(ev.getCustomNameTag()=="爆弾"){
			event.entity.worldObj.newExplosion(event.entity, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ,
					5F, false, true);}
			else if(event.source==DamageSource.lava){
				if(ev.getCustomNameTag()=="爆弾"){
					ev.worldObj.setBlockToAir((int)ev.posX, (int)ev.posY, (int)ev.posZ);
			}
			}

			}
		}
		if(event.entityLiving instanceof EntityPlayer){
			EnPro ep= EnPro.get((EntityPlayer)event.entity);
			ep.setAcount(0);
			ep.setpomil(false);
		}

	}
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
