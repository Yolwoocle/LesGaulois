package lieux;

import java.util.Iterator;

import javax.security.auth.callback.ConfirmationCallback;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	private int nbVillageoisMax; 
	
	public Village(String nom, int nbVillageoisMax) {
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[this.nbVillageoisMax];
		this.nom = nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int place) {
		return villageois[place];
	}
	
	public void afficherVillageois() {
		String nomChef = "[inconnu]";
		if (chef != null) {
			nomChef = chef.getNom();
		}
		System.out.println("Dans le village du chef " + nomChef + " vivent les légendaires Gaulois :" );
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois != null) {
				System.out.println("- " + gaulois.getNom());				
			}
		}
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public Chef getChef() {
		return chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNbVillageois() {
		return nbVillageois;
	}
	
	public Gaulois[] getVillageois() {
		return villageois;
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles Gaulois", 30);
//		En faisant "village.trouverHabitant(30);" : 
		/*
		 * ^ On obtient cette erreur :
		 *   Exception in thread "main"
		 *   java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30 
		 *  
		 * C'est parce qu'on a créé un tableau de taille 30, et qu'on tente d'accéder à l'élément d'indice 30, alors que
		 * l'indice maximal du tableau est 29.
		 */

		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		/*
		 * ^ On obtient la sortie suivante :
		 *     null
		 * 
		 * Explication :
		 * - On crée le village des irréductibles Gaulois
		 * - On ajoute le chef Abraracourcix
		 * - On ajoute Astérix en place 0
		 * - On obtient et affiche le Gaulois en place 0, mais aucun n'a été défini à cet emplacement, on obtient donc null.
		 */

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
