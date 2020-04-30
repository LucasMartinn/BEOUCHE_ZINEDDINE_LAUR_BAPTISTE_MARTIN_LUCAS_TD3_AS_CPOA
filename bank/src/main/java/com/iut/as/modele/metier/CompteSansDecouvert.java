package com.iut.as.modele.metier;

public class CompteSansDecouvert extends Compte{

	public CompteSansDecouvert(String numeroCompte) {
		super(numeroCompte);
	}
	
	public void debiter(double montant) {
		if (montant < 0 && montant > solde) {
			System.out.println("Montant invalide !");
		} else {
			solde = solde - montant;
		}
	}

}
