package de.rexlmanu.bewerbung;
/*
* Class created by rexlManu
* Twitter: @rexlManu | Website: rexlManu.de
* Coded with IntelliJ
*/

import de.rexlmanu.bewerbung.config.ConfigHandler;
import de.rexlmanu.bewerbung.listeners.player.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Bewerbung extends JavaPlugin{

    private static Bewerbung instance;

    private ConfigHandler configHandler;

    @Override
    public void onEnable() {
        instance = this;
        getDataFolder().mkdir();
        init();

        this.configHandler = new ConfigHandler();
    }

    private void init() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        CraftServer server = (CraftServer) Bukkit.getServer();
        SimpleCommandMap commandMap = server.getCommandMap();

        pluginManager.registerEvents(new PlayerJoinListener(), this);
    }

    public ConfigHandler getConfigHandler() {
        return configHandler;
    }

    public static Bewerbung getInstance() {
        return instance;
    }
}
