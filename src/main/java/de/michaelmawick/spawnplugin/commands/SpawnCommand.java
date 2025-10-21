package de.michaelmawick.spawnplugin.commands;

import de.michaelmawick.spawnplugin.SpawnPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) sender;

        FileConfiguration config = SpawnPlugin.getPlugin().getConfig();
        Location spawnLocation = new Location(
                Bukkit.getWorld(Objects.requireNonNull(config.getString("spawn.location.world"))),
                config.getInt("spawn.location.x"),
                config.getInt("spawn.location.y"),
                config.getInt("spawn.location.z"),
                config.getInt("spawn.location.yaw"),
                config.getInt("spawn.location.pitch")
        );
        player.sendMessage("§aYou are now at spawn.");

        player.teleport(spawnLocation);

        return false;
    }
}
