package personnages;

import personnages.Romain;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getEffetPotion() {
		return effetPotion;
	}
	
	public int getForce() {
		
		return force;
	}
	
	public void parler(String message) {
		System.out.println(prendreParole() + " : « " + message + " »");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] equipementRomain = romain.recevoirCoup((force / 3) * effetPotion);
		
		for (int i = 0; equipementRomain != null && i < equipementRomain.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = equipementRomain[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		/*
			prend en paramètre d’entrée la force
			de la potion et l’affecte à l’attribut
			effetPotion.
			Le gaulois dit : « Merci Druide, je sens que ma force est N fois décuplée. »
			si la force de la potion est de N.
		 */
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		asterix.boirePotion(2);
		Romain minus = new Romain("Minus", 6);

		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}
}
