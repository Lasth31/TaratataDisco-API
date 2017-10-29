package fr.doctorwho.players;

// Liste des rank
public enum Rank {
	
	ADMINISTRATEUR(0,"administrateur","§4Administateur"),
	CM(1,"community-manager","§cCommnunity-Manager"),
	RESPONSABLE(2,"responsable","§6Responsable");
	
	int power;
	String rankName,rankPrefix;
	
	private Rank(int power, String rankName,String rankPrefix) {
		this.power = power;
		this.rankName = rankName;
		this.rankPrefix = rankPrefix;
	}
	
	public int getPower() {
		return power;
	}

	public String getRankName() {
		return rankName;
	}

	public String getRankPrefix() {
		return rankPrefix;
	}

	public static Rank getRank(int power){
		for(Rank rank : values()){
			if(power == rank.getPower()) return rank;
		}
		return null;
	}
}
