package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class JoinVegan {
    public static void OnJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        begunaction.SendActionbar(player);
        if(!player.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(), "Vegan"), PersistentDataType.INTEGER)) {
            player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, 0);
        }
        if(!player.getPersistentDataContainer().has(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER)) {
            player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER, 0);
        }
    }
}
