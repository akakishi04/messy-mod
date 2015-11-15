package messy.model;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class testmodel extends ModelBase{
	IModelCustom mc;

	public testmodel(){

		mc=AdvancedModelLoader.loadModel(new ResourceLocation("tete:model/untitled.obj"));

	}
	public void render(testmodel box, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		ResourceLocation res = new ResourceLocation("");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(res);
		this.render(box, x, y, z);
		GL11.glPopMatrix();
	}

}
