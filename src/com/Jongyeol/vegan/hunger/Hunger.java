package com.Jongyeol.vegan.hunger;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.Begunaction;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Hunger {
    public static void Resethunger(Player player){
        Main.getPlugin().getConfig().set("Player.hunger." + player.getUniqueId(), (float) player.getFoodLevel());
        Main.getPlugin().saveConfig();
    }
    public static void FoodChange(FoodLevelChangeEvent event){
        Player player = (Player) event.getEntity();
        float hunger = (float) Main.getPlugin().getConfig().getDouble("Player.hunger." + player.getUniqueId());
        if(event.getEntity().getFoodLevel() > event.getFoodLevel()) hunger -= event.getEntity().getFoodLevel() - event.getFoodLevel();
        if(event.getEntity().getFoodLevel() < event.getFoodLevel() && event.getItem() != null){
            int i = 1;
            float addhunger;
            for(addhunger = event.getFoodLevel() - (float) event.getEntity().getFoodLevel() / 10; event.getItem().getAmount() > i && hunger + addhunger < 20; ++i) hunger += addhunger;
            if(player.getInventory().getItemInMainHand().getType().equals(event.getItem().getType())) player.getInventory().getItemInMainHand().setAmount(event.getItem().getAmount() - i + 1);
            else player.getInventory().getItemInOffHand().setAmount(event.getItem().getAmount() - i + 1);
            hunger += addhunger;
        }
        if(hunger > 20){
            hunger = 20f;
        }
        event.setCancelled(true);
        event.getEntity().setFoodLevel((int) hunger);
        Main.getPlugin().getConfig().set("Player.hunger." + player.getUniqueId(), hunger);
        Main.getPlugin().saveConfig();
        Begunaction.SendActionbar(player);
    }
}
