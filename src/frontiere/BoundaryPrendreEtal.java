package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder reponseInitiale = new StringBuilder();
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			reponseInitiale.append("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commencer ici.\n");
			System.out.println(reponseInitiale.toString());
		} else {
			reponseInitiale.append("Bonjour " + nomVendeur + 
					", je vais regarder si je peux vous trouver un etal.\n");
			StringBuilder etalsStatut = new StringBuilder();
			if (!controlPrendreEtal.resteEtals()) {
				etalsStatut.append("Désolé " + nomVendeur + 
						", je n'ai pas d'étal qui ne soit pas déjà occupé.\n");
				System.out.println(etalsStatut.toString());
			} else {
				etalsStatut.append("C'est parfait il me reste un étal pour vous !\n");
				etalsStatut.append("Il me faudrat quelques renseignements :\n");
				String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre?\n");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?\n");
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if (numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + 
							" s'est installé  à l'etal numero " + numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
