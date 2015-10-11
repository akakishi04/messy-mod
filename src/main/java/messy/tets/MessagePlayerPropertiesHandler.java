package messy.tets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerPropertiesHandler implements IMessageHandler<MPP, IMessage>{

	 @Override
	    public IMessage onMessage(MPP message, MessageContext ctx) {
	        //Client側にIExtendedEntityPropertiesを渡す。
	        EnPro.get(messy.tetscore.proxy.getEntityPlayerInstance()).loadNBTData(message.data);
	        //REPLYは送らないので、nullを返す。
	        return null;
	    }

}
