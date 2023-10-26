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

		String[] donneesEtal = null;
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null)
			donneesEtal = (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)).etatEtal();
		return donneesEtal;
	}

}
