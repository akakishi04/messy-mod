package messy.messyitem;

import messy.tetscore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class hknife extends Item {

	public hknife() {
		
		setUnlocalizedName("messy.Knife");
		setCreativeTab(tetscore.tet);
		setTextureName("tete:kn");
		setMaxDamage(100);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		
		if(entity instanceof EntityVillager){
			
			stack.damageItem(1, player);
			
			if(!player.worldObj.isRemote)player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ, new ItemStack(tetscore.vh)));
			
			entity.attackEntityFrom(DamageSource.cactus,500);
			if(!entity.isDead){
				
				entity.setDead();
			}
			
		}
		
		return super.onLeftClickEntity(stack, player, entity);
	}
	
}
