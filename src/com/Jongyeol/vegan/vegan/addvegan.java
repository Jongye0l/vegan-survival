package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.RepeatAction;
import com.Jongyeol.vegan.actionbar.begunaction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class addvegan {
    public static void Remove(Player player, PlayerItemConsumeEvent event, String text) {
        FileConfiguration config = Main.getPlugin().getConfig();
        int vegan = config.getInt("Player.vegan." + player.getUniqueId());
        int vegancancel = config.getInt("Player.vegancancel." + player.getUniqueId());
        int veganadd = config.getInt("veganadd");
        if(vegancancel != 0){
            return;
        }
        if(vegan > 100){
            vegan = 100;
        }
        if(vegan == 100){
            player.sendMessage(ChatColor.RED + "비건수치가 100이되어 고기를 먹을 수 없습니다.");
            event.setCancelled(true);
            return;
        }
        vegan += veganadd;
        if(vegan > 100){
            vegan = 100;
        }
        player.sendMessage(ChatColor.RED + text + "를 먹어 비건 수치가 올랐습니다.");
        config.set("Player.vegan." + player.getUniqueId(), vegan);
        Main.getPlugin().saveConfig();
        begunaction.SendActionbar(player);
        player.setNoDamageTicks(0);
        BukkitTask Damage = new Damage(player).runTaskTimer(Main.getPlugin(), 0L, 1L);
    }
}
