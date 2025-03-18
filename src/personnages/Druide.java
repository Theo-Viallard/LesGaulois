package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private int forceMax;
	private Chaudron chaudron;

	public Druide(String nom, int force, int forceMax) {
		this.nom = nom;
		this.force = force;
		this.forceMax = forceMax;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");

	}

	public void boosterGaulois(Gaulois gaulois) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();

		if (contientPotion) {

			if (nomGaulois.equals("Obélix")) {
				parler("Non, " + nomGaulois + ". Non !... Et tu le sais très bien !");

			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + nomGaulois + ", un peu de potion magique.");
			}

		} else {
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion.");

		}

	}
}
