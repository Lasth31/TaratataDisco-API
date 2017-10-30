package fr.doctorwho.enums;

import org.bukkit.ChatColor;

// Rank List
public enum EnumRank {

	JOUEUR(0, "joueur", "\u00A77",ChatColor.GRAY),
	PREMIUM(10, "premium", "\u00A77[\u00A7aPrenium\u00A77]\u00A77",ChatColor.GRAY),
	PREMIUMPLUS(20, "premiumPlus","\u00A77[\u00A7bPrenium\u00A7d✩\u00A77]\u00A77",ChatColor.GRAY),
	VIDEASTE(30, "videaste", "\u00A78[\u00A73Vidéaste\u00A78]\u00A73",ChatColor.DARK_AQUA),
	SCENARISTE(40, "scenariste", "\u00A78[\u00A7eScénariste\u00A78]\u00A7e",ChatColor.DARK_PURPLE),
	GRAPHISTE(50,"graphiste", "\u00A78[§5Graphiste\u00A78]§5",ChatColor.GREEN),
	GUIDE(60, "guide", "\u00A78[\u00A7aGuide\u00A78]\u00A7a",ChatColor.DARK_GREEN),
	BUILDER(70, "builder","\u00A78[\u00A76Builder\u00A78]\u00A76",ChatColor.GOLD),
	DEVELOPPEUR(70,"developpeur"," \u00A78[&dDev\u00A78]\u00A7d",ChatColor.LIGHT_PURPLE),
	RESPONSABLESCENARISTE(80, "respscenariste", "\u00A78[\u00A7bResp.Scénariste\u00A78]\u00A7b",ChatColor.AQUA),
	RESPONSABLEGUIDE(80, "respguide", "\u00A78[\u00A7bResp.Guide\u00A78]\u00A7b",ChatColor.AQUA),
	RESPONSABLEMODO(80, "respmodo", "\u00A78[\u00A7bResp.Modo\u00A78]\u00A7b",ChatColor.AQUA),
	RESPONSABLEBUILD(80, "respbuild", "\u00A78[\u00A7bResp.Build\u00A78]\u00A7b",ChatColor.AQUA),
	RESPONSABLEDEV(80, "respdev", "\u00A78[\u00A7bResp.Dev\u00A78]\u00A7b",ChatColor.AQUA),
	CM(90, "community-manager","\u00A78[\u00A79C.Manager\u00A78]\u00A79",ChatColor.BLUE),
	ADMINISTRATEUR(100, "administrateur", "\u00A78[\u00A7cAdmin\u00A78]\u00A7c",ChatColor.RED);

	int power;

	String rankName;

	String rankPrefix;
	
	ChatColor chatColor;

	private EnumRank(int power, String rankName, String rankPrefix,ChatColor chatColor) {
		this.power = power;
		this.rankName = rankName;
		this.rankPrefix = rankPrefix;
		this.chatColor = chatColor;
	}

	/**
	 * Gets the power
	 * @return power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Sets power
	 * @param power
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * Gets Rank Name
	 * @return rankName
	 */
	public String getRankName() {
		return rankName;
	}
	
	/**
	 * Gets rank
	 * @param power the rank ID
	 * @return Rank
	 */
	public static EnumRank getRank(int power) {
		for (EnumRank rank : values())
		{
			if (power == rank.getPower())
			{
				return rank;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets rank
	 * @param rankName the rank Name
	 * @return Rank
	 */
	public static EnumRank getRank(String rankName) {
		for (EnumRank rank : values())
		{
			if (rank.getRankName().equalsIgnoreCase(rankName))
			{
				return rank;
			}
		}
		
		return null;
	}


	/**
	 * Sets rank Name
	 * @param rankName
	 */
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	/**
	 * Gets rank prefix
	 * @return rankPrefix
	 */
	public String getRankPrefix() {
		return rankPrefix;
	}

	/**
	 * Sets rank prefix
	 * @param rankPrefix
	 */
	public void setRankPrefix(String rankPrefix) {
		this.rankPrefix = rankPrefix;
	}

}

