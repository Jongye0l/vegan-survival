package com.Jongyeol.vegan.vegan;

import org.bukkit.event.block.BlockGrowEvent;

import java.util.Random;

public class Grow {
    static Random random = new Random();
    public static void OnGrowing(BlockGrowEvent event) {
        if(random.nextBoolean()) {
            event.setCancelled(true);
        }
    }
}
