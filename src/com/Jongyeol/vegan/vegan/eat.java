package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.noteat.NotEat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class eat {
    public static void Oneat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        NotEat.setEat(player);
        if(event.getItem().getType().equals(Material.COOKED_BEEF)) { addvegan.Remove(player, event, "익힌 소고기"); }
        if(event.getItem().getType().equals(Material.BEEF)) { addvegan.Remove(player, event, "소고기"); }
        if(event.getItem().getType().equals(Material.COOKED_CHICKEN)) { addvegan.Remove(player, event, "익힌 닭고기"); }
        if(event.getItem().getType().equals(Material.CHICKEN)) { addvegan.Remove(player, event, "닭고기"); }
        if(event.getItem().getType().equals(Material.COOKED_PORKCHOP)) { addvegan.Remove(player, event, "익힌 돼지고기"); }
        if(event.getItem().getType().equals(Material.PORKCHOP)) { addvegan.Remove(player, event, "돼지고기"); }
        if(event.getItem().getType().equals(Material.COOKED_COD)) { addvegan.Remove(player, event, "익힌 대구"); }
        if(event.getItem().getType().equals(Material.COOKED_SALMON)) { addvegan.Remove(player, event, "익힌 연어"); }
        if(event.getItem().getType().equals(Material.TROPICAL_FISH)) { addvegan.Remove(player, event, "열대어"); }
        if(event.getItem().getType().equals(Material.COD)) { addvegan.Remove(player, event, "대구"); }
        if(event.getItem().getType().equals(Material.SALMON)) { addvegan.Remove(player, event, "연어"); }
        if(event.getItem().getType().equals(Material.COOKED_RABBIT)) { addvegan.Remove(player, event, "익힌 토끼고기"); }
        if(event.getItem().getType().equals(Material.RABBIT)) { addvegan.Remove(player, event, "토끼고기"); }
        if(event.getItem().getType().equals(Material.COOKED_MUTTON)) { addvegan.Remove(player, event, "익힌 양고기"); }
        if(event.getItem().getType().equals(Material.MUTTON)) { addvegan.Remove(player, event, "양고기"); }
        if(event.getItem().getType().equals(Material.RABBIT_STEW)) { addvegan.Remove(player, event, "토끼스튜"); }
        if(event.getItem().getType().equals(Material.ROTTEN_FLESH)) { addvegan.Remove(player, event, "썩은고기"); }
        if(event.getItem().getType().equals(Material.MILK_BUCKET)) { Milk.Milk(event); }
    }
}