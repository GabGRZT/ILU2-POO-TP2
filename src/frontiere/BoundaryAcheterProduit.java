package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit;
		produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] VendeurProd = controlAcheterProduit.vendeur(produit);
		
		if (VendeurProd != null) {
			for (int i=0;i<VendeurProd.length;i++) {
				System.out.println((i+1)+" - "+VendeurProd[i]);
			}
			int choixVendeur;
			choixVendeur = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des "+produit+" ?");
			String vendeurChoisi = VendeurProd[choixVendeur-1];
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeurChoisi);
			
			int quantite;
			System.out.println("Bonjour "+nomAcheteur);
			quantite = Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?");
			
			String achat = controlAcheterProduit.acheterProduit(vendeurChoisi, quantite);
			if (achat =="0") {
				System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produit+", malheureusement il n'y en a plus !");
			}else if(achat =="+") {
				System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produit+", malheureusement "+vendeurChoisi+" n'en a plus que 3."+nomAcheteur+" achète tout le stock de "+vendeurChoisi);
			}else if(achat=="-=") {
				System.out.println(nomAcheteur+" achète "+quantite+" "+produit+" à "+vendeurChoisi);
			}
		}
	}
}