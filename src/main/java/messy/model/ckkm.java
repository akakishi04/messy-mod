package messy.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ckkm extends ModelBiped {
	
	ModelRenderer e;
    ModelRenderer ha1;
    ModelRenderer patu4;
    ModelRenderer patu1;
    ModelRenderer patu21;
    ModelRenderer patu22;
    ModelRenderer patu31;
    ModelRenderer patu32;


    ModelRenderer patu41;
    ModelRenderer patu42;
    ModelRenderer patu43;
    ModelRenderer patu51;
    ModelRenderer patu52;
    ModelRenderer patu53;
    ModelRenderer epatu1;
	    ModelRenderer ha6;
	    ModelRenderer ha71;
	    ModelRenderer ha72;
	    ModelRenderer ha73;
	    ModelRenderer ha74;
	  
	  public ckkm()
	  {
	    textureWidth = 512;
	    textureHeight = 32;
	    
	    e = new ModelRenderer(this, 66, 0);
	      e.addBox(-1F, 0F, -1F, 2, 26, 2);
	      e.setRotationPoint(0F, -5F, 0F);
	      e.setTextureSize(512, 32);
	      e.mirror = true;
	      setRotation(e, 0F, 0F, 0F);
	      ha1 = new ModelRenderer(this, 0, 0);
	      ha1.addBox(-1.5F, -21F, -3F, 3, 21, 11);
	      ha1.setRotationPoint(0F, -5F, 0F);
	      ha1.setTextureSize(512, 32);
	      ha1.mirror = true;
	      setRotation(ha1, 0F, 0F, 0F);
	      patu4 = new ModelRenderer(this, 123, 0);
	      patu4.addBox(-2F, -4F, -3F, 4, 6, 6);
	      patu4.setRotationPoint(0F, 0F, -6F);
	      patu4.setTextureSize(512, 32);
	      patu4.mirror = true;
	      setRotation(patu4, 0.418879F, 0F, 0F);
	      patu1 = new ModelRenderer(this, 79, 0);
	      patu1.addBox(-4F, 0F, -5F, 8, 5, 8);
	      patu1.setRotationPoint(0F, -5F, 0F);
	      patu1.setTextureSize(512, 32);
	      patu1.mirror = true;
	      setRotation(patu1, 0F, 0F, 0F);
	      patu21 = new ModelRenderer(this, 81, 15);
	      patu21.addBox(-1F, -5F, 0F, 1, 6, 1);
	      patu21.setRotationPoint(-1F, -5F, -6F);
	      patu21.setTextureSize(512, 32);
	      patu21.mirror = true;
	      setRotation(patu21, -0.3490659F, 0F, 0F);
	      patu22 = new ModelRenderer(this, 81, 22);
	      patu22.addBox(0F, 0F, 0F, 1, 1, 5);
	      patu22.setRotationPoint(-2F, -10F, -5F);
	      patu22.setTextureSize(512, 32);
	      patu22.mirror = true;
	      setRotation(patu22, 0F, 0F, 0F);
	      patu31 = new ModelRenderer(this, 100, 15);
	      patu31.addBox(0F, -5F, 0F, 1, 6, 1);
	      patu31.setRotationPoint(1F, -5F, -6F);
	      patu31.setTextureSize(512, 32);
	      patu31.mirror = true;
	      setRotation(patu31, -0.3490659F, 0F, 0F);
	      patu32 = new ModelRenderer(this, 99, 22);
	      patu32.addBox(0F, 0F, -5F, 1, 1, 5);
	      patu32.setRotationPoint(1F, -10F, 1F);
	      patu32.setTextureSize(512, 32);
	      patu32.mirror = true;
	      setRotation(patu32, 0F, 0F, 0F);
	     
	      patu41 = new ModelRenderer(this, 183, 0);
	      patu41.addBox(0F, 0F, 0F, 1, 6, 1);
	      patu41.setRotationPoint(-3F, 0F, -7F);
	      patu41.setTextureSize(512, 32);
	      patu41.mirror = true;
	      setRotation(patu41, 0F, 0F, 0F);
	      patu42 = new ModelRenderer(this, 183, 9);
	      patu42.addBox(0F, -3F, 0F, 1, 7, 1);
	      patu42.setRotationPoint(-3F, 8F, -6F);
	      patu42.setTextureSize(512, 32);
	      patu42.mirror = true;
	      setRotation(patu42, 0F, 0F, 0F);
	      patu43 = new ModelRenderer(this, 183, 19);
	      patu43.addBox(0F, 0F, 0F, 1, 1, 10);
	      patu43.setRotationPoint(-3F, 11F, -5F);
	      patu43.setTextureSize(512, 32);
	      patu43.mirror = true;
	      setRotation(patu43, -0.9599311F, 0F, -0.2792527F);
	      patu51 = new ModelRenderer(this, 217, 0);
	      patu51.addBox(0F, 0F, 0F, 1, 6, 1);
	      patu51.setRotationPoint(2F, 0F, -7F);
	      patu51.setTextureSize(512, 32);
	      patu51.mirror = true;
	      setRotation(patu51, 0F, 0F, 0F);
	      patu52 = new ModelRenderer(this, 217, 9);
	      patu52.addBox(0F, 0F, 0F, 1, 7, 1);
	      patu52.setRotationPoint(2F, 5F, -6F);
	      patu52.setTextureSize(512, 32);
	      patu52.mirror = true;
	      setRotation(patu52, 0F, 0F, 0F);
	      patu53 = new ModelRenderer(this, 218, 19);
	      patu53.addBox(0F, 0F, 0F, 1, 1, 10);
	      patu53.setRotationPoint(2F, 11F, -5F);
	      patu53.setTextureSize(512, 32);
	      patu53.mirror = true;
	      setRotation(patu53, -0.9599311F, 0F, 0.2792527F);
	      epatu1 = new ModelRenderer(this, 127, 16);
	      epatu1.addBox(0F, 0F, 0F, 4, 2, 4);
	      epatu1.setRotationPoint(-2F, 0F, -2F);
	      epatu1.setTextureSize(512, 32);
	      epatu1.mirror = true;
	      setRotation(epatu1, 0F, 0F, 0F);
	     
	      ha6 = new ModelRenderer(this, 0, 0);
	      ha6.addBox(0F, 0F, 0F, 3, 21, 11);
	      ha6.setRotationPoint(-1.5F, -47F, -3F);
	      ha6.setTextureSize(512, 32);
	      ha6.mirror = true;
	      setRotation(ha6, 0F, 0F, 0F);
	      ha71 = new ModelRenderer(this, 38, 0);
	      ha71.addBox(0F, -11F, 0F, 1, 20, 12);
	      ha71.setRotationPoint(-1.5F, -16F, 8F);
	      ha71.setTextureSize(512, 32);
	      ha71.mirror = true;
	      setRotation(ha71, 0F, 0.1047198F, 0F);
	      ha72 = new ModelRenderer(this, 38, 0);
	      ha72.addBox(0F, -12F, 0F, 1, 20, 12);
	      ha72.setRotationPoint(0.5F, -15F, 8F);
	      ha72.setTextureSize(512, 32);
	      ha72.mirror = true;
	      setRotation(ha72, 0F, -0.0698132F, 0F);
	      ha73 = new ModelRenderer(this, 38, 0);
	      ha73.addBox(0F, -11F, 0F, 1, 20, 12);
	      ha73.setRotationPoint(0.5F, -36F, 8F);
	      ha73.setTextureSize(512, 32);
	      ha73.mirror = true;
	      setRotation(ha73, 0F, -0.0698132F, 0F);
	      ha74 = new ModelRenderer(this, 38, 0);
	      ha74.addBox(0F, -11F, 0F, 1, 20, 12);
	      ha74.setRotationPoint(-1.5F, -36F, 8F);
	      ha74.setTextureSize(512, 32);
	      ha74.mirror = true;
	      setRotation(ha74, 0F, 0.1047198F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    e.render(f5);
	    ha1.render(f5);
	    patu4.render(f5);
	    patu1.render(f5);
	    patu21.render(f5);
	    patu22.render(f5);
	    patu31.render(f5);
	    patu32.render(f5);
	    patu41.render(f5);
	    patu42.render(f5);
	    patu43.render(f5);
	    patu51.render(f5);
	    patu52.render(f5);
	    patu53.render(f5);
	    epatu1.render(f5);
	    ha6.render(f5);
	    ha71.render(f5);
	    ha72.render(f5);
	    ha73.render(f5);
	    ha74.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }

	
}
