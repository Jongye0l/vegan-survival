package com.Jongyeol.vegan.Item;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.Begunaction;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Click {
    public static void OnClick(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR) {
            OnRightClick(event);
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            OnRightClick(event);
        }
    }
    public static void OnRightClick(PlayerInteractEvent event) {
        FileConfiguration config = Main.getPlugin().getConfig();
        if(event.getItem() != null) {
            if(event.getItem().getItemMeta().equals(Item.Consumables.getItemMeta())) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                config.set("Player.vegan." + event.getPlayer().getUniqueId(), 0);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
                player.sendMessage(ChatColor.AQUA + "아이템을 사용하여 비건이 초기화되었습니다.");
                Begunaction.SendActionbar(player);
            }
            if(event.getItem().getItemMeta().equals(Item.Laxative.getItemMeta())) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                config.set("Player.vegan." + event.getPlayer().getUniqueId(), 0);
                config.set("Player.vegancancel." + event.getPlayer().getUniqueId(), 300);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
                player.sendMessage(ChatColor.AQUA + "아이템을 사용하여 비건이 초기화되었습니다.");
                player.sendMessage(ChatColor.AQUA + "아이템을 사용하여 5분간 수치가 오르지 않습니다.");
                Begunaction.SendActionbar(player);
            }
            if(event.getItem().getItemMeta().equals(Item.SmallRemedy.getItemMeta())) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                int vegan = config.getInt("Player.vegan." + event.getPlayer().getUniqueId()) - 10;
                if(vegan < 0){
                    vegan = 0;
                }
                config.set("Player.vegan." + event.getPlayer().getUniqueId(), vegan);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
                player.sendMessage(ChatColor.AQUA + "아이템을 사용하여 비건이 10 줄었습니다.");
                Begunaction.SendActionbar(player);
            }
            Main.getPlugin().saveConfig();
        }
    }
}
