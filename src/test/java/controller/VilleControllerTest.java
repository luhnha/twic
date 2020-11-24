package controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.blo.VilleBLOImpl;
import com.config.JDBConfiguration;
import com.controller.VilleController;

public class VilleControllerTest {

	/**
	 * 
	@Test
	public void testGet1() {
		
		JDBConfiguration myConf =  new JDBConfiguration();
		try {
			Connection myConn = myConf.connexion();
			Statement statement = myConn.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM Ville_france;");
	        while(resultSet.next()) {
	        	System.out.println("nom commune : "+resultSet.getString("Nom_commune"));
	        }
	        myConn.close();
	        assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not succeded");
		}
		
		VilleController myVC = null;
	}
	 */
	
	@Test
	public void testGet2() {
		JDBConfiguration myConf =  new JDBConfiguration();
		VilleController villC = new VilleController();
		System.out.println(villC.appelGet().get(0).getNomCommune());
	}

}
