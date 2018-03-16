package enigma.xandaros.nitwit;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CreatureSpawnListener implements Listener {
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Villager villager;
        if (!(event.getEntity() instanceof Villager)) {
            return;
        }
        villager = (Villager)event.getEntity();
        if (villager.getCareer() == Villager.Career.NITWIT) {
            addRecipes(villager);
        }
    }

    private static void addRecipes(Villager villager) {
        ArrayList<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(shulkerRecipe());
        recipes.add(elytraRecipe());
        recipes.add(totemRecipe());

        villager.setRecipes(recipes);
    }

    private static MerchantRecipe shulkerRecipe() {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.SHULKER_SHELL), 10);
        recipe.addIngredient(new ItemStack(Material.EMERALD, ThreadLocalRandom.current().nextInt(10, 31)));
        return recipe;
    }

    private static MerchantRecipe elytraRecipe() {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.ELYTRA), 10);
        recipe.addIngredient(new ItemStack(Material.NETHER_STAR, 64));
        recipe.addIngredient(new ItemStack(Material.EMERALD, ThreadLocalRandom.current().nextInt(30, 65)));
        return recipe;
    }

    private static MerchantRecipe totemRecipe() {
        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.TOTEM), 10);
        recipe.addIngredient(new ItemStack(Material.WHEAT, ThreadLocalRandom.current().nextInt(40, 65)));
        recipe.addIngredient(new ItemStack(Material.BLAZE_ROD, ThreadLocalRandom.current().nextInt(16, 37)));
        return recipe;
    }
}
