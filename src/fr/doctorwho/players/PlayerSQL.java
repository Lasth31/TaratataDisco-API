package fr.doctorwho.players;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import fr.doctorwho.API;

/*
 * Gestion de Player (UUID, pseudo,rank, money etc...)
 * UserID sert à mieux gérer si on veux crée une table punish
 */
public class PlayerSQL {

	// Map contenant le player ainsi que son SQL
	public static Map<Player, PlayerSQL> playersql = new HashMap<>();

	int ID;
	String uuid;
	String pseudo;
	Rank rank;
	int coins;

	public PlayerSQL(int ID,String uuid, String pseudo, Rank rank,int coins) {
		this.ID = ID;
		this.uuid = uuid;
		this.pseudo = pseudo;
		this.rank = rank;
		this.coins = coins;
	}

	// Creation Player BDD IF not Account
	public static void createAccount(Player player) {
		if (hasAccount(player))
			return;
		try {
			PreparedStatement p = API.getDataBase().prepareStatement("INSERT INTO players(userID,uuid,pseudo) VALUES (?,?,?)");
			p.setInt(1, API.getDataBase().getAllID("players") + 1);
			p.setString(2, player.getUniqueId().toString());
			p.setString(3, player.getName());
			p.execute();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean hasAccount(Player player) {
		try {
			PreparedStatement p = API.getDataBase().prepareStatement("SELECT uuid FROM players WHERE uuid = ?");
			p.setString(1, player.getUniqueId().toString());
			ResultSet rs = p.executeQuery();
			String hasAccount = null;
			while (rs.next()) {
				hasAccount = rs.getString("uuid");
			}
			p.close();
			return hasAccount != null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// GET le SQL du Player
	public static PlayerSQL getPlayerSQL(Player player)
	{
		PlayerSQL playersql = null;
		try{
			PreparedStatement p = API.getDataBase().prepareStatement("SELECT * FROM players WHERE uuid = ?");
			p.setString(1, player.getUniqueId().toString());
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				playersql = new PlayerSQL(rs.getInt("userID"),rs.getString("uuid"),player.getName(),Rank.getRank(rs.getInt("rank")), rs.getInt("coins"));
			}
			p.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return playersql;
	}

	// UPDATE BDD DU PLAYER
	public void update(){
		try{
			PreparedStatement ps = API.getDataBase().prepareStatement("UPDATE players SET pseudo = ?, rank = ?, coins = ? WHERE uuid = ?");
			int num = 1;
			ps.setString(num++, pseudo);
			ps.setInt(num++, rank.getPower());
			ps.setInt(num++, coins);
			ps.setString(num++, uuid);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int getID() {
		return ID;
	}

	public String getUUID() {
		return uuid;
	}

	public String getPseudo() {
		return pseudo;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public void setRank(int power){
		this.rank = Rank.getRank(power);
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public void addCoins(int amount){
		this.coins += amount;
	}
	
	public void removeCoins(int amount){
		this.coins-= amount;
		if(coins < 0) this.coins = 0;
	}
}