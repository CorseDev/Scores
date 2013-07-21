package me.ttgx12;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Scores(), this);
	}
}
