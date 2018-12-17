/* Codé par Kevin Ouazzani*/
package module1;

import java.sql.Date;
import java.util.ArrayList;

public class IdentiteAdministrative extends Identite {
	
	//initialisation des attributs 
	private Patient patient;
	private ArrayList <Diagnostic> Diag_array;
	private boolean integrite = false;
	
	//constructeur par défaut
	public IdentiteAdministrative(String p, String n, String s, Date d) {
		super(p,n,s,d);
		
	}
	
	//constructeur ac patient
	public IdentiteAdministrative(String p, String n, String s, Date d, Patient pa, ArrayList<Diagnostic> di) {
		super(p,n,s,d);
		this.patient = pa;
		this.Diag_array = di;
	}
	
	
	//getters	

	
	public Patient getPatient() {
		return patient;
	}
	
	//TODO getter diag
	
	//setters individuels


	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
 
	//TODO setter diag
}
