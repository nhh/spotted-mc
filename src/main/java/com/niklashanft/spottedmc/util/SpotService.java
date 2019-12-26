package com.niklashanft.spottedmc.util;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpotService {

    public void createSpot(String spotName, Player player) {

        final Location spot = player.getLocation();

        Map<String, String> location = new HashMap<>();

        location.put("name", spotName);
        location.put("player", player.getDisplayName());
        location.put("x", String.valueOf(spot.getX()));
        location.put("y", String.valueOf(spot.getY()));
        location.put("z", String.valueOf(spot.getZ()));
        location.put("worldId", player.getWorld().getUID().toString());

        Gson gson = new Gson();

        String json = gson.toJson(location);

        try(FileWriter writer = new FileWriter("./plugins/nhh/spots/" + spotName + ".json")) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            player.sendMessage("Something went wrong while writing to disk: " + e.getMessage());
        }

    }

    public void deleteSpot(final String spotName, Player player) {

        final File file = new File("./plugins/nhh/spots/" + spotName + ".json");

        if (!file.exists()) {
            player.sendMessage("Spot: " + spotName + " deleted.");
        }

        if (!file.isFile()) {
            player.sendMessage("There is something wrong with the file, it seems to be a directory...");
        }

        file.delete();
    }

    public void listAllSpots(Player player) {
        Gson gson = new Gson();
        File spotFolder = new File("./plugins/nhh/spots/");
        File[] files = spotFolder.listFiles();

        for (File file : files) {
            try {
                Map<String, String> spot = gson.fromJson(new FileReader(file.getPath()), Map.class);
                player.sendMessage(spot.get("name") + " from " + spot.get("player"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void goToSpot(String spotName, Player player) {

        try {
            Gson gson = new Gson();

            Map<String, String> map = gson.fromJson(new FileReader("./plugins/nhh/spots/" + spotName + ".json"), Map.class);

            double x = Double.parseDouble(map.get("x"));
            double y = Double.parseDouble(map.get("y"));
            double z = Double.parseDouble(map.get("z"));

            UUID worldID = UUID.fromString(map.get("worldId"));

            World world = Bukkit.getWorld(worldID);

            Location spot = new Location(world, x, y, z);
            player.teleport(spot);
        } catch (IOException e) {
            player.sendMessage("Something went wrong while loading spot: " + e.getMessage());
        }

    }

}
