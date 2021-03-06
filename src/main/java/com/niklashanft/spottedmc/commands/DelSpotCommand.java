package com.niklashanft.spottedmc.commands;

import com.niklashanft.spottedmc.SpottedMcPlugin;
import com.niklashanft.spottedmc.util.SpotService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelSpotCommand implements CommandExecutor {

    private final SpottedMcPlugin plugin;

    public DelSpotCommand(SpottedMcPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("delspot")) {
            return false;
        }

        final Player player = (Player) sender;
        final SpotService spotService = new SpotService();

        if (args.length == 0) {
            player.sendMessage("No spot name provided!");
            return false;
        }

        final String spotName = args[0];
        spotService.deleteSpot(spotName, player);
        return true;
    }

}
