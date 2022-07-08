package com.Jongyeol.vegan.debuf;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class v70 {
    public static void effect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30, 0, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 30, 0, true, false));
    }
}
