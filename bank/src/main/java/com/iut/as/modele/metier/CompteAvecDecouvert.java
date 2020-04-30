package com.iut.as.modele.metier;

public class CompteAvecDecouvert extends Compte{
	
	private double decouvertAutorise;
	
	public CompteAvecDecouvert(String numeroCompte) {
		super(numeroCompte);
	}
	
	public void debiter(double montant) {
		if (montant < 0 && montant > solde) {
			System.out.println("Montant invalide !");
		} else {
			solde = solde - montant;
		}
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

}
