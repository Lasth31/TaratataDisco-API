package fr.doctorwho.enums;

// Rank List
public enum EnumRank {

	JOUEUR(0, "joueur", "Joueur"),
	PREMIUM(10, "premium", "Premium"),
	PREMIUMPLUS(20, "premiumPlus","Premium +"),
	VIDEASTE(30, "videaste", "Videaste"),
	SCRIPTEUR(40, "scripteur", "Scripteur"),
	GRAPHISTE(50,"graphiste", "Graphiste"),
	GUIDE(60, "guide", "Guide"),
	BUILDER(4, "builder","Builder"),
	RESPONSABLE(80, "responsable", "§6Responsable"),
	CM(90, "community-manager","§cCommnunity-Manager"),
	ADMINISTRATEUR(100, "administrateur", "§4Administateur");

	int power;

	String rankName;

	String rankPrefix;

	private EnumRank(int power, String rankName, String rankPrefix) {
		this.power = power;
		this.rankName = rankName;
		this.rankPrefix = rankPrefix;
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

	public void setRankPrefix(String rankPrefix) {
		this.rankPrefix = rankPrefix;
	}

	/**
	 * Gets rank
	 * @param power the rank ID
	 * @return Rank
	 */
	public static EnumRank getRank(int power) {
		for (EnumRank rank : values()) {
			if (power == rank.getPower())
				return rank;
		}
		return null;
	}
}
