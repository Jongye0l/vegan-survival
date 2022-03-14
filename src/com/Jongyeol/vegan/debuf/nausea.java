package com.Jongyeol.vegan.debuf;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class nausea {
    public static void nausea(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 2, true, false));
    }
}
