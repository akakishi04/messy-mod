package messy.tets;



import messy.tetscore;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class achire {
	
	
	public static Achievement Murderer,Homicidalmaniac,GOD;
	public static Achievement villagereater,Haid;
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
		villagereater=(new Achievement("Villager Eater", "Villager Eater", -4, 0, new ItemStack(tetscore.ckvm),null)).
				initIndependentStat().registerStat();
		Haid=(new Achievement("How about in decoration?", "How about in decoration?", 4, 0, new ItemStack(Blocks.dragon_egg), null)).
				initIndependentStat().registerStat();
		messylist=new Achievement[]{
				Murderer,Homicidalmaniac,GOD,villagereater,Haid
		};
		Messyac=new AchievementPage(newAchievement, messylist);
		AchievementPage.registerAchievementPage(Messyac);
		
	}
	
	

}
