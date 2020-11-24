package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	public VilleDAO maVilleDAO;
	
	@Override
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> mesVilles = null;
		
		maVilleDAO = new VilleDAOImpl();
		mesVilles = maVilleDAO.getInfoVille();
		return mesVilles;
	}

	@Override
	public void methodPost(Ville myNewVille) {
		maVilleDAO = new VilleDAOImpl();
		maVilleDAO.createNewVille(myNewVille);
	}

	
	
}
