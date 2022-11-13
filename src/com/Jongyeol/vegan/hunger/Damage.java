package com.Jongyeol.vegan.hunger;

import com.Jongyeol.vegan.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage {
    public static void onDamage(EntityDamageEvent event){
        if(event.getEntity().getType().equals(EntityType.PLAYER)) {
            Player player = (Player) event.getEntity();
            float hunger = (float) Main.getPlugin().getConfig().getDouble("Player.hunger." + player.getUniqueId());
            event.setDamage(event.getDamage() * (3 - hunger/10f));
        }
    }
}
