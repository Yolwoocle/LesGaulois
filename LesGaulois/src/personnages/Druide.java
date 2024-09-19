package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		 this.nom = nom;
		 this.effetPotionMin = effetPotionMin;
		 this.effetPotionMax = effetPotionMax;
		 
		 parler("Bonjour, je suis le druide " + nom + 
				 " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax);
	}
	
	public void parler(String message) {
		System.out.println(prefixeParole() + " : « " + message + " »");
	}

	private String prefixeParole() {
		return "[Druide " + nom + "]";
	}
	
	public String getNom() {
		return nom;
	}
}
