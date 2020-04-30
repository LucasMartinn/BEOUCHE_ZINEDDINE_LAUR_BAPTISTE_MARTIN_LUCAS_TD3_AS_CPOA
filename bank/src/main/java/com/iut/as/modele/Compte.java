package com.iut.as.modele;

public class Compte {
	
	protected String numeroCompte;
	protected double solde;

	public Compte(String numCompte) {
		this.numeroCompte = numCompte;
		this.solde = 0;
	}

	public void debiter(double montant) {
		if (montant < 0 && montant > solde) {
			System.out.println("Montant invalide !");
		} else {
			solde = solde - montant;
		}
	}

	public void crediter(double montant) {
		if (montant > 0) {
			System.out.println("Montant invalide !");
		} else {
			solde = solde + montant;
		}
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

}
