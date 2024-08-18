package com.skyevel.universalscoreboard;

import com.skyevel.universalscoreboard.workers.BoardWorker;
import org.bukkit.plugin.java.JavaPlugin;

public final class UniversalScoreboard extends JavaPlugin {

    public static UniversalScoreboard instance;

    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();
        BoardWorker.initialize();




        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UniversalScoreboard getInstance() {
        return instance;
    }
}
