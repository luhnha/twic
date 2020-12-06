package com.dao;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> getInfoVille(String codeCommune);
	
	public void createNewVille(Ville myNewVille);

	public void updateVille(Ville myVille);

	public void deleteVille(String codeCommune);

}
