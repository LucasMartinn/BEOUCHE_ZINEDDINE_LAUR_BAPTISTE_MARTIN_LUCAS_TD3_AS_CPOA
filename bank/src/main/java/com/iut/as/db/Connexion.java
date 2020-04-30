package com.iut.as.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Connexion {

	public Connection creeConnexion() {

		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/beouche2u_java2020";
		String login = "beouche2u_appli";
		String pwd = "beouche2u";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion \n" + sqle.getMessage());
		}
		return maConnexion;
	}

	private static Connexion instance;

	public Connexion() {
	}

	public static Connexion getInstance() {
		if (instance == null) {
			instance = new Connexion();
		}
		return instance;
	}

	public static void Properties() {

		Properties accesBdd = new Properties();
		File fBdd = new File("config/bdd.properties");
		try {
			FileInputStream source = new FileInputStream(fBdd);
			accesBdd.loadFromXML(source);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
