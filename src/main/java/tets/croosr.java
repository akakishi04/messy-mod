package tets;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class croosr extends TileEntitySpecialRenderer {
	private static final ResourceLocation resource     = new ResourceLocation("/textures/entity/zombie/zombie.png");
	private  crm modelcross =new crm();
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z,
			float partialTickTime) {
		this.doRender(tileEntity, x, y, z, partialTickTime);
		
	}
	

	private void doRender(TileEntity tileEntity, double x, double y, double z, float partialTickTime)
	{
		 Minecraft.getMinecraft().renderEngine.bindTexture(resource);

		
		float rot = 0.0F;

	

		GL11.glPushMatrix();
		/*
		 * 位置の調整と色の設定.
		 */
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);

		GL11.glRotatef(-180F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -2.5F, 0.0F);

		
		GL11.glRotatef(rot, 0.0F, 1.0F, 0.0F);

		modelcross.render((Entity)null, 0f, 0f, 0f, 0f, 0f, 0.125f);
		
		//new ModelBiped().render((Entity)null, 0F, 0F, 0F,-0.0F, 0.0F, 0.0625F);
		
		
		GL11.glPopMatrix();
	}

}
