package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.dao.VilleDAOImpl;
import com.dto.Ville;

public class VilleDAOImplTest {

	@Test
	public void test() {
		VilleDAOImpl villeDAOImp = new VilleDAOImpl();
		ArrayList<Ville> myArray = villeDAOImp.getInfoVille();
		Ville ville1 = myArray.get(0);
		System.out.println(ville1.getNomCommune());
		assertEquals("01001",ville1.getCodeCommune());
		assertEquals("L ABERGEMENT CLEMENCIAT",ville1.getNomCommune());
		assertEquals("01400",ville1.getCodePostal());
		assertEquals("L ABERGEMENT CLEMENCIAT",ville1.getLibelleAcheminement());
		assertEquals("",ville1.getLigne());
		assertEquals("46.1331001556",ville1.getLatitude());
		assertEquals("4.99858455549",ville1.getLongitude());
	}

}
