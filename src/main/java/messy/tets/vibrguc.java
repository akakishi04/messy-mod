package messy.tets;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class vibrguc extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("tete:textures/gui/vivgu.png");
	
	public vibrguc(InventoryPlayer iPlayer){
		
		super(new vibratcon(iPlayer));
		this.ySize=181;
		
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseZ) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseZ);
    }
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
	}
	
	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }
	
}
