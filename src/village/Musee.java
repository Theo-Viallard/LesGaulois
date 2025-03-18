package village;

import objets.Trophee;
import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees;
	
	
	public Musee() {
		this.trophees = new Trophee[200];
		this.nbTrophees = 0;
	}
	
	
	public void donnerTrophees(Gaulois gaulois, Trophee trophee) {
		if (nbTrophees < 200) {
			trophees[nbTrophees] = trophee;
			nbTrophees++;
		} else {
			System.out.println("Taille max musée atteinte : trophée non donné.");
		}
	}
	
	
	public String extraireInstructionsOCaml () {
		String resultat = "let musee = [";
		int i = 0;
		while (trophees[i] != null) {
			Trophee trophee = trophees[i]; 
			resultat += ("\n\"" + trophee.donnerNom() + "\", \"" + trophee.getEquipement() + "\";");
			i++;
		}
		resultat += "\n]";
		return resultat;
	}
}
