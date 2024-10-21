package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipementMax = 2;
	private Equipement[] equipements = new Equipement[nbEquipementMax];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		
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
		assert this.force > 0;
		int forceDebut = this.force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !!");
		} else {
			parler("J'abandonne...");
		}
		
		assert this.force < forceDebut;
	}
	
	public boolean aEquipement(Equipement equipement) {
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == equipement) {
				return true;
			}
		}
		return false;
	}

	public void sEquiper(Equipement equipement) {
		String nomEquipement;
		if (equipement == Equipement.BOUCLIER) {
			nomEquipement = "un bouclier";
		} else {
			nomEquipement = "un casque";
		}
		
		switch (nbEquipement) {
			case 2: {
				System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
				return;
			}
			case 1: {
				if (aEquipement(equipement)) {
					System.out.println("Le soldat " + getNom() + " a déjà " + nomEquipement +"!");
					return;
				}
			}
		}
		
		System.out.println("Le soldat " + getNom() + " s'équipe avec " + nomEquipement + ".");
		this.equipements[nbEquipement] = equipement;
		nbEquipement += 1;
	}
	
	public int getForce() {
		return force;
	}
	
	public String getNom() {
		return nom;
	}
		
	public static void main(String[] args) {
		System.out.println("Éxécution de Romain.java");
		Romain minus = new Romain("Minus", 6);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE); 
	}
}
