package messy.tets;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EnPro implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "messymodprop";

	private int villagerkillcount = 0;
	private int Acount=0;
	private boolean pomil=false;

	 public static void register(EntityPlayer player) {
	        player.registerExtendedProperties(EXT_PROP_NAME, new EnPro());
	    }
	 public static EnPro get(EntityPlayer player) {
	        return (EnPro)player.getExtendedProperties(EXT_PROP_NAME);
	    }

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		 NBTTagCompound nbt=new NBTTagCompound();
		 nbt.setInteger("villagerkillcount",this.villagerkillcount );
		 nbt.setInteger("Acount",this.Acount );
		 nbt.setBoolean("pomil", this.pomil);
		 compound.setTag(EXT_PROP_NAME, nbt);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		 NBTTagCompound nbt=compound.getCompoundTag(EXT_PROP_NAME);
		villagerkillcount= nbt.getInteger("villagerkillcount");
		Acount=nbt.getInteger("Acount");
		pomil=nbt.getBoolean("pomil");
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setkillcount(int c){

		villagerkillcount = c;

		return ;

	}
	public int getkillcount(){

		return villagerkillcount;

	}
	public void setAcount(int c){
		Acount = c;
	}
	public int getAcount(){
		return Acount;
	}
	public void setpomil(boolean b){
		pomil=b;
	}
	public boolean ispomil(){
		return pomil;
	}
	
	public String getkill(){
		return String.valueOf(villagerkillcount);
	}
	public void onEntityJoinWorld(EntityJoinWorldEvent event)  {
        if (event.world.isRemote && event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.entity;
            PacketHandler.INSTANCE.sendToServer(new MessagePlayerJoinInAnnouncement(player));
        }
    }

}
