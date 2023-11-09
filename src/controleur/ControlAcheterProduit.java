package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isProduitDisponible(String produit) {
		return village.rechercherVendeursProduit(produit)==null;
	}
	
	public Gaulois[] getVendeursAvecProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	@SuppressWarnings("null")
	public String[] getInfosEtal(Gaulois[] vendeurs, int indice) {
		String[] donneesEtal = null;
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeurs[indice].getNom());
		donneesEtal[0] = vendeurs[indice].getNom();
		donneesEtal[1] = String.valueOf(etal.getQuantite());
		return donneesEtal;
	} 
}
