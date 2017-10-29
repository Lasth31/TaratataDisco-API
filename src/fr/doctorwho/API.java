package fr.doctorwho;

import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.sql.Database;

public class API extends JavaPlugin {

	private static API instance;
	private static Database database;
	
	@Override
	public void onEnable() {
		instance = this;
		
		database = new Database();
		database.connect();
	}
	
	@Override
	public void onDisable() {
		database.disconnect();
	}
	
	public static API getInstance(){
		return instance;
	}

	public static Database getDataBase() {
		return database;
	}
}
