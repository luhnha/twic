package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{

	@Override
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		try {
			Connection myConnection = JDBConfiguration.connexion();
			String requestGETville = "SELECT * FROM Ville_france;";
			Statement statement = myConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(requestGETville);
			while(resultSet.next()) {
				Ville newVille = new Ville();
				newVille.setCodeCommune(resultSet.getString(1));
				newVille.setNomCommune(resultSet.getString(2));
				newVille.setCodePostal(resultSet.getString(3));
				newVille.setLibelleAcheminement(resultSet.getString(4));
				newVille.setLigne(resultSet.getString(5));
				newVille.setLatitude(resultSet.getString(6));
				newVille.setLongitude(resultSet.getString(7));
				listVille.add(newVille);
			}
			myConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listVille;
	}

	@Override
	public ArrayList<Ville> getInfoVille(String filtre) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		return null;
	}

	
}
