package histoire;

import lieux.Village;
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		scenario2();
	}

	public static void scenario1() {
		/*
		 * Le gaulois Astérix : « Bonjour à tous» Le romain Minus : « UN GAU... UN
		 * GAUGAU...» Astérix envoie un grand coup dans la mâchoire de Minus Le romain
		 * Minus : « Aïe» Astérix envoie un grand coup dans la mâchoire de Minus Le
		 * romain Minus : « Aïe» Astérix envoie un grand coup dans la mâchoire de Minus
		 * Le romain Minus : « J'abandonne...»
		 */

		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);

		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

	public static void scenario2() {
		/*
		 * Sachant que minus à une force de 6, astérix une force de 8 et Obélix une
		 * force de 25, modifier le scénario de la classe Scenario pour obtenir la
		 * sortie suivante
		 * 
		 * Le druide Panoramix : « Bonjour, je suis le druide Panoramix et ma potion
		 * peut aller d'une force 5 à 10.» Le druide Panoramix : « Je vais aller
		 * préparer une petite potion...» Le druide Panoramix : « Je n'ai pas trouvé
		 * tous les ingrédients, ma potion est seulement de force 6.» Le druide
		 * Panoramix : « Non, Obélix !... Tu n'auras pas de potion magique !» Le gaulois
		 * Obélix : « Par Bélénos, ce n'est pas juste !» Le gaulois Astérix : « Merci
		 * Druide, je sens que ma force est 6 fois décuplée.» Le gaulois Astérix : «
		 * Bonjour» Le romain Minus : « UN GAU... UN GAUGAU...» Astérix envoie un grand
		 * coup dans la mâchoire de Minus
		 */

		Romain minus = new Romain("Minus", 6);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);

		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();

		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");

		panoramix.booster(asterix);
		asterix.parler("Bonjour");

		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
	}
}
