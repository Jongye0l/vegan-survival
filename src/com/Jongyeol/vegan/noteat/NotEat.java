package com.Jongyeol.vegan.noteat;

import com.Jongyeol.vegan.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class NotEat extends BukkitRunnable{
    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            if(Main.getPlugin().getConfig().getLong("Player.lastEat." + player.getUniqueId()) + 72000 < Bukkit.getWorld("World").getGameTime()){
                player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 120, 2, true, false));
            }
        }
    }
    public static void setEat(Player player){
        Main.getPlugin().getConfig().set("Player.lastEat." + player.getUniqueId(), Bukkit.getWorld("World").getGameTime());
    }
}
