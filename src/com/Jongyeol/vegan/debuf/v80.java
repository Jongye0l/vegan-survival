package com.Jongyeol.vegan.debuf;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class v80 {
    public static void effect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 30, 1, true, false));
    }
}
