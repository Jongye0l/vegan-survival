package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Consumables.Item;
import com.Jongyeol.vegan.actionbar.RepeatAction;
import com.Jongyeol.vegan.death.respawn;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new respawn(this), this);
        BukkitTask RepeatAction = new RepeatAction().runTaskTimer(this, 0L, 20L);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        Item.init();
    }
    @Override
    public void onDisable() {  }
    public static Main getPlugin() {
        return plugin;
    }
}
