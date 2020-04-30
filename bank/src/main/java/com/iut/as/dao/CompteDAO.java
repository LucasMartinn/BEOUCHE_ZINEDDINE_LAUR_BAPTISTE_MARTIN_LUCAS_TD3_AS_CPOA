package com.iut.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.iut.as.modele.metier.Compte;
import com.iut.as.db.Connexion;

public class CompteDAO implements ICompteDAO<Compte> {

	private static CompteDAO instance;

	public CompteDAO() {
	}

	public static CompteDAO getInstance() {
		if (instance == null) {
			instance = new CompteDAO();
		}
		return instance;
	}

	@Override
	public Compte getById(String numCompte) {

		Compte compte = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from compte where numeroCompte=?");
			requete.setString(1, numCompte);
			ResultSet res = requete.executeQuery();

			while (res.next()) {
				String numeroCompte = res.getString(1);
				double solde = res.getDouble(2);
				compte = new Compte(numCompte);
			}

			if (res != null)
				res.close();

			if (requete != null)
				requete.close();

			if (laConnexion != null)
				laConnexion.close();

		} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
		return compte;
	}

	@Override
	public ArrayList<Compte> getAllCompte() throws SQLException {

		ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from compte");
			ResultSet res = requete.executeQuery();

			while (res.next()) {
				listeCompte.add(new Compte(res.getString("numeroCompte")));
			}

			if (res != null)
				res.close();

			if (requete != null)
				requete.close();

			if (laConnexion != null)
				laConnexion.close();

		} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
		return listeCompte;
	}

	@Override
	public boolean createCompte(Compte objet) {

		Compte compte = null;

		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into compte(numeroCompte, solde) values(?, ?)");
			requete.setString(1, objet.getNumeroCompte());
			requete.setDouble(2, objet.getSolde());

			int nbLignes = requete.executeUpdate();

			if (requete != null)
				requete.close();

			if (laConnexion != null)
				laConnexion.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
			return false;
		}
	}

}

