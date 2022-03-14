package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class addvegan {
    public static void Remove(Player player, String text) {
        int vegan = player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER);
        vegan++;
        vegan++;
        vegan++;
        player.sendMessage(ChatColor.RED + text + "를 먹어 비건 수치가 올랐습니다.");
        player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, vegan);
        begunaction.SendActionbar(player);
    }
}
