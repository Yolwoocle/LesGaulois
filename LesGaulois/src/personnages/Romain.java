package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipementMax = 2;
	private Equipement[] equipements = new Equipement[nbEquipementMax];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		if (force <= 0) {
			throw new IllegalArgumentException("La force doit être strictement positive (" + force + ") reçu.");
		}
		
		this.nom = nom;
		this.force = force;
	}
	
	public void parler(String message) {
		System.out.println(prendreParole() + " : « " + message + " »");
	}

	private String prendreParole() {
		return "[Romain " + nom + "]";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {	
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
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
		String debutMessage = "Le soldat " + getNom();
		String nomEquipement;
		if (equipement == Equipement.BOUCLIER) {
			nomEquipement = "un bouclier";
		} else {
			nomEquipement = "un casque";
		}
		
		if (nbEquipement == 2) {	
			System.out.println(debutMessage + " est déjà bien protégé !");
			return;
		} else if (nbEquipement == 1 && aEquipement(equipement)) {
			System.out.println(debutMessage + " a déjà " + nomEquipement +"!");
			return;
		}
		
		System.out.println(debutMessage + " s'équipe avec " + nomEquipement + ".");
		equipements[nbEquipement] = equipement;
		nbEquipement += 1;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
				texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
