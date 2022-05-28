package com.Jongyeol.vegan.death;

import com.Jongyeol.vegan.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class respawn implements Listener {
    Main plugin;
    public respawn(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void OnRespawn(PlayerRespawnEvent event) {
        int hunger = event.getPlayer().getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "hunger"), PersistentDataType.INTEGER);
        new BukkitRunnable(){
            @Override
            public void run() {
                event.getPlayer().setFoodLevel(hunger);
                event.getPlayer().setHealth(1);
            }
        }.runTaskLater(plugin, 1);
        event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "hunger"), PersistentDataType.INTEGER, 0);
    }
}
