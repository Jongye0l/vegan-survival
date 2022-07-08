package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Command.vegan;
import com.Jongyeol.vegan.Command.veganTabCompletion;
import com.Jongyeol.vegan.Item.Item;
import com.Jongyeol.vegan.actionbar.RepeatAction;
import com.Jongyeol.vegan.death.respawn;
import com.Jongyeol.vegan.noteat.NotEat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Level;

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
        BukkitTask NotEat = new NotEat().runTaskTimer(this, 0L, 80L);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        Item.init();
        if (Bukkit.getPluginManager().getPlugin("JongyeolLibrary") == null) {
            getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    @Override
    public void onDisable() {  }
    public static Main getPlugin() {
        return plugin;
    }
}
