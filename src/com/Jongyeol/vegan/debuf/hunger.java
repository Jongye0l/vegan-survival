package com.Jongyeol.vegan.debuf;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class hunger {
    public static void Hunger(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 30, 2, true, false));
    }
}
