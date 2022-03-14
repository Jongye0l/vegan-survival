package com.Jongyeol.vegan.death;

import com.Jongyeol.vegan.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataType;

public class death {
    public static void OnDeath(PlayerDeathEvent event) {
        Player player = (Player) event.getEntity();
        player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "hunger"), PersistentDataType.INTEGER, event.getEntity().getFoodLevel());
    }
}
