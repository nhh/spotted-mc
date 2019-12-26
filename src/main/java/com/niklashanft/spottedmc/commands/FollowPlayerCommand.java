package com.niklashanft.spottedmc.commands;

import com.niklashanft.spottedmc.SpottedMcPlugin;
import com.niklashanft.spottedmc.util.PlayersWhoAreFollowing;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FollowPlayerCommand implements CommandExecutor {

    private final SpottedMcPlugin plugin;


    public FollowPlayerCommand(SpottedMcPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!command.getName().equalsIgnoreCase("follow")) {
            return false;
        }

        final Player follower = (Player) sender;

        if(args.length == 0) {
            follower.sendMessage("Receiver or Follower does not exist!");
            return false;
        }

        final Player receiver = Bukkit.getPlayer(args[0]);

        if (receiver == null) {
            follower.sendMessage("Receiver or Follower does not exist!");
            return false;
        }

        Thread t = new Thread(() -> {
            try {

                while(true) {

                    Location loc = receiver.getLocation();
                    follower.sendMessage("You followed " + receiver.getDisplayName());

                    Bukkit.getScheduler().callSyncMethod(plugin, () -> {
                        follower.teleport(loc);
                        return true;
                    });

                    Thread.sleep(5000);

                }

            } catch (InterruptedException e) {
                //e.printStackTrace();
            }

        });

        t.start();

        PlayersWhoAreFollowing.INSTANCE.addFollower(follower.getUniqueId(), t);

        return true;

    }

}
