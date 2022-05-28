package com.Jongyeol.vegan.actionbar;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.debuf.hunger;
import com.Jongyeol.vegan.debuf.nausea;
import com.Jongyeol.vegan.debuf.poison;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class begunaction {
    public static void SendActionbar(Player player) {
        if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER) < 0){
            player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER, 0);
        }
        if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER) == 0){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.YELLOW + "비건 수치 : " + player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER)));
            if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER) > 79) { hunger.Hunger(player); }
            if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER) > 89) { poison.poison(player); }
            if(player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER) > 99) { nausea.nausea(player); }
        } else {
            player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER, player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER) - 1);
            int M = player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER) / 60;
            int S = player.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegancancel"), PersistentDataType.INTEGER) - M*60;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "비건 완화제 효과 : " + M + "분 " + S + "초 남음"));
        }
    }
}
