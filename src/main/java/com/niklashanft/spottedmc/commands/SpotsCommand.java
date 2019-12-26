package com.niklashanft.spottedmc.commands;

import com.niklashanft.spottedmc.SpottedMcPlugin;
import com.niklashanft.spottedmc.util.SpotService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpotsCommand implements CommandExecutor {

    private final SpottedMcPlugin plugin;

    public SpotsCommand(SpottedMcPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("spots")) {
            return false;
        }
        final Player player = (Player) sender;
        final SpotService spotService = new SpotService();
        spotService.listAllSpots(player);
        return true;
    }

}
