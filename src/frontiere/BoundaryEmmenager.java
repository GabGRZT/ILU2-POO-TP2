package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:	
					emmenagerGaulois(nomVisiteur);				
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println(" Bienvenue villageois "+nomVisiteur+"\n");
		StringBuilder questionDruide = new StringBuilder();
		questionDruide.append("Quelle est votre force ?\n ");
		int forceDruide = Clavier.entrerEntier(questionDruide.toString());

		StringBuilder chainePotionMin = new StringBuilder();
		chainePotionMin.append("Quelle est la force la plus faible que vous produisez ?\n ");
		int effetPotionMin  = Clavier.entrerEntier(chainePotionMin.toString());
		
		StringBuilder chainePotionMax = new StringBuilder();
		chainePotionMax.append("Quelle est la force la plus forte que vous produisez ?\n ");
		int effetPotionMax = Clavier.entrerEntier(chainePotionMax.toString());
		
		do {
			System.out.println(chainePotionMin);
			effetPotionMin  = Clavier.entrerEntier(chainePotionMin.toString());
			System.out.println(chainePotionMax);
			effetPotionMax = Clavier.entrerEntier(chainePotionMax.toString());
		}while (effetPotionMin > effetPotionMax);
		
		if(effetPotionMin < effetPotionMax) {
			System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
		}
	}
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder questionG = new StringBuilder();
		questionG.append("Bienvenu gaulois " + nomVisiteur + ".\n");
		questionG.append("Quelle est votre force?\n");
		int forceGaulois = Clavier.entrerEntier(questionG.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
	}
}
