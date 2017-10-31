package fr.doctorwho.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.doctorwho.service.API;
import fr.doctorwho.service.PlayerSQL;
import fr.doctorwho.service.PunishSQL;

public class PlayerChat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		PlayerSQL playersql = PlayerSQL.playersql.get(player);
		String message = event.getMessage();
		PunishSQL punish = new PunishSQL();
		
		if(punish.hasPunish(playersql, "mute")){
			for(int x = 1; x < API.getDatabase().getAllID("punish", "ID") + 1; x++)
			{
				punish = punish.getPunish(x);
				if(punish == null) continue;
				
				if(punish.getUserID() == playersql.getID() && punish.getPunishType().equalsIgnoreCase("mute")) break;
			}
			
			if(System.currentTimeMillis() >= punish.getEndMillis(punish.getEnd())){
				punish.delete(playersql, punish.getID());
				return;
			}
			player.sendMessage("Vous êtes mute");
			event.setCancelled(true);
		}
		
		event.setFormat(playersql.getRank().getRankPrefix() + player.getName() + " §f> " + playersql.getRank().getChatColor() + message);
	}
}
