package com.Jongyeol.vegan.vegan;

import com.Jongyeol.vegan.noteat.NotEat;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Eat {
    public static void Oneat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        NotEat.setEat(player);
        switch(event.getItem().getType()) {
            case COOKED_BEEF: AddVegan.Remove(player, event, "익힌 소고기");
            case BEEF: AddVegan.Remove(player, event, "소고기");
            case COOKED_CHICKEN: AddVegan.Remove(player, event, "익힌 닭고기");
            case CHICKEN: AddVegan.Remove(player, event, "닭고기");
            case COOKED_PORKCHOP: AddVegan.Remove(player, event, "익힌 돼지고기");
            case PORKCHOP: AddVegan.Remove(player, event, "돼지고기");
            case COOKED_COD: AddVegan.Remove(player, event, "익힌 대구");
            case COD: AddVegan.Remove(player, event, "대구");
            case COOKED_SALMON: AddVegan.Remove(player, event, "익힌 연어");
            case SALMON: AddVegan.Remove(player, event, "연어");
            case TROPICAL_FISH: AddVegan.Remove(player, event, "열대어");
            case COOKED_RABBIT: AddVegan.Remove(player, event, "익힌 토끼고기");
            case RABBIT: AddVegan.Remove(player, event, "토끼고기");
            case COOKED_MUTTON: AddVegan.Remove(player, event, "익힌 양고기");
            case MUTTON: AddVegan.Remove(player, event, "양고기");
            case RABBIT_STEW: AddVegan.Remove(player, event, "토끼스튜");
            case ROTTEN_FLESH: AddVegan.Remove(player, event, "썩은고기");
            case MILK_BUCKET: Milk.milk(event);
        }
    }
}