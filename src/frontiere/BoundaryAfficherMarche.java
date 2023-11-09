package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		StringBuilder string = new StringBuilder();
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		System.out.println(infosMarche.length);
		if(infosMarche.length == 0) {
			System.out.println("Le marche est vide, revenez plus tard.");
		}else {
			string.append(nomAcheteur + ", vous trouverez au marche : \n");
			for(int i = 0; i < infosMarche.length ; i++) {
				string.append("-" + infosMarche[i] + " qui vend ");
				i++;
				string.append(infosMarche[i] + " ");
				i++;
				string.append(infosMarche[i] + "\n");
				System.out.println(string);
			}
		}
			
	}
}
