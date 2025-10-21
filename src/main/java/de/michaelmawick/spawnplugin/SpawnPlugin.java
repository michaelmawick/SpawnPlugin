package de.michaelmawick.spawnplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    public static SpawnPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("Spawn Plugin has been enabled.");


    }

    @Override
    public void onDisable() {
        getLogger().info("Spawn Plugin has been disabled.");
        
    }

    public static SpawnPlugin getPlugin() {
        return plugin;
    }
}
