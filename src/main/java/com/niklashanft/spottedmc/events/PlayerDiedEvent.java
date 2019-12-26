package com.niklashanft.spottedmc.events;

import com.niklashanft.spottedmc.util.SpotService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDiedEvent implements Listener {

    @EventHandler
    public void onPlayerDying(PlayerDeathEvent e) {

        final SpotService spotService = new SpotService();
        final Player player = e.getEntity();

        // Creates a e.g bignick3-rip spot
        spotService.createSpot(player.getDisplayName().toLowerCase() + "-rip", player);
    }

}
