/*Codé par Kevin Ouazzani*/

package module1;

import java.util.ArrayList;
import java.util.Arrays;


//Cette classe permet de séparer un texte contenant plusieurs codes diagnostics séparés par ";" et de retourner un array contenant les différents diagnostics séparemment
public class Extractor {
	
	private String entree;
	private ArrayList<String> sortie = new ArrayList<>();
	
	public Extractor(String e) {
		this.entree = e;
	}

	
	//méthode qui réalise l'extraction et stocke le résultat sous forme d'array dans l'attribut sortie
	public void extract() {
		String a = this.entree;
		String[] parts = a.split(";");
		this.sortie = new ArrayList<String>(Arrays.asList(parts));
	}
	
 
	// Getter pour récupérer l'entrée (pas très utile)
	public String getString() {
		return entree;
	}
	
	
	//Getter pour récupérer l'array sortie contenant les différents diagnostics
	public ArrayList<String> getArray() {
		return sortie;
	}
	
}
