package fr.doctorwho.service;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.dao.commands.RankCommand;
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
	
<<<<<<< HEAD:src/main/java/fr/doctorwho/service/API.java
	// Getters & Setters
=======
	/**
	 * Register All Command
	 */
	public void registerCommand(){
		getCommand("rank").setExecutor(new RankCommand());
	}
	
>>>>>>> 8f56e1c128c24720d3c33cbd32b9107f2b93620e:src/main/java/fr/doctorwho/dao/API.java
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
