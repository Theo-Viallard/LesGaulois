package personnages;

import objets.Trophee;
import village.Musee;
import village.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] troph = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; troph != null && i < troph.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = troph[i];
		}
	}
	
	
	
	public void faireUneDonation(Musee musee) {
		if (trophees.length != 0) {
			int i = 0;
			String texte = "Je donne au musée tous mes trophées :";
			while (trophees[i] != null) {
				texte += ("\n- " + trophees[i].toString());
				musee.donnerTrophees(this, new Trophee(this, trophees[i]));
				i++;
			}
			parler(texte);
		}
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);

		System.out.println(asterix);
	}
}