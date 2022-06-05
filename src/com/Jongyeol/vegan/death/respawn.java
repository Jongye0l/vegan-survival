package com.Jongyeol.vegan.death;

import com.Jongyeol.vegan.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
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
        FileConfiguration config = Main.getPlugin().getConfig();
        int regenhealth = config.getInt("regenhealth");
        boolean regenresethungry = config.getBoolean("regenresethungry");
        int hunger = event.getPlayer().getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "hunger"), PersistentDataType.INTEGER);
        new BukkitRunnable(){
            @Override
            public void run() {
                if(!regenresethungry){ event.getPlayer().setFoodLevel(hunger); }
                event.getPlayer().setHealth(regenhealth);
            }
        }.runTaskLater(plugin, 1);
        event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "hunger"), PersistentDataType.INTEGER, 0);
    }
}
