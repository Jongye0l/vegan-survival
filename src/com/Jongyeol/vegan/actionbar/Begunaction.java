package com.Jongyeol.vegan.actionbar;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.debuf.*;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Begunaction {
    public static void SendActionbar(Player player) {
        FileConfiguration config = Main.getPlugin().getConfig();
        int vegan = config.getInt("Player.vegan." + player.getUniqueId());
        int vegancancel = config.getInt("Player.vegancancel." + player.getUniqueId());
        float hunger = (float)config.getDouble("Player.hunger." + player.getUniqueId());
        if (vegancancel < 0) {
            vegancancel = 0;
            config.set("Player.vegancancel." + player.getUniqueId(), vegancancel);
            Main.getPlugin().saveConfig();
        }
        if (vegancancel == 0) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.YELLOW + "비건 수치 : " + vegan + ChatColor.GREEN + "  배고픔 : " + hunger + "/20"));
            if (vegan >= 70) v70.effect(player);
            if (vegan >= 80) v80.effect(player);
            if (vegan >= 90) v90.effect(player);
            if (vegan >= 100) v100.effect(player);
        } else {
            config.set("Player.vegancancel." + player.getUniqueId(), vegancancel - 1);
            int M = vegancancel / 60;
            int S = vegancancel - M * 60;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "비건 완화제 효과 : " + M + "분 " + S + "초 남음" + ChatColor.GREEN + "  배고픔 : " + hunger + "/20"));
            Main.getPlugin().saveConfig();
        }
    }
}
