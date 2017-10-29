package fr.doctorwho.dao;

import org.bukkit.plugin.java.JavaPlugin;



/** To prepare the connection of the DataBase */
public class API extends JavaPlugin {

	private static API instance;
	private static Database database;
	
	
	public API() {
		super();
	}

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
