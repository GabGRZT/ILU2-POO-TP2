package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] vendeur(String produit) {
		
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] VendeurProd = null;
		
		if (vendeurs != null) {
			VendeurProd = new String[vendeurs.length];
			for (int i = 0; i<vendeurs.length; i++) {
				VendeurProd[i] = vendeurs[i].getNom();
			}
		}else {
			System.out.println("Desole, personne ne vend ce produit au marche.");
		}
		return VendeurProd;
	}
	
	public String acheterProduit(String nomVendeur, int quantite) {
		String resultat="";
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			if(etal.getQuantite()==0) {
				resultat = "0";
			}else if(quantite>etal.getQuantite()) {
				resultat = "+";
			}else if(quantite<=etal.getQuantite()) {
				resultat = "-=";
			}
		}else {
			resultat = "La personne n'est pas un vendeur";
		}
		return resultat;
	}
}