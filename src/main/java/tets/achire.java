package tets;


import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class achire {
	
	
	public static Achievement Murderer,Homicidalmaniac,GOD;
	public static Achievement[] messylist;
	public static AchievementPage Messyac;
	public static final String newAchievement = "MessyMod";
	
	public static void register(){
		
		Murderer=(new Achievement("murder", "murder", 0, 1, new ItemStack(tetscore.vh),AchievementList.killEnemy)).
				initIndependentStat().registerStat();
		Homicidalmaniac=(new Achievement("Homicidal maniac", "homicidal maniac", 0, 3, new ItemStack(tetscore.vm),Murderer)).
				initIndependentStat().setSpecial().registerStat();
		GOD=(new Achievement("GOD", "GOD", 2, 5, new ItemStack(tetscore.rnhd), Homicidalmaniac)).
				initIndependentStat().setSpecial().registerStat();
		messylist=new Achievement[]{
				Murderer,Homicidalmaniac,GOD
		};
		Messyac=new AchievementPage(newAchievement, messylist);
		AchievementPage.registerAchievementPage(Messyac);
		
	}
	
	

}