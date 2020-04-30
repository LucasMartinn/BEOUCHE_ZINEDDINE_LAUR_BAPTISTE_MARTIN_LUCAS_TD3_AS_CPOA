package com.iut.as.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.iut.as.modele.metier.Compte;

public interface ICompteDAO<Compte> {

    public abstract Compte getById(String numCompte);

    public abstract boolean createCompte(Compte objet);

    ArrayList<Compte> getAllCompte() throws SQLException;


}
