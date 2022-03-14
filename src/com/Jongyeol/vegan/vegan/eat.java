package com.Jongyeol.vegan.vegan;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class eat {
    public static void Oneat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if(event.getItem().getType().name().equals("COOKED_BEEF")) { addvegan.Remove(player, "익힌 소고기"); }
        if(event.getItem().getType().name().equals("RAW_BEEF")) { addvegan.Remove(player, "소고기"); }
        if(event.getItem().getType().name().equals("COOKED_CHICKEN")) { addvegan.Remove(player, "익힌 닭고기"); }
        if(event.getItem().getType().name().equals("RAW_CHICKEN")) { addvegan.Remove(player, "닭고기"); }
        if(event.getItem().getType().name().equals("COOKED_PORKCHOP")) { addvegan.Remove(player, "익힌 돼지고기"); }
        if(event.getItem().getType().name().equals("PORK")) { addvegan.Remove(player, "돼지고기"); }
        if(event.getItem().getType().name().equals("COOKED_FISH")) { addvegan.Remove(player, "익힌 생선"); }
        if(event.getItem().getType().name().equals("RAW_FISH")) { addvegan.Remove(player, "생선"); }
        if(event.getItem().getType().name().equals("COOKED_RABBIT")) { addvegan.Remove(player, "익힌 토끼고기"); }
        if(event.getItem().getType().name().equals("RABBIT")) { addvegan.Remove(player, "토끼고기"); }
        if(event.getItem().getType().name().equals("COOKED_MUTTON")) { addvegan.Remove(player, "익힌 양고기"); }
        if(event.getItem().getType().name().equals("MUTTON")) { addvegan.Remove(player, "양고기"); }
        if(event.getItem().getType().name().equals("RABBIT_STEW")) { addvegan.Remove(player, "토끼스튜"); }
        if(event.getItem().getType().name().equals("ROTTEN_FLESH")) { addvegan.Remove(player, "썩은고기"); }
    }
}