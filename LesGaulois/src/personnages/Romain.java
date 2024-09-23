package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void parler(String message) {
		System.out.println(prefixeParole() + " : « " + message + " »");
	}

	private String prefixeParole() {
		return "[Romain " + nom + "]";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !!");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public int getForce() {
		return force;
	}
	
	public String getNom() {
		return nom;
	}
}
