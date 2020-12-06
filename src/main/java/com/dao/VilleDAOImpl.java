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
public class VilleDAOImpl implements VilleDAO {

	@Override
	public ArrayList<Ville> getInfoVille(String codeCommune) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		if (codeCommune!=null) {
			try {
				Connection myConnection = JDBConfiguration.connexion();
				String requestGETville = "SELECT * FROM Ville_france where CODE_COMMUNE_INSEE='";
				requestGETville += codeCommune +"'";
				Statement statement = myConnection.createStatement();
				ResultSet resultSet = statement.executeQuery(requestGETville);
				while (resultSet.next()) {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Connection myConnection = JDBConfiguration.connexion();
				String requestGETville = "SELECT * FROM Ville_france;";
				Statement statement = myConnection.createStatement();
				ResultSet resultSet = statement.executeQuery(requestGETville);
				while (resultSet.next()) {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listVille;
	}

	@Override
	public void createNewVille(Ville myNewVille) {
		try {
			Connection myConnection = JDBConfiguration.connexion();
			String requestPOSTville = "INSERT INTO Ville_france VALUES (";
			requestPOSTville += "'" + myNewVille.getCodeCommune();
			requestPOSTville += "', '" + myNewVille.getNomCommune();
			requestPOSTville += "', '" + myNewVille.getCodePostal();
			requestPOSTville += "', '" + myNewVille.getLibelleAcheminement();
			requestPOSTville += "', '" + myNewVille.getLigne();
			requestPOSTville += "', '" + myNewVille.getLatitude();
			requestPOSTville += "', '" + myNewVille.getLongitude();
			requestPOSTville += "' )";
			Statement statement = myConnection.createStatement();
			statement.executeUpdate(requestPOSTville);
			myConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateVille(Ville myVille) {
		try {
			Connection myConnection = JDBConfiguration.connexion();
			String requestPUTville = "UPDATE Ville_france SET ";
			requestPUTville += "CODE_COMMUNE_INSEE ='" + myVille.getCodeCommune()+"', ";
			requestPUTville += "NOM_COMMUNE ='" + myVille.getNomCommune()+"', ";
			requestPUTville += "CODE_POSTAL ='" + myVille.getCodePostal()+"', ";
			requestPUTville += "LIBELLE_ACHEMINEMENT ='" + myVille.getLibelleAcheminement()+"', ";
			requestPUTville += "LIGNE_5 ='" + myVille.getLigne()+"' ";
			requestPUTville += ",LATITUDE ='" + myVille.getLatitude()+"' ";
			requestPUTville += ",LONGITUDE ='" + myVille.getLongitude()+"' ";
			requestPUTville += "WHERE ";
			requestPUTville += "CODE_COMMUNE_INSEE ='" + myVille.getCodeCommune()+"' ";
			Statement statement = myConnection.createStatement();
			statement.executeUpdate(requestPUTville);
			myConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVille(String codeCommune) {
		try {
			Connection myConnection = JDBConfiguration.connexion();
			String requestPUTville = "DELETE FROM Ville_france WHERE ";
			requestPUTville += "CODE_COMMUNE_INSEE ='" + codeCommune+"'";
			Statement statement = myConnection.createStatement();
			statement.executeUpdate(requestPUTville);
			myConnection.close();
			System.out.println(requestPUTville);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
