package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		
		if(controlLibererEtal.isVendeur(nomVendeur)) {
			
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui! \n");
			
		}else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			System.out.println("Vous avez vendu " + donnesEtal[4] + " sur "
						+ donnesEtal[3] + " " + donnesEtal[2] + " \n"
								+ "En revoir " + nomVendeur + ", passez une bonne "
								+ "journée.\n");
		}
	}

}
