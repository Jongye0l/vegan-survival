package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Item.Click;
import com.Jongyeol.vegan.hunger.Damage;
import com.Jongyeol.vegan.hunger.Hunger;
import com.Jongyeol.vegan.vegan.Grow;
import com.Jongyeol.vegan.vegan.JoinVegan;
import com.Jongyeol.vegan.vegan.Eat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        JoinVegan.OnJoin(event);
    }
    @EventHandler
    public void OnEat(PlayerItemConsumeEvent event) {
        Eat.Oneat(event);
    }
    @EventHandler
    public void OnClick(PlayerInteractEvent event) {
        Click.OnClick(event);
    }
    @EventHandler
    public void OnHungerChange(FoodLevelChangeEvent event) {
        Hunger.FoodChange(event);
    }
    @EventHandler
    public void OnDamage(EntityDamageEvent event) {
        Damage.onDamage(event);
    }
    @EventHandler
    public void OnGrowing(BlockGrowEvent event) {
        Grow.OnGrowing(event);
    }
}
