package de.michaelmawick.spawnplugin.listener;

import de.michaelmawick.spawnplugin.SpawnPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!SpawnPlugin.getPlugin().getConfig().getBoolean("spawn.teleport-on-join")) return;

        FileConfiguration config = SpawnPlugin.getPlugin().getConfig();
        Location spawnLocation = new Location(
                Bukkit.getWorld(Objects.requireNonNull(config.getString("spawn.location.world"))),
                config.getInt("spawn.location.x"),
                config.getInt("spawn.location.y"),
                config.getInt("spawn.location.z"),
                config.getInt("spawn.location.yaw"),
                config.getInt("spawn.location.pitch")
        );

        player.teleport(spawnLocation);


    }

}
