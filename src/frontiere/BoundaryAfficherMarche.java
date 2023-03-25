package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public String afficherMarche(String nomAcheteur) {
		String[] InfosMarche = controlAfficherMarche.donnerEtatMarche();
		StringBuilder infos = new StringBuilder();
		if (InfosMarche.length == 0) {
			infos.append("La marché est vide, revenez plus tard");
		}else {
			infos.append(nomAcheteur +", vous trouverez au marché : \n");
			for (int i = 0; i < InfosMarche.length; i += 3) {
				infos.append("-"+InfosMarche[i]+" qui vend "+InfosMarche[i+1]+" "+InfosMarche[i+2]+".");
			}
		}
	return infos.toString();
	}
}
