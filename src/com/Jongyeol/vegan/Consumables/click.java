package com.Jongyeol.vegan.Consumables;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

public class click {
    public static void OnClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            OnRightClick(event);
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            OnRightClick(event);
        }
    }
    public static void OnRightClick(PlayerInteractEvent event) {
        if(event.getItem() != null) {
            if(event.getItem().getItemMeta().equals(Item.Consumables.getItemMeta())) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                player.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, 0);
                int i = event.getItem().getAmount();
                i--;
                event.getItem().setAmount(i);
                player.sendMessage(ChatColor.AQUA + "아이템을 사용하여 비건이 초기화되었습니다.");
                begunaction.SendActionbar(player);
            }
        }
    }
}
