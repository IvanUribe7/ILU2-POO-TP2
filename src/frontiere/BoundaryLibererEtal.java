package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui! \n");
			
		}else {
			
			String[] etalOccupe = controlLibererEtal.libererEtal(nomVendeur);
			
			if(Boolean.parseBoolean(etalOccupe[0]))
				System.out.println("Vous avez vendu " + etalOccupe[4] + " sur "
						+ etalOccupe[3] + " " + etalOccupe[2] + " \n");
		}
		
		System.out.println("En revoir " + nomVendeur + ", passez "
				+ "un bonne journee! \n");
		
	}

}
