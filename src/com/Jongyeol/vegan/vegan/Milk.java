package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.debuf.v100;
import com.Jongyeol.vegan.debuf.v70;
import com.Jongyeol.vegan.debuf.v80;
import com.Jongyeol.vegan.debuf.v90;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Milk {
    public static void Milk(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        event.setCancelled(true);
        if(!player.getGameMode().equals(GameMode.CREATIVE)){
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, player.getInventory().getItemInMainHand().getAmount()));
        }
        FileConfiguration config = Main.getPlugin().getConfig();
        int vegan = config.getInt("Player.vegan." + player.getUniqueId());
        for(PotionEffect potionEffect : player.getActivePotionEffects()) {
            if(vegan >= 100 && potionEffect.getType().equals(PotionEffectType.CONFUSION)) { continue; }
            player.removePotionEffect(potionEffect.getType());
        }
        if(vegan >= 70) { v70.effect(player); }
        if(vegan >= 80) { v80.effect(player); }
        if(vegan >= 90) { v90.effect(player); }
        if(vegan >= 100) { v100.effect(player); }
    }
}
