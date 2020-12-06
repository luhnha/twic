package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.blo.VilleBLOImpl;
import com.dto.Ville;
 
@RestController
public class VilleController {

	VilleBLO villeBLO;
	
	public VilleBLO getVilleBLO() {
		return villeBLO;
	}

	public void setVilleBLO(VilleBLO villeBLO) {
		this.villeBLO = villeBLO;
	}

	@RequestMapping(value="/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codeCommune") String codeCommune) {
		System.out.println("Appel Get");
		this.setVilleBLO(new VilleBLOImpl());
		ArrayList<Ville> myArrayVilleList = villeBLO.getInfoVille(codeCommune);
		return myArrayVilleList;
	}
	
	@RequestMapping(value="/ville",method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville myNewVille){
		System.out.println("Appel Post");
		this.setVilleBLO(new VilleBLOImpl());
		villeBLO.methodPost(myNewVille);
	}
	
	@RequestMapping(value="/ville",method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody Ville myVille) {
		System.out.println("Appel Put");
		this.setVilleBLO(new VilleBLOImpl());
		villeBLO.methodPut(myVille);
	}
	
	@RequestMapping(value="/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestBody String codeCommune) {
		System.out.println("Appel Delete");
		this.setVilleBLO(new VilleBLOImpl());
		villeBLO.methodDelete(codeCommune);
	}
}
