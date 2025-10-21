package de.michaelmawick.spawnplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Spawn Plugin has been enabled.");


    }

    @Override
    public void onDisable() {
        getLogger().info("Spawn Plugin has been disabled.");
        
    }
}
