package com.niklashanft.spottedmc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class PlayerIsMovingEvent implements Listener {

    private final UUID bignick3 = UUID.fromString("9dbd3e7b-88e8-4299-800b-a6b157ee97ff");

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(!e.getPlayer().getUniqueId().equals(bignick3)) {
            return;
        }

        //Location location = e.getPlayer().getLocation();
        //e.getPlayer().sendMessage(ChatColor.RED + "X: " + location.getBlockX() + " Y:" + location.getBlockY() + " Z: " +location.getBlockZ());
    }

}
