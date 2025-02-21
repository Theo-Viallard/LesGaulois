package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public int prendreLouche() {
		quantitePotion--;
		int force = forcePotion;
		
		if (!resterPotion()) {
			forcePotion = 0;
		}
		
		return force;

	}

	public Chaudron() {
		this.quantitePotion = 0;
		this.forcePotion = 0;
	}

}
