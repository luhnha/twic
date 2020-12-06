package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	public ArrayList<Ville> getInfoVille(String codeCommune);

	public void methodPost(Ville myNewVille);

	public void methodPut(Ville myVille);

	public void methodDelete(String codeCommune);
	

}
