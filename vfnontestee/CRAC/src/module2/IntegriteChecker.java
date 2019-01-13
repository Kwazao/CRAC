package module2;

/* codé par Kevin Ouazzani */

import java.util.ArrayList;

import module1.*;
import module3.*;


public class IntegriteChecker {
	
	private ArrayList<IdentiteAdministrative> arr_ida = new ArrayList<IdentiteAdministrative>();
	private ArrayList<Patient> arr_pa = new ArrayList<Patient>();
	
	//creation d'un
	public IntegriteChecker (ArrayList<IdentiteAdministrative> arr_ida) {
		
		this.arr_ida = arr_ida;
		this.arr_pa = new ArrayList<Patient>();//arraylist patient vide pour l'instant
		
	}
	
	
	public void checkIntegrite() {
		
		Integer compte = 0;
		Integer nonintegre = 0;
		
		for (IdentiteAdministrative ida: arr_ida) {
		
			compte +=1;
			//on check l'intégrite des données
			//on commence par le sexe
			if ((ida.getSexe() != "1" && ida.getSexe() != "2") || ida.getSexe().isEmpty() ) {
				ida.setInteg(false);
				
				nonintegre +=1;
			}else {}
		
			//nom
			if (ida.getNom() == "" || ida.getNom().isEmpty() ) {
				ida.setInteg(false);
				
				nonintegre +=1;
			}else {}
		
		
			//prenom
			if (ida.getPrenom() == "" || ida.getPrenom().isEmpty() ) {
				ida.setInteg(false);
				
				nonintegre +=1;
			}else {}
		
			//date de naissance
			if (ida.getDdN() == "" || ida.getSexe().isEmpty() ) {
				ida.setInteg(false);
				
				nonintegre +=1;
			}else {}
		
			System.out.println("Intégrité vérifiée ");

	}
		System.out.println("Intégrité vérifiée pour" + compte + "identitées administratives");
		System.out.println(nonintegre + "Données manquantes");
		
	}
	

}
