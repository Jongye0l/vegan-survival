package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Command.Vegan;
import com.Jongyeol.vegan.Command.VeganTabCompletion;
import com.Jongyeol.vegan.Item.Item;
import com.Jongyeol.vegan.actionbar.RepeatAction;
import com.Jongyeol.vegan.death.Respawn;
import com.Jongyeol.vegan.noteat.NotEat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getCommand("vegan").setExecutor(new Vegan());;
        getCommand("vegan").setTabCompleter(new VeganTabCompletion());
        getServer().getPluginManager().registerEvents(new Respawn(this), this);
        new RepeatAction().runTaskTimer(this, 0L, 20L);
        new NotEat().runTaskTimer(this, 0L, 80L);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        Item.init();
        final Plugin jongyeolLibrary = Bukkit.getPluginManager().getPlugin("JongyeolLibrary");
        if(jongyeolLibrary == null) {
            getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            String version = jongyeolLibrary.getDescription().getVersion();
            String[] versions = version.split("\\.");
            if(Integer.parseInt(versions[0]) < 1 || Integer.parseInt(versions[1]) < 3 || Integer.parseInt(versions[2]) < 0) {
                getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인에 버전이 지원하지 않는 버전입니다. 업데이트를 해주세요!");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }
    }
    public static Main getPlugin() {
        return plugin;
    }
}
