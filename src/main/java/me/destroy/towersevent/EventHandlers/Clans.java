package me.destroy.towersevent.EventHandlers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;


public class Clans {
    public static FileConfiguration clans;

    public static void loadClans(){
        clans = Bukkit.getPluginManager().getPlugin("Clan").getConfig();
    }
    public static FileConfiguration getClans(){
        return clans;
    }


}
