package personnages;

import personnages.Romain;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;
	
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
		System.out.println(prefixeParole() + " : « " + message + " »");
	}

	private String prefixeParole() {
		return "[Gaulois " + nom + "]";
	}

	public void frapper(Romain romain) {
		System.out.println("[Le Gaulois " + nom + " envoir un grand coup dans la mâchoire de " + romain.getNom() + "]");
		romain.recevoirCoup(force / 3);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
}
