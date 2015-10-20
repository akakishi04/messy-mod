package messy.tets;



import messy.tetscore;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class achire {


	public static Achievement Murderer,Homicidalmaniac,GOD;
	public static Achievement villagereater,Haid,villagerfall;
	public static Achievement[] messylist;
	public static AchievementPage Messyac;
	public static final String newAchievement = "MessyMod";

	public static void register(){

		Murderer=(new Achievement("murderer", "murderer", 0, 1, new ItemStack(tetscore.vh),AchievementList.killEnemy)).
				initIndependentStat().registerStat();
		Homicidalmaniac=(new Achievement("Homicidal maniac", "homicidal maniac", 0, 3, new ItemStack(tetscore.vm),Murderer)).
				initIndependentStat().setSpecial().registerStat();
		GOD=(new Achievement("GOD", "GOD", 2, 5, new ItemStack(tetscore.rnhd), Homicidalmaniac)).
				initIndependentStat().setSpecial().registerStat();
		villagereater=(new Achievement("Villager Eater", "Villager Eater", -4, 0, new ItemStack(tetscore.ckvm),null)).
				initIndependentStat().registerStat();


		Haid=(new Achievement("How about in decoration?", "How about in decoration?", 4, 0, new ItemStack(tetscore.endercrystal), null)).
				initIndependentStat().registerStat();

		villagerfall=(new Achievement("When a villager fall","When a villager fall", -1,3,new ItemStack(tetscore.villagermeteo), Murderer)).
				initIndependentStat().registerStat();

		messylist=new Achievement[]{
				Murderer,Homicidalmaniac,GOD,villagereater,Haid,villagerfall
		};

		Messyac=new AchievementPage(newAchievement, messylist);
		AchievementPage.registerAchievementPage(Messyac);

	}



}
