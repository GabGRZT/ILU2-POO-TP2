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
					"Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
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
		StringBuilder chaine = new StringBuilder();
		chaine.append("Quelle est votre force ?\n ");
		int forceDruide = Clavier.entrerEntier(chaine.toString());

		StringBuilder chaine1 = new StringBuilder();
		chaine1.append("Quelle est la force la plus faible que vous produisez ?\n ");
		int effetPotionMin  = Clavier.entrerEntier(chaine1.toString());
		
		StringBuilder chaine2 = new StringBuilder();
		chaine2.append("Quelle est la force la plus forte que vous produisez ?\n ");
		int effetPotionMax = Clavier.entrerEntier(chaine2.toString());
		
		do {
			System.out.println(chaine1);
			effetPotionMin  = Clavier.entrerEntier(chaine1.toString());
			System.out.println(chaine2);
			effetPotionMax = Clavier.entrerEntier(chaine2.toString());
		}while (effetPotionMin > effetPotionMax);
		
		if(effetPotionMin < effetPotionMax) {
			System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
		}
	}
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue druide "+nomVisiteur+"\n");
		int effetPotionMin;
		int effetPotionMax;

		StringBuilder chaine = new StringBuilder();
		chaine.append("Quelle est votre force ?\n ");
		int forceGaulois = Clavier.entrerEntier(chaine.toString());

		StringBuilder questionPotionMin = new StringBuilder();
		questionPotionMin.append("Quelle est la force la plus faible que vous produisez ?\n ");
		
		StringBuilder questionPotionMax = new StringBuilder();
		questionPotionMax.append("Quelle est la force la plus forte que vous produisez ?\n ");
		
		do {
			effetPotionMin  = Clavier.entrerEntier(questionPotionMin.toString());	
			effetPotionMax = Clavier.entrerEntier(questionPotionMax.toString());
			if(effetPotionMin > effetPotionMax) break;
			System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
		}while (effetPotionMin > effetPotionMax);
	}
}
