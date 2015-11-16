package messy.model;



import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class abadon extends ModelBiped {
	
	//fields
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape11;
  
  public abadon()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    Shape8 = new ModelRenderer(this, 44, 0);
    Shape8.addBox(0F, 0F, 0F, 2, 1, 1);
    Shape8.setRotationPoint(2F, -11F, 2.5F);
    Shape8.setTextureSize(64, 32);
    Shape8.mirror = true;
    setRotation(Shape8, 0F, 0F, 0F);
    Shape9 = new ModelRenderer(this, 44, 6);
    Shape9.addBox(0F, 0F, 0F, 2, 1, 1);
    Shape9.setRotationPoint(-4F, -11F, 2.5F);
    Shape9.setTextureSize(64, 32);
    Shape9.mirror = true;
    setRotation(Shape9, 0F, 0F, 0F);
    Shape10 = new ModelRenderer(this, 52, 7);
    Shape10.addBox(-3F, 0F, -2F, 3, 1, 2);
    Shape10.setRotationPoint(-4F, -6F, 3F);
    Shape10.setTextureSize(64, 32);
    Shape10.mirror = true;
    setRotation(Shape10, 0F, -0.4886922F, -0.3490659F);
    Shape12 = new ModelRenderer(this, 0, 9);
    Shape12.addBox(-1F, -1F, -1F, 2, 2, 2);
    Shape12.setRotationPoint(3F, -7.5F, -4F);
    Shape12.setTextureSize(64, 32);
    Shape12.mirror = true;
    setRotation(Shape12, 0.7853982F, 0F, 0F);
    Shape13 = new ModelRenderer(this, 0, 19);
    Shape13.addBox(-1F, -1F, -1F, 2, 2, 2);
    Shape13.setRotationPoint(-3F, -7.5F, -4F);
    Shape13.setTextureSize(64, 32);
    Shape13.mirror = true;
    setRotation(Shape13, 0.7853982F, 0F, 0F);
    Shape14 = new ModelRenderer(this, 9, 9);
    Shape14.addBox(-1F, 0F, -2F, 2, 1, 2);
    Shape14.setRotationPoint(0F, -5F, -4F);
    Shape14.setTextureSize(64, 32);
    Shape14.mirror = true;
    setRotation(Shape14, -0.2094395F, 0F, 0F);
    Shape1 = new ModelRenderer(this, 17, 12);
    Shape1.addBox(0F, 0F, 0F, 1, 4, 8);
    Shape1.setRotationPoint(-4F, -9F, -4F);
    Shape1.setTextureSize(64, 32);
    Shape1.mirror = true;
    setRotation(Shape1, 0F, 0F, 0F);
    Shape2 = new ModelRenderer(this, 34, 12);
    Shape2.addBox(0F, 0F, 0F, 1, 4, 8);
    Shape2.setRotationPoint(3F, -9F, -4F);
    Shape2.setTextureSize(64, 32);
    Shape2.mirror = true;
    setRotation(Shape2, 0F, 0F, 0F);
    Shape3 = new ModelRenderer(this, -2, 13);
    Shape3.addBox(0F, 0F, 0F, 8, 4, 1);
    Shape3.setRotationPoint(-4F, -9F, 3F);
    Shape3.setTextureSize(64, 32);
    Shape3.mirror = true;
    setRotation(Shape3, 0F, 0F, 0F);
    Shape4 = new ModelRenderer(this, 0, 0);
    Shape4.addBox(0F, 0F, 0F, 8, 4, 1);
    Shape4.setRotationPoint(-4F, -9F, -4F);
    Shape4.setTextureSize(64, 32);
    Shape4.mirror = true;
    setRotation(Shape4, 0F, 0F, 0F);
    Shape5 = new ModelRenderer(this, 0, 0);
    Shape5.addBox(0F, 0F, 0F, 8, 0, 8);
    Shape5.setRotationPoint(-4F, -9F, -4F);
    Shape5.setTextureSize(64, 32);
    Shape5.mirror = true;
    setRotation(Shape5, 0F, 0F, 0F);
    Shape6 = new ModelRenderer(this, 34, 0);
    Shape6.addBox(0F, 0F, 0F, 2, 1, 2);
    Shape6.setRotationPoint(2F, -10F, 1.5F);
    Shape6.setTextureSize(64, 32);
    Shape6.mirror = true;
    setRotation(Shape6, 0F, 0F, 0F);
    Shape7 = new ModelRenderer(this, 34, 5);
    Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
    Shape7.setRotationPoint(-4F, -10F, 1.5F);
    Shape7.setTextureSize(64, 32);
    Shape7.mirror = true;
    setRotation(Shape7, 0F, 0F, 0F);
    Shape11 = new ModelRenderer(this, 52, 0);
    Shape11.addBox(0F, 0F, -2F, 3, 1, 2);
    Shape11.setRotationPoint(4F, -6F, 3F);
    Shape11.setTextureSize(64, 32);
    Shape11.mirror = true;
    setRotation(Shape11, 0F, 0.4886922F, 0.3490659F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    
    if(isChild){
    	
    	float f6 = 2.0F;
    	GL11.glPushMatrix();
        GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
        GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
        Shape8.render(f5);
        Shape9.render(f5);
        Shape10.render(f5);
        Shape11.render(f5);
        Shape12.render(f5);
        Shape13.render(f5);
        Shape14.render(f5);
        GL11.glPopMatrix();
       
    	
    }else{
    
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape11.render(f5);
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
	/*  this.Shape1.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape1.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape2.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape2.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape3.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape3.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape4.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape4.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape5.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape5.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape6.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape6.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape7.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape7.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape8.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape8.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape9.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape9.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape10.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape10.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape11.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape11.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape12.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape12.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape13.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape13.rotateAngleX = f4 / (180F / (float) Math.PI);
      this.Shape14.rotateAngleY = f3 / (180F / (float) Math.PI);
      this.Shape14.rotateAngleX = f4 / (180F / (float) Math.PI);
     


      float f6;
      float f7;

      if (this.isSneak) {
          this.Shape1.rotationPointY = 1.0F;
          this.Shape2.rotationPointY = 1.0F;
          this.Shape3.rotationPointY = 1.0F;
          this.Shape4.rotationPointY = 1.0F;
          this.Shape5.rotationPointY = 1.0F;
          this.Shape6.rotationPointY = 1.0F;
          this.Shape7.rotationPointY = 1.0F;
          this.Shape8.rotationPointY = 1.0F;
          this.Shape9.rotationPointY = 1.0F;
          this.Shape10.rotationPointY = 1.0F;
          this.Shape11.rotationPointY = 1.0F;
          this.Shape12.rotationPointY = 1.0F;
          this.Shape13.rotationPointY = 1.0F;
          this.Shape14.rotationPointY = 1.0F;
          
      } else {
          this.Shape1.rotationPointY = 0.0F;
          this.Shape2.rotationPointY = 0.0F;
          this.Shape3.rotationPointY = 0;
          this.Shape4.rotationPointY = 0;
          this.Shape5.rotationPointY = 0;
          this.Shape6.rotationPointY = 0;
          this.Shape7.rotationPointY = 0;
          this.Shape8.rotationPointY = 0;
          this.Shape9.rotationPointY = 0;
          this.Shape10.rotationPointY = 0;
          this.Shape11.rotationPointY = 0;
          this.Shape12.rotationPointY = 0;
          this.Shape13.rotationPointY =0;
          this.Shape14.rotationPointY = 0;
          
	  
      }*/
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
	
}
