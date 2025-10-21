package de.michaelmawick.spawnplugin;

import de.michaelmawick.spawnplugin.commands.SetSpawnCommand;
import de.michaelmawick.spawnplugin.commands.SpawnCommand;
import de.michaelmawick.spawnplugin.listener.ConnectionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    public static SpawnPlugin plugin;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        plugin = this;
        getLogger().info("Spawn Plugin has been enabled.");

        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Spawn Plugin has been disabled.");
        
    }

    public static SpawnPlugin getPlugin() {
        return plugin;
    }
}
