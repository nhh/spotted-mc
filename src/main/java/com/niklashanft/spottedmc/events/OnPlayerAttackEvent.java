package com.niklashanft.spottedmc.events;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class OnPlayerAttackEvent implements Listener {

    @EventHandler
    public void onPlayerAttack(PlayerInteractEvent e) {

        final Player player = e.getPlayer();

        if (e.getAction() != Action.LEFT_CLICK_AIR) {
            return;
        }

        final ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() != Material.TRIDENT) {
            return;
        }

        Vector playerDirection = player.getLocation().getDirection();

        Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);

        arrow.setCritical(true);
        arrow.setPierceLevel(127);
        arrow.setFallDistance(150);
        arrow.setColor(Color.BLUE);
    }

}
