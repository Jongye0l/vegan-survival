package com.Jongyeol.vegan.vegan;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class eat {
    public static void Oneat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if(event.getItem().getType().name().equals("COOKED_BEEF")) { addvegan.Remove(player, event, "익힌 소고기"); }
        if(event.getItem().getType().name().equals("BEEF")) { addvegan.Remove(player, event, "소고기"); }
        if(event.getItem().getType().name().equals("COOKED_CHICKEN")) { addvegan.Remove(player, event, "익힌 닭고기"); }
        if(event.getItem().getType().name().equals("CHICKEN")) { addvegan.Remove(player, event, "닭고기"); }
        if(event.getItem().getType().name().equals("COOKED_PORKCHOP")) { addvegan.Remove(player, event, "익힌 돼지고기"); }
        if(event.getItem().getType().name().equals("PORK")) { addvegan.Remove(player, event, "돼지고기"); }
        if(event.getItem().getType().name().equals("COOKED_COD")) { addvegan.Remove(player, event, "익힌 대구"); }
        if(event.getItem().getType().name().equals("COOKED_SALMON")) { addvegan.Remove(player, event, "익힌 연어"); }
        if(event.getItem().getType().name().equals("TROPICAL_FISH")) { addvegan.Remove(player, event, "열대어"); }
        if(event.getItem().getType().name().equals("COD")) { addvegan.Remove(player, event, "대구"); }
        if(event.getItem().getType().name().equals("SALMON")) { addvegan.Remove(player, event, "연어"); }
        if(event.getItem().getType().name().equals("COOKED_RABBIT")) { addvegan.Remove(player, event, "익힌 토끼고기"); }
        if(event.getItem().getType().name().equals("RABBIT")) { addvegan.Remove(player, event, "토끼고기"); }
        if(event.getItem().getType().name().equals("COOKED_MUTTON")) { addvegan.Remove(player, event, "익힌 양고기"); }
        if(event.getItem().getType().name().equals("MUTTON")) { addvegan.Remove(player, event, "양고기"); }
        if(event.getItem().getType().name().equals("RABBIT_STEW")) { addvegan.Remove(player, event, "토끼스튜"); }
        if(event.getItem().getType().name().equals("ROTTEN_FLESH")) { addvegan.Remove(player, event, "썩은고기"); }
    }
}