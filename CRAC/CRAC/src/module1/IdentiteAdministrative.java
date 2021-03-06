/* Cod� par Kevin Ouazzani*/
package module1;

import java.sql.Date;
import java.util.ArrayList;

public class IdentiteAdministrative extends Identite {
	
	//initialisation des attributs 
	private Patient patient;
	private ArrayList <Diagnostic> Diag_array = new ArrayList <>();
	private boolean integrite = false;
	
	//constructeur par d�faut
	public IdentiteAdministrative(String p, String n, String s, String d) {
		super(p,n,s,d);
		
	}
	
	//constructeur ac patient
	public IdentiteAdministrative(String p, String n, String s, String d, Patient pa, ArrayList<Diagnostic> di) {
		super(p,n,s,d);
		this.patient = pa;
		this.Diag_array = di;
	}
	
	
	//getters	
	
	public Patient getPatient() {
		return patient;
	}
	
	public ArrayList<Diagnostic> getDiag(){
		return Diag_array;
	}
	
	public boolean getInteg() {
		return integrite;
	}
	
	//setters individuels


	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
 
	
	public void addDiag(Diagnostic dia) {
		if (!this.getDiag().contains(dia))
		this.getDiag().add(dia);
	}
	
	public void setInteg (boolean integ) {
		this.integrite = integ;
	}
}
