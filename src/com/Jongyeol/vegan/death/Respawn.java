package com.Jongyeol.vegan.death;

import com.Jongyeol.vegan.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Respawn implements Listener {
    Main plugin;
    public Respawn(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void OnRespawn(PlayerRespawnEvent event) {
        FileConfiguration config = Main.getPlugin().getConfig();
        int regenhealth = config.getInt("regenhealth");
        boolean regenresethungry = config.getBoolean("regenresethungry");
        float hunger = (float)plugin.getConfig().getDouble("Player.hunger." + event.getPlayer().getUniqueId());
        new BukkitRunnable(){
            @Override
            public void run() {
                if(!regenresethungry){ event.getPlayer().setFoodLevel(Math.round(hunger * 10.0F) / 10); }
                event.getPlayer().setHealth(regenhealth);
            }
        }.runTaskLater(plugin, 1);
    }
}
