package personnages;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");

	private final String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.nom;
	}
}
