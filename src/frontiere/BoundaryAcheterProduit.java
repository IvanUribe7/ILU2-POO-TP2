package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder produitDesiree = new StringBuilder();
		StringBuilder idVendeurEtal = new StringBuilder();
		String produit;
		produitDesiree.append("Quel produit voulez-vous acheter ?" + "\n");
		do {
			System.out.println(produitDesiree);
			produit = scan.nextLine();
			if(controlAcheterProduit.isProduitDisponible(produit))
				System.out.println("Désolé, personne ne vend ce produit au marché. \n");
		} while (!controlAcheterProduit.isProduitDisponible(produit));
		
		int indiceVendeur = -1;
		int nbVendeurs = controlAcheterProduit.getVendeursAvecProduit(produit).length;
		
		do {
			System.out.println("Chez quel commerçant voulez-vous " + 
					"acheter des fleurs ? \n");
	
			for(int i = 0; i < nbVendeurs; i++ ) {
				System.out.println(i+1 + "-" + controlAcheterProduit.getVendeursAvecProduit(produit)[i].getNom() + "\n");
			}
			
			indiceVendeur = Clavier.entrerEntier(idVendeurEtal.toString());
		} while (indiceVendeur < 1 && indiceVendeur > nbVendeurs);
		
		
		String[] donnees = controlAcheterProduit.getInfosEtal(controlAcheterProduit.getVendeursAvecProduit(produit), choixUtilisateur);
		
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal " +
				 "du vendeur " + donnees[0] + ". \n" + "Bonjour " +  nomAcheteur + " \n");
		
		
		int quantiteDesiree = -1;
		
		do {
			System.out.println("Chez quel commerçant voulez-vous " + 
					"acheter des fleurs ? \n");
	
			for(int i = 0; i < nbVendeurs; i++ ) {
				System.out.println(i+1 + "-" + controlAcheterProduit.getVendeursAvecProduit(produit)[i].getNom() + "\n");
			}
			
			choixUtilisateur = Clavier.entrerEntier(idVendeurEtal.toString());
		} while (choixUtilisateur < 1 && choixUtilisateur > nbVendeurs);
		
	}
}
