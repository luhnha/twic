package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.blo.VilleBLOImpl;
import com.dto.Ville;
 
@RestController
public class VilleController {

	VilleBLO villeBLO = new VilleBLOImpl();
	
	public VilleBLO getVilleBLO() {
		return villeBLO;
	}

	public void setVilleBLO(VilleBLO villeBLO) {
		this.villeBLO = villeBLO;
	}

	@RequestMapping(value="/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet() {
		System.out.println("Appel Get");
		ArrayList<Ville> myArrayVilleList = villeBLO.getInfoVille();
		return myArrayVilleList;
	}
	
	
}
