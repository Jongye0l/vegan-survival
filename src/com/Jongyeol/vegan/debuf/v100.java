package com.Jongyeol.vegan.debuf;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class v100 {
    public static void effect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 0, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 0, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 120, 0, true, false));
    }
}
