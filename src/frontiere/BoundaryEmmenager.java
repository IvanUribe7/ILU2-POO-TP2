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
		questionForce.append("Bienvenue villageois " + nomVisiteur + "\n");
		questionForce.append("Quelle est votre force ?" + "\n");
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(questionForce.toString());
			if(choixUtilisateur >= 0) {
				controlEmmenager.ajouterGaulois(nomVisiteur, choixUtilisateur);
			}else {
				System.out
			.println("Vous devez choisir un nombre non negatif!" + "\n");
			}	
		} while (choixUtilisateur < 0);
	}
	
	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder questionForce = new StringBuilder();
		StringBuilder questionForcePotion = new StringBuilder();
		StringBuilder questionForcePotionMax = new StringBuilder();
		StringBuilder forceNegatif = new StringBuilder();
		
		forceNegatif.append("Vous devez choisir un nombre non negatif!" + "\n");
		questionForce.append("Bienvenue villageois " + nomVisiteur + "\n" +
				"Quelle est votre force ?" + "\n");
		
		int choixUtilisateurForce = -1;
		do {
			choixUtilisateurForce = Clavier.entrerEntier(questionForce.toString());
			if(choixUtilisateurForce >= 0){
				forceNegatif.toString();
			}
			
		} while (choixUtilisateurForce < 0);
		
		questionForcePotion.append("Quelle est la force de potion la\r\n"
				+ "plus faible que vous produisez ?");
		
		int choixUtilisateurForcePotion = -1;
		do {
			choixUtilisateurForcePotion = Clavier.entrerEntier(questionForcePotion.toString());
			if(choixUtilisateurForcePotion < 0){
				forceNegatif.toString();
			}	
		} while (choixUtilisateurForcePotion < 0);
			
		questionForcePotionMax.append("Quelle est la force de potion la\r\n"
				+ "plus forte que vous produisez ?");
		
		int choixUtilisateurForcePotionMax = -1;
		do {
			choixUtilisateurForcePotionMax = Clavier.entrerEntier(questionForcePotionMax.toString());
			if( choixUtilisateurForcePotionMax < 0 || choixUtilisateurForcePotionMax < choixUtilisateurForcePotion){
				forceNegatif.toString();
			}else {
				controlEmmenager.ajouterDruide(nomVisiteur, choixUtilisateurForce, choixUtilisateurForcePotion, choixUtilisateurForcePotionMax);
			}	
		} while (choixUtilisateurForcePotionMax < 0 || choixUtilisateurForcePotionMax < choixUtilisateurForcePotion);
		
	}
}
