package messy.tets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class MPP implements IMessage {

	  public NBTTagCompound data;

	    public MPP(){}

	    public MPP(EntityPlayer entityPlayer) {
	        this.data = new NBTTagCompound();
	        //EntityPlayerからIExtendedEntityPropertiesを取得。
	        EnPro.get(entityPlayer).saveNBTData(data);
	    }

	    @Override
	    public void fromBytes(ByteBuf buf) {
	        data = ByteBufUtils.readTag(buf);
	    }

	    @Override
	    public void toBytes(ByteBuf buf) {
	        ByteBufUtils.writeTag(buf, data);
	    }

}
