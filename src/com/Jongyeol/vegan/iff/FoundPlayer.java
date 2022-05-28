package com.Jongyeol.vegan.iff;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FoundPlayer {
    public static boolean FoundPlayer(Player player){
        boolean T = false;
        for (Player player2 : Bukkit.getOnlinePlayers()){
            if(player2.equals(player)){T = true;}
        }
        if(T) { return false; }
        return true;
    }
}
