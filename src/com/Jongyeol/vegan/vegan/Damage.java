package com.Jongyeol.vegan.vegan;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Damage extends BukkitRunnable {
    private Player player;
    int i = 0;
    @Override
    public void run() {
        player.damage(0.2);
        player.setNoDamageTicks(0);
        i++;
        if(i > 10){
            player.setNoDamageTicks(20);
            cancel();
        }
    }
    public Damage(Player player){
        this.player = player;
    }
}
