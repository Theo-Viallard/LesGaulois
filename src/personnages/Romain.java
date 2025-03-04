package personnages;

public class Romain {
	private String nom;
	private int force;

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

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
