package me.destroy.towersevent.EventHandlers;

import me.destroy.towersevent.TowersEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Objects;

public class TowersHandler implements Listener {
    public ArrayList<String> towerHolders = new ArrayList<>();
    public void startEvent(){
        for(Player x: Bukkit.getWorld("SkirmishEvent").getPlayers()){
            addTeam(x);
        }
        for(int i = 1;i<7;i++) {
            TowersEvent.plugin.getConfig().getLocation("TowerDummy." + i);
        }

        pointsLoop();

    }

    public static void addTeam(Player p){
        if(Clans.getClans().getStringList("PlayersInClans").contains(p.getUniqueId().toString())){
            String clan = Clans.getClans().getString("PlayersClans." + p.getUniqueId());
            if(clan == null)return;
            if(TowersEvent.towersEvent.getTeam(clan + " Team") == null){
                Team team = TowersEvent.addTeam(clan);
                team.addEntry(clan);
            }
        }
        else return;
    }
    public void pointsLoop(){
        new BukkitRunnable(){
            @Override
            public void run() {
                for (String clan : towerHolders) {
                    Score score = TowersEvent.towersEvent.getObjective("ArdaTowersEvent").getScore(clan);
                    TowersEvent.towersEvent.getObjective("ArdaTowersEvent").getScore(clan).setScore(score.getScore() + 1);
                }
            }
        }.runTaskTimer(TowersEvent.plugin,0,20);
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
        Player p = e.getPlayer();
        if(e.getTo().getWorld() == e.getFrom().getWorld())return;
        if(e.getTo().getWorld().equals(Bukkit.getWorld("SkirmishEvent"))){
            addTeam(p);
        }
    }
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().equals(Bukkit.getWorld("SkirmishEvent"))){
            addTeam(p);
        }
    }
    @EventHandler
    public void onKill(EntityDeathEvent e){
        LivingEntity entity = e.getEntity();
        if(entity.getWorld().equals(Bukkit.getWorld("SkirmishEvent"))){
            if(entity.getType().equals(EntityType.MUSHROOM_COW)){
                Player killer = entity.getKiller();
                if(Objects.equals(entity.customName(), Component.text("TowerCow1"))){

                }
                if(Objects.equals(entity.customName(), Component.text("TowerCow2"))){

                }
                if(Objects.equals(entity.customName(), Component.text("TowerCow3"))){

                }
                if(Objects.equals(entity.customName(), Component.text("TowerCow4"))){

                }
                if(Objects.equals(entity.customName(), Component.text("TowerCow5"))){

                }
                if(Objects.equals(entity.customName(), Component.text("TowerCow6"))){

                }
            }
        }
    }
}
