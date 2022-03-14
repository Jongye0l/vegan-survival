package com.Jongyeol.vegan;

import com.Jongyeol.vegan.Consumables.click;
import com.Jongyeol.vegan.death.death;
import com.Jongyeol.vegan.death.respawn;
import com.Jongyeol.vegan.vegan.JoinVegan;
import com.Jongyeol.vegan.vegan.eat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventListener implements Listener {
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        JoinVegan.OnJoin(event);
    }
    @EventHandler
    public void OnEat(PlayerItemConsumeEvent event) { eat.Oneat(event); }
    @EventHandler
    public void OnClick(PlayerInteractEvent event) { click.OnClick(event); }
    @EventHandler
    public void OnDeath(PlayerDeathEvent event) { death.OnDeath(event); }
}
