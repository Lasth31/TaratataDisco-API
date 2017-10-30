package fr.doctorwho.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.doctorwho.enums.EnumPrefix;
import fr.doctorwho.enums.EnumRank;
import fr.doctorwho.service.PlayerSQL;

public class MoneyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		// Console send Command
		if(!(sender instanceof Player)){
			Bukkit.getConsoleSender().sendMessage("�4Erreur: Vous ne pouvez pas utiliser cette commande ici!");
			return true;
		}
		
		if(args.length == 0){
			player.sendMessage(EnumPrefix.DOCTORWHORP + "�7Vous avez " + PlayerSQL.getPlayerSQL(player) + "�");
			return true;
		}
		
		if(args.length == 3){
			// Detect IF Player is Admin
			if(PlayerSQL.playersql.get(player) == null || PlayerSQL.playersql.get(player).getRank() != EnumRank.ADMINISTRATEUR){
				player.sendMessage(EnumPrefix.DOCTORWHORP + "�4Vous n'avez pas la permission de ex�cuter la commande");
				return true;
			}
			
			Player target = Bukkit.getPlayerExact(args[1]);
			PlayerSQL playersql = PlayerSQL.getPlayerSQL(target);
			int amount = Integer.parseInt(args[2]);
			
			
			if(target == null || playersql == null){
				player.sendMessage(EnumPrefix.DOCTORWHORP + "�4Le joueur n'existe pas");
				return true;
			}
			
			if(amount == 0){
				player.sendMessage(EnumPrefix.DOCTORWHORP + "�4Vous ne pouvez pas mettre 0");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("add")) {
				playersql.addCoins(amount);
				player.sendMessage(EnumPrefix.DOCTORWHORP + "�aVous avez rajout� " + amount + "� � votre compte");
				target.sendMessage(EnumPrefix.DOCTORWHORP + "�Le joueur " + player.getName() + " vous a rajout� " + amount + "� � votre compte");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("remove")){
				playersql.removeCoins(Integer.parseInt(args[2]));
				player.sendMessage(EnumPrefix.DOCTORWHORP + "�aVous avez enlev� " + amount + "� � votre compte");
				target.sendMessage(EnumPrefix.DOCTORWHORP + "�Le joueur " + player.getName() + " vous a enlev� " + amount + "� � votre compte");
				return true;
			}
		}
		return false;
	}
}
