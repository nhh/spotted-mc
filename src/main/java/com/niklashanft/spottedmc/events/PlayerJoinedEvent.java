package com.niklashanft.spottedmc.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinedEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)  {
        for (Player player : Bukkit.getOnlinePlayers()) {

            if(player.getUniqueId().equals(event.getPlayer().getUniqueId())) {
                continue;
            }

            player.sendMessage(event.getPlayer().getDisplayName() + ChatColor.YELLOW + " has joined !");
        }
    }

}
