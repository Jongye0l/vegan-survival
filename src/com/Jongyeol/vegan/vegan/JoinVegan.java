package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import com.Jongyeol.vegan.noteat.NotEat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinVegan {
    public static void OnJoin(PlayerJoinEvent event) {
        FileConfiguration config = Main.getPlugin().getConfig();
        if(!config.contains("Player.vegan." + event.getPlayer().getUniqueId())){
            config.set("Player.vegan." + event.getPlayer().getUniqueId(), 0);
            System.out.println(event.getPlayer().getUniqueId() + "(" + event.getPlayer().getName() + ")님에 비건이 생성되었습니다.");
        }
        if(!config.contains("Player.vegancancel." + event.getPlayer().getUniqueId())){
            config.set("Player.vegancancel." + event.getPlayer().getUniqueId(), 0);
            System.out.println(event.getPlayer().getUniqueId() + "(" + event.getPlayer().getName() + ")님에 비건(시간)이 생성되었습니다.");
        }
        if(!config.contains("Player.lastEat." + event.getPlayer().getUniqueId())){
            NotEat.setEat(event.getPlayer());
        }
        begunaction.SendActionbar(event.getPlayer());
        Main.getPlugin().saveConfig();
    }
}
