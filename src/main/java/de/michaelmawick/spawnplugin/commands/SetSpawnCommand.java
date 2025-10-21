package de.michaelmawick.spawnplugin.commands;

import de.michaelmawick.spawnplugin.SpawnPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        if (player.hasPermission("spawn.command.setspawn")) {
            File file = new File(SpawnPlugin.getPlugin().getDataFolder(), "config.yml");
            FileConfiguration config = SpawnPlugin.getPlugin().getConfig();;

            config.set("spawn.location.world", player.getLocation().getWorld().getName());
            config.set("spawn.location.x", player.getLocation().getX());
            config.set("spawn.location.y", player.getLocation().getY());
            config.set("spawn.location.z", player.getLocation().getZ());
            config.set("spawn.location.yaw", player.getLocation().getYaw());
            config.set("spawn.location.pitch", player.getLocation().getPitch());

            try {
                config.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            player.sendMessage("§cYou are not allowed to do this.");
        }

        return false;
    }
}
