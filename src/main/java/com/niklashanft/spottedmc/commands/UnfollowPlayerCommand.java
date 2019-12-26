package com.niklashanft.spottedmc.commands;

import com.niklashanft.spottedmc.SpottedMcPlugin;
import com.niklashanft.spottedmc.util.PlayersWhoAreFollowing;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnfollowPlayerCommand implements CommandExecutor {

    private final SpottedMcPlugin plugin;

    public UnfollowPlayerCommand(SpottedMcPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("unfollow")) {
            return false;
        }
        final Player follower = (Player) sender;
        PlayersWhoAreFollowing.INSTANCE.stopFollowing(follower.getUniqueId());
        return true;
    }

}
