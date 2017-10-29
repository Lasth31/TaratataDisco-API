package fr.doctorwho.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import fr.doctorwho.API;

/*
 * Gestion de la Database
 */

public class Database extends SQLConnection implements Runnable{
	
	private static BukkitTask task;
	
	 // 20 tick * 60 Seconde * 60 minute
	public Database() {
		super("urlbase", "host", "database", "username", "password");
		task = Bukkit.getScheduler().runTaskTimer(API.getInstance(), this, 0, 20 * 60 * 60);
	}

	@Override
	public void run() {
		// reload tous les Heures
		disconnect();
		connect();
	}
	
	public int getAllID(String table){
		int value = 0;
		try{
			PreparedStatement ps = prepareStatement("SELECT id FROM " + table);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				value = rs.getInt("id");
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return value;
	}
	
	public PreparedStatement prepareStatement(String value){
		try {
			return getConnection().prepareStatement(value);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
