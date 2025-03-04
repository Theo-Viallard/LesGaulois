package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceDepart = force;
		force -= forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		} else {
			parler("Aïe !");
		}
		assert forceDepart < force;
	}

	private boolean isInvariantVerified() {
		return this.force >= 0;
	}
	
	
	private void equip(Equipement equipement) {
		this.equipement[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
	}
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equip(equipement);
			break;
		case 1:
			if (this.equipement[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement);
			} else {
				equip(equipement);
			}
			break;
		case 2:
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
