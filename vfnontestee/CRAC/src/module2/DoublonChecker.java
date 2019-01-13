package module2;

import java.util.ArrayList;

import module1.*;
import module3.*;

public class DoublonChecker {
	
	private ArrayList<Patient> arr_pa = new ArrayList<Patient>();
	private ArrayList<IdentiteAdministrative> arr_ida_sansdiag = new ArrayList<IdentiteAdministrative>(); //arraylist utilisée comme intermédiaire pr checker
	private ArrayList<IdentiteAdministrative> arr_ida = new ArrayList<IdentiteAdministrative>();
	
	
	public DoublonChecker (ArrayList<IdentiteAdministrative> arr_ida) {
		
		this.arr_ida = arr_ida;
		
	}
	
	public void generateDoublonCheck() {
		
		//on parcourt tous les elements de l'array ida d'entree pour en faire un arraylist mais sans les diag pr comparaison
		for (IdentiteAdministrative ida : this.arr_ida) {
			
			String nom = ida.getNom();
			String prenom = ida.getPrenom();
			String ddn = ida.getDdN();
			String sexe = ida.getSexe();
			
			IdentiteAdministrative idalim = new IdentiteAdministrative(prenom,nom,sexe,ddn);
			
			//on ajoute les ida sans leur diagnostic (il y a donc juste les paramètres d'identite
			this.arr_ida_sansdiag.add(idalim);
			
		}
		
		
		for (IdentiteAdministrative ida : this.arr_ida_sansdiag) {
			
			//condition = l'array patient ne contient pas cette ida limitee à nom prenom sexe ddn) -> on le cree. Sinon rien.
			if (!this.arr_pa.contains(ida)) {
				
				String nom = ida.getNom();
				String prenom = ida.getPrenom();
				String ddn = ida.getDdN();
				String sexe = ida.getSexe();
				
				Patient pa = new Patient(prenom,nom,sexe,ddn);
				
				//on ajoute les pa uniques only au regard de prenom, nom, sexe, date de naissance
				this.arr_pa.add(pa);
				System.out.println("Ajout du patient: " + nom);
			}else {}
		
		}
		
		//on complète avec les informations diagnostics indispensables
		for(IdentiteAdministrative ida : this.arr_ida) {
			//on cherche parmis tous les patients s'il y a des egalités strictes
			for(Patient pa : this.arr_pa) {
				
				if (ida.getPrenom() == pa.getPrenom() && ida.getNom() == pa.getNom() && ida.getSexe() == pa.getSexe() && ida.getDdN() == pa.getDdN() ){
					//on ajoute l'ida avec ses diag si elle est strictement identitique
					pa.addIDa(ida);
				}else {}
				
			}
			
		}
			
		
		
	}
	
	public ArrayList<Patient> getArraypa(){
		
		return arr_pa;
		
	}

}
