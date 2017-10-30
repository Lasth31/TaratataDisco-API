package fr.doctorwho.service;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.events.InventoryClick;



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
		
		registerListener();
	}
	
	@Override
	public void onDisable() {
		database.disconnect();
	}
	
	/** Register All Events  */
	public void registerListener(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new InventoryClick(), this);
	}
	
	// Getters & Setters
	public static API getInstance(){
		return instance;
	}
	
	public static void setInstance(API instance) {
	    API.instance = instance;
	}
		
	public static Database getDatabase() {
	    return database;
	}
	
	public static void setDatabase(Database database) {
	    API.database = database;
	}


	
	
	
}
