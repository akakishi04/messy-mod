package messy.tets;


	import java.util.Iterator;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

	public class RDelete{
	   public static void DeleteRecipe(ItemStack par1ItemStack)
	   {
	      List recipes = CraftingManager.getInstance().getRecipeList();

	      for(Iterator i = recipes.listIterator(); i.hasNext();)
	      {
	         IRecipe recipe = (IRecipe)i.next();
	         ItemStack is = recipe.getRecipeOutput();

	         if(is != null)
	         {
	            if(is.getItem().getIdFromItem(is.getItem()) == par1ItemStack.getItem().getIdFromItem(par1ItemStack.getItem()))
	            {

	               i.remove();
	            }
	         }
	      }
	   }

}
