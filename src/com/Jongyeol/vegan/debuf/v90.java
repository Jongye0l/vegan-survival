package com.Jongyeol.vegan.debuf;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class v90 {
    public static void effect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 30, 2, true, false));
    }
}
