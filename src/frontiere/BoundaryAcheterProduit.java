package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

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
				System.out.println("D�sol�, personne ne vend ce produit au march�. \n");
		} while (controlAcheterProduit.isProduitDisponible(produit));
		
		int indiceVendeur = -1;
		int nbVendeurs = controlAcheterProduit.getVendeursAvecProduit(produit).length;
		
		do {
			System.out.println("Chez quel commer�ant voulez-vous " + 
					"acheter des fleurs ? \n");
	
			for(int i = 0; i < nbVendeurs; i++ ) {
				System.out.println(i+1 + "-" + controlAcheterProduit.getVendeursAvecProduit(produit)[i].getNom() + "\n");
			}
			
			indiceVendeur = Clavier.entrerEntier(idVendeurEtal.toString());
		} while (indiceVendeur < 1 && indiceVendeur > nbVendeurs);
		
		
		String[] donnees = controlAcheterProduit.getInfosEtal(controlAcheterProduit.getVendeursAvecProduit(produit), indiceVendeur-1);
		
		System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal " +
				 "du vendeur " + donnees[0] + ". \n" + "Bonjour " +  nomAcheteur + " \n");
		
		
		int quantiteDesiree = -1;
		
		do {
			System.out.println("Combien de fleurs voulez-vous "
					+ "acheter ? \n");

			quantiteDesiree = Clavier.entrerEntier(idVendeurEtal.toString());
			
		} while (quantiteDesiree < 1);
		
		if(controlAcheterProduit.acheterDesProduits(controlAcheterProduit.getVendeursAvecProduit(produit)[indiceVendeur-1],quantiteDesiree)==0) {
			
			System.out.println(nomAcheteur + " veut acheter " + quantiteDesiree +
					 produit + ", malheureusement il n�y "
					+ "en a plus ! \n");
			
		}else if(controlAcheterProduit.acheterDesProduits(controlAcheterProduit.getVendeursAvecProduit(produit)[indiceVendeur-1],quantiteDesiree)==quantiteDesiree){
			
			System.out.println(nomAcheteur + " ach�te " + quantiteDesiree + produit + " � "
					+ donnees[0] + "\n");
			
		}else {
			
			System.out.println(nomAcheteur + " veut acheter " + quantiteDesiree + produit + ", "
					+ "malheureusement " + donnees[0] + "n�en a "
					+ "plus que " + 3 + ". " + nomAcheteur + " ach�te "
					+ "tout le stock de " +  donnees[0] + ". \n");
			
		}
		
	}
}
