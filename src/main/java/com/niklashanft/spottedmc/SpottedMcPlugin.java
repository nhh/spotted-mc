package com.niklashanft.spottedmc;

import com.niklashanft.spottedmc.commands.*;
import com.niklashanft.spottedmc.events.OnPlayerAttackEvent;
import com.niklashanft.spottedmc.events.PlayerDiedEvent;
import com.niklashanft.spottedmc.events.PlayerIsMovingEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SpottedMcPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new PlayerIsMovingEvent(), this);
        pm.registerEvents(new PlayerDiedEvent(), this);
        pm.registerEvents(new OnPlayerAttackEvent(), this);

        this.getCommand("follow").setExecutor(new FollowPlayerCommand(this));
        this.getCommand("unfollow").setExecutor(new UnfollowPlayerCommand(this));
        this.getCommand("delspot").setExecutor(new DelSpotCommand(this));
        this.getCommand("setspot").setExecutor(new SetSpotCommand(this));
        this.getCommand("gospot").setExecutor(new GoSpotCommand(this));
        this.getCommand("spots").setExecutor(new SpotsCommand(this));
    }


    @Override
    public void onDisable(){
        // Fired when the server stops and disables all plugins
    }
}
