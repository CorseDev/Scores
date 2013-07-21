package me.ttgx12;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Scoreboard;

public class Scores extends JavaPlugin implements Listener {
	
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	Objective objective = board.registerNewObjective("lives", "dummy");
	
	@EventHandler
	public void Scoreboard(PlayerJoinEvent event) {
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("Kills");
		 
		for(Player online : Bukkit.getOnlinePlayers()){
		  Score score = objective.getScore(online);
		  score.setScore(5); 
		}
		 
		for(Player online : Bukkit.getOnlinePlayers()){
		 online.setScoreboard(board);
		}
		}
		
	@EventHandler
	public void AddKill(PlayerDeathEvent event) {
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			 
			for(Player online : Bukkit.getOnlinePlayers()){
			  Score score = objective.getScore(online);
			  score.setScore(score.getScore() + 1); 
			}
			 
			for(Player online : Bukkit.getOnlinePlayers()){
			 online.setScoreboard(board);
			}


		
		
	}
}
