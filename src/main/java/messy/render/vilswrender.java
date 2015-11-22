package messy.render;

import org.lwjgl.opengl.GL11;

import messy.model.vilswmodel;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class vilswrender implements IItemRenderer {

	private static final ResourceLocation resource     = new ResourceLocation("tete:textures/items/vilwep.png");

	private vilswmodel modeling;

    public vilswrender()  {
        modeling = new vilswmodel();
    	
    }

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

                return true;

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (helper) {
		case INVENTORY_BLOCK:
		case ENTITY_BOBBING:
		case ENTITY_ROTATION:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		Minecraft.getMinecraft().renderEngine.bindTexture(resource );



		switch (type) {
		case INVENTORY:
			GL11.glRotatef(-5F, 1F, 0.0F,0F);
			GL11.glRotatef(-150, 0.0F,1F, 0.0F);
			GL11.glTranslatef(0.0F, -1.0F, 0.0F);

			break;

		default:
			break;
		}

		GL11.glPushMatrix();
		/*
		 * 位置の調整と色の設定.
		 */
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef(-0.3F, -0.33F, -0.03F);

		GL11.glRotatef(-180F, 1F, 0.0F,0F);
		GL11.glTranslatef(0.7F, -1.0F, 0.0F);

		GL11.glRotatef(-40F, 0F, 0.0F,1F);
		GL11.glRotatef(90, 0.0F,1F, 0.0F);


		modeling.render((Entity)null, 0, 0, 0, 0, 0, 0.0625F);
		
		//new ModelBiped().render((Entity)null, 0F, 0F, 0F,-0.0F, 0.0F, 0.0625F);


		GL11.glPopMatrix();

	}


}
