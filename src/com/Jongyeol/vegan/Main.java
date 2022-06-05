package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Command.vegan;
import com.Jongyeol.vegan.Command.veganTabCompletion;
import com.Jongyeol.vegan.Item.Item;
import com.Jongyeol.vegan.Notification.madeby;
import com.Jongyeol.vegan.actionbar.RepeatAction;
import com.Jongyeol.vegan.death.respawn;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getCommand("vegan").setExecutor(new vegan());;
        getCommand("vegan").setTabCompleter(new veganTabCompletion());
        getServer().getPluginManager().registerEvents(new respawn(this), this);
        BukkitTask RepeatAction = new RepeatAction().runTaskTimer(this, 0L, 20L);
        BukkitTask madeby = new madeby().runTaskTimer(this, 0L, 36000L);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        Item.init();
    }
    @Override
    public void onDisable() {  }
    public static Main getPlugin() {
        return plugin;
    }
}
