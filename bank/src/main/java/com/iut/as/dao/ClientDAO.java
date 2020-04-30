package com.iut.as.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.iut.as.modele.metier.Client;
import com.iut.as.db.Connexion;

public class ClientDAO implements IClientDAO<Client> {

	private static ClientDAO instance;

	public ClientDAO() {
	}

	public static ClientDAO getInstance() {
		if (instance == null) {
			instance = new ClientDAO();
		}
		return instance;
	}

	@Override
	public Client getById(String numClient) {

		Client client = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client where numeroClient=?");
			requete.setString(1, numClient);
			ResultSet res = requete.executeQuery();

			while (res.next()) {
				String numeroClient = res.getString(1);
				String adresse = res.getString(2);
				String nom = res.getString(3);
				client = new Client(numeroClient, adresse, nom);
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
		return client;
	}

	@Override
	public ArrayList<Client> getAllClient() throws SQLException {

		ArrayList<Client> listeClient = new ArrayList<Client>();
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from client");
			ResultSet res = requete.executeQuery();

			while (res.next()) {
				listeClient.add(new Client(res.getString("numeroClient"), res.getString("adresse"), res.getString("nom")));
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
		return listeClient;
	}

	@Override
	public boolean createClient(Client objet) {

		Client client = null;

		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("insert into client(numeroClient, adresse ,nom) values(?, ?, ?)");
			requete.setString(1, objet.getNumeroClient());
			requete.setString(2, objet.getAdresse());
			requete.setString(3, objet.getNom());

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

