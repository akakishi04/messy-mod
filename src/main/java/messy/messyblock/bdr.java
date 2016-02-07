package messy.messyblock;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import messy.tetscore;
import messy.tets.register;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class bdr extends Block {

	@SideOnly(Side.CLIENT)
	public IIcon[] icot = new IIcon[10];

	public bdr() {
		super(Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		// setCreativeTab(tetscore.tet);
		setTickRandomly(true);
		setLightLevel(0.3F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		for (int i = 0; i < 10; i++)
			icot[i] = par1IconRegister.registerIcon("tete:dep_" + String.valueOf(i));

	}

	@Override
	public IIcon getIcon(int par1, int par2) {

		return icot[par2];

	}

	@Override
	public int getRenderType() {
		return tetscore.dragone;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

		return register.demd;
	}

	@Override
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {

		return register.demd;
	}

	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
		return p_149742_1_.isBlockNormalCubeDefault(p_149742_2_, p_149742_3_ - 1, p_149742_4_, true);
	}

}
