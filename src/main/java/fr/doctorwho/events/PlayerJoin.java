package fr.doctorwho.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.doctorwho.enums.EnumPrefix;
import fr.doctorwho.service.PlayerSQL;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		PlayerSQL.createAccount(player);
		PlayerSQL playersql = PlayerSQL.getPlayerSQL(player);
		PlayerSQL.playersql.put(player, playersql);
		
		event.setJoinMessage(EnumPrefix.DOCTORWHORP + "§b" + playersql.getRank().getRankPrefix() + " " + player.getName() + " à rejoint le serveur");
	}
}
