package tets;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import jp.plusplus.fbs.packet.MessagePlayerJoinInAnnouncement;
import jp.plusplus.fbs.packet.MessagePlayerJoinInAnoucementHandler;
import jp.plusplus.fbs.packet.MessagePlayerProperties;
import jp.plusplus.fbs.packet.MessagePlayerPropertiesHandler;

public class PacketHandler {
	  public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("tets");
	  
	    public static void init() {
	        /*Messageクラスの登録。
	        * 第一引数：IMessageHandlerクラス
	        * 第二引数：送るMessageクラス
	        * 第三引数：登録番号。255個まで
	        * 第四引数：ClientとServerのどちらに送るか。送り先*/
	        INSTANCE.registerMessage(MessagePlayerPropertiesHandler.class, MessagePlayerProperties.class, 0, Side.CLIENT);
	        INSTANCE.registerMessage(MessagePlayerJoinInAnoucementHandler.class, MessagePlayerJoinInAnnouncement.class, 1, Side.SERVER);
}
}