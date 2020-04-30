package com.iut.as.modele.metier;

import java.util.Scanner;

public class Bank {
	
	public static Compte Compte;
	
	public void retrait(String num_compte, String nom_client, double montant) {
		if (montant < 0 && montant >  Compte.solde) {
			System.out.println("Montant invalide !");
		} else {
			Compte.solde = Compte.solde - montant;
		}
	}

	public void depot(String num_compte, String nom_client, double montant) {
		if (montant < 0) {
			System.out.println("Montant invalide !");
		} else {
			Compte.solde = Compte.solde + montant;
		}
	}

	public void ouverture_compte(String nomClient) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez un numéro de compte :");
		String str = sc.nextLine();
		
		Compte compte = new Compte(str);
	}

	public void consultation(String num_compte) {
		System.out.println("Votre solde est de : " + Compte.getSolde());
	}

	public double conversionFromEuro(double montant) {
		double tauxDeChangeEnDollar = 1.12;

		return montant * tauxDeChangeEnDollar;
	}

	public double conversionToEuro(double montant) {

		double tauxDeChangeEnEuro = 0.89;

		return montant / tauxDeChangeEnEuro;
	}

}
