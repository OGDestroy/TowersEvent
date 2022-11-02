package me.destroy.towersevent;

import me.destroy.towersevent.EventHandlers.Clans;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public final class TowersEvent extends JavaPlugin {

    public static TowersEvent plugin;
    public static Scoreboard towersEvent;
    public static boolean running = false;

    @Override
    public void onEnable() {
        plugin = this;
        Clans.loadClans();
        createScoreBoard();

    }

    @Override
    public void onDisable() {

    }

    public static void createScoreBoard(){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        towersEvent = manager.getNewScoreboard();
        Objective objective = towersEvent.registerNewObjective("ArdaTowersEvent",Criteria.DUMMY, Component.text("Towers Event"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setRenderType(RenderType.INTEGER);
    }

    public static Team addTeam(String team){
        return towersEvent.registerNewTeam(team);
    }
}
