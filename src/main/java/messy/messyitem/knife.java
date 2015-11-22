package messy.messyitem;

import java.util.ArrayList;
import java.util.Random;

import com.starsheep.villagersnose.entity.EntityNoselessVillager;

import cpw.mods.fml.common.Loader;
import messy.tetscore;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import schr0.cleaver.api.ICleaverItem;
import thaumcraft.common.config.ConfigItems;

public class knife extends ItemSword implements ICleaverItem {

	public static final EnumRarity RARITY=EnumHelper.addRarity("messyrari", EnumChatFormatting.BLACK, "Chinese kitchen knife");

	private static Random rand=new Random();

	public knife() {
		super(ToolMaterial.IRON);
		setUnlocalizedName("messy.ckk");
		setCreativeTab(tetscore.tet);

	}

	@Override
	public float getCleaverPeelPower(ItemStack stack, EntityLivingBase owner) {

		float i=0;

		if(owner instanceof EntityPlayer){
			EntityPlayer ep=(EntityPlayer)owner;
			i=+ep.experienceLevel;

		}

		return i;
	}

	@Override
	public float getCleaverMaxPeelPower() {

		return 100F;
	}

	@Override
	public float getCleaverAttackAmmount(float rawAttackAmmount, boolean isCritical, EntityLivingBase target,
			float peelPower, ItemStack stack, EntityLivingBase owner) {

		return peelPower*0.1F;
	}

	@Override
	public boolean isCleaverAttack(float attackAmmount, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {

		return true;
	}

	@Override
	public boolean isCleaverPeel(float attackAmmount, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {



		return true;
	}

	@Override
	public void onCleaverAttackAndPeel(boolean isAttack, boolean isPeel, float attackAmmount, boolean isCritical,
			EntityLivingBase target, float peelPower, ItemStack stack, EntityLivingBase owner) {

		if(isPeel){

			if(owner instanceof EntityPlayer){

				for(float i=0F;i<=peelPower;i+=0.1F){


					if(!target.worldObj.isRemote ){
						if(rand.nextInt(100)<=peelPower){
							target.worldObj.spawnEntityInWorld(test(target));
						}else{

							i=peelPower;

						}
					}
				}

			}

		}


	}

	@Override
	public ArrayList<EntityItem> getCleaverKillDrop(ArrayList<EntityItem> killDrop, int lootingLevel,
			boolean recentlyHit, int specialDropValue, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {

		return killDrop;
	}

	@Override
	public void onCleaverKill(boolean isCritical, EntityLivingBase target, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isCleaverEntityInteract(Entity target, float peelPower, ItemStack stack, EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onCleaverEntityInteract(boolean isEntityInteract, Entity target, float peelPower, ItemStack stack,
			EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isCleaverBlockInteract(int blockX, int blockY, int blockZ, int blockFace, Block block,
			int blockMetadata, World world, float peelPower, ItemStack stack, EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onCleaverBlockInteract(boolean isBlockInteract, int blockX, int blockY, int blockZ, int blockFace,
			Block block, int blockMetadata, World world, float peelPower, ItemStack stack, EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onCleaverUpdate(int slot, boolean isHeld, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public float getCleaverHurtAmmount(float rawHurtAmmount, DamageSource damageSource, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public boolean isCleaverHurt(float hurtAmmount, DamageSource damageSource, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onCleaverHurt(boolean isHurt, float hurtAmmount, DamageSource damageSource, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public ArrayList<EntityItem> getCleaverDeathDrop(ArrayList<EntityItem> deathDrop, int lootingLevel,
			boolean recentlyHit, int specialDropValue, DamageSource damageSource, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void onCleaverDeath(DamageSource damageSource, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public ArrayList<ItemStack> getCleaverHarvestDrop(ArrayList<ItemStack> blockDrop, int blockX, int blockY,
			int blockZ, Block block, int blockMetadata, World world, float peelPower, ItemStack stack,
			EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void onCleaverHarvest(int blockX, int blockY, int blockZ, Block block, int blockMetadata, World world,
			float peelPower, ItemStack stack, EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ

	}


	public EntityItem test(EntityLivingBase el){

		EntityItem ei;
		ei=new EntityItem(el.worldObj,el.posX,el.posY,el.posZ);

		if(el instanceof EntityCreeper){


		switch (rand.nextInt(100)) {
		case 0:

			ei.setEntityItemStack(new ItemStack(Blocks.tnt));
			el.setDead();
			break;

		default:

			ei.setEntityItemStack(new ItemStack(Items.gunpowder,5));

			break;
		}


		}

		if(el instanceof EntityGiantZombie){

			switch (rand.nextInt(1000)) {
			case 0:

				if(Loader.isModLoaded("Thaumcraft")){

					ei.setEntityItemStack(new ItemStack(ConfigItems.itemZombieBrain));

				}else{

					ei.setEntityItemStack(new ItemStack(Items.rotten_flesh,rand.nextInt(16)+50));

				}

				el.setDead();
				break;

			default:

				ei.setEntityItemStack(new ItemStack(Items.rotten_flesh,rand.nextInt(5)));

				break;
			}


		}

		if(el instanceof EntityZombie){

			switch (rand.nextInt(100)) {
			case 0:

				if(Loader.isModLoaded("Thaumcraft")){

					ei.setEntityItemStack(new ItemStack(ConfigItems.itemZombieBrain));

				}else{

					ei.setEntityItemStack(new ItemStack(Items.rotten_flesh,rand.nextInt(16)+5));

				}

				el.setDead();
				break;

			default:

				ei.setEntityItemStack(new ItemStack(Items.rotten_flesh,rand.nextInt(5)));

				break;
			}

		}
		if(el instanceof EntitySlime){

			ei.setEntityItemStack(new ItemStack(Items.slime_ball,rand.nextInt(5)));

		}
		if(el instanceof EntitySkeleton){

			switch (rand.nextInt(2)) {
			case 0:

				ei.setEntityItemStack(new ItemStack(Items.bone,rand.nextInt(40)));
				el.setDead();
				break;

			case 1:
				ei.setEntityItemStack(new ItemStack(Items.dye,rand.nextInt(5),15));
			default:
				ei.setEntityItemStack(new ItemStack(Items.bone,rand.nextInt(3)));
				break;
			}

		}
		if(el instanceof EntityEnderman){

			switch (rand.nextInt(3)) {
			case 0:

				ei.setEntityItemStack(new ItemStack(Items.ender_pearl));
				el.setDead();

				break;

			default:
				break;
			}

		}
		if(el instanceof EntityVillager || (Loader.isModLoaded("Villager's Nose")?  el instanceof EntityNoselessVillager : false)){

			switch (rand.nextInt(50)) {
			case 0:

				ei.setEntityItemStack(new ItemStack(tetscore.vh));
				el.setDead();

				break;

			default:
				ei.setEntityItemStack(new ItemStack(tetscore.vm));

				break;
			}

		}

		return ei;
	}




}
