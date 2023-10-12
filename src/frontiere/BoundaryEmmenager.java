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

	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bienvenue villageois Bonemine" + "\n");
		questionForce.append("Quelle est votre force ?" + "\n");
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(questionForce.toString());
			if(choixUtilisateur >= 0) {
				ControlEmmenager controlEmmenager2 = new ControlEmmenager(null);
				controlEmmenager2.ajouterGaulois(nomVisiteur, choixUtilisateur);
			}else {
				System.out
			.println("Vous devez choisir un nombres non negatif!" + "\n");
			}	
		} while (choixUtilisateur < 0);
	}
	
	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
	}
}
