/*Cod� par Kevin Ouazzani*/

package module1;

import java.util.ArrayList;
import java.util.Arrays;


//Cette classe permet de s�parer un texte contenant plusieurs codes diagnostics s�par�s par ";" et de retourner un array contenant les diff�rents diagnostics s�paremment
public class Extractor {
	
	private String entree;
	private ArrayList<String> sortie = new ArrayList<>();
	
	public Extractor(String e) {
		this.entree = e;
	}

	
	//m�thode qui r�alise l'extraction et stocke le r�sultat sous forme d'array dans l'attribut sortie
	public void extract() {
		String a = this.entree;
		String[] parts = a.split(";");
		this.sortie = new ArrayList<String>(Arrays.asList(parts));
	}
	
 
	// Getter pour r�cup�rer l'entr�e (pas tr�s utile)
	public String getString() {
		return entree;
	}
	
	
	//Getter pour r�cup�rer l'array sortie contenant les diff�rents diagnostics
	public ArrayList<String> getArray() {
		return sortie;
	}
	
}
