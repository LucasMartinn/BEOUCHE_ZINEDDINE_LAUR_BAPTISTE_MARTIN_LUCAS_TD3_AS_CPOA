package com.iut.as.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.iut.as.modele.metier.Client;

public interface IClientDAO<Client> {

    public abstract Client getById(String numClient);

    public abstract boolean createClient(Client objet);

    ArrayList<Client> getAllClient() throws SQLException;


}