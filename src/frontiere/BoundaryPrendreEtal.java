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
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il "
					+ "faut être un habitant de notre "
					+ "village pour commercer ici.\r\n");
		}else {
			installerVendeur(nomVendeur);
			}	
		}


	private void installerVendeur(String nomVendeur) {
		StringBuilder questionNbProduit = new StringBuilder();
		int nbProduit;
		String produit;
		System.out.println("Bonjour " + nomVendeur + ", je vais regarder "
				+ "si je peux vous trouver un étal. \r\n");
		
		if(!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolé " + nomVendeur + "je n'ai plus d'étal "
					+ "qui ne soit pas déjà occupé. \n");
		}else {
			System.out.println("C'est parfait, il me reste un étal pour vous !\r\n"
					+ "Il me faudrait quelques renseignements :\r\n"
					+ "Quel produit souhaitez-vous vendre ? \n");			
			questionNbProduit.append("Combien souhaitez-vous en vendre ? \n");
			produit = scan.nextLine();
			nbProduit = Clavier.entrerEntier(questionNbProduit.toString());
			int nEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
			if(nEtal!=-1)
				nEtal++;
				System.out.println("Le vendeur " +  nomVendeur + " s'est installé à "
						+ "l'étal n°" + nEtal + "\n");			
		}
	}
}
