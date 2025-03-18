package village;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void setChef(Gaulois chef) {
		this.chef = chef;
		chef.setVillage(this);
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		nbVillageois++;
	}

	public Gaulois trouverVillageois(int numero) {
		if (numero > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			return villageois[numero - 1];
		}
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + getNom() + "\" du chef " + getChef() + " vivent les légendaires gaulois :");
		for (int i = 1; i <= nbVillageois; i++) {
			System.out.println("- " + trouverVillageois(i));

		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
	}
}
