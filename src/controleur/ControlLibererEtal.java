package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)==null;
	}
	
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5] ;
		donneesEtal = (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)).etatEtal();
		return donneesEtal;
	}

}
