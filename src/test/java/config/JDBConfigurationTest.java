package config;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.config.JDBConfiguration;

public class JDBConfigurationTest {

	@Test
	public void test() {
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
		
		
	}

}
