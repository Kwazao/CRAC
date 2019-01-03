/* Cod� par Kevin Ouazzani */
package module1;

import java.sql.Date;
import java.util.ArrayList;



public class Patient extends Identite{
	
	//on ajoute les attributs sp�cifiques au patient = IDAdm (une ou plusieurs) et Cancer (1ou plusieurs�
	private ArrayList<IdentiteAdministrative> ID_adm_array;
	private ArrayList<Cancer> Cancer_array;
	
	
	//TODO � redefinir comme sous classe d'identit� (sur m�me mod�le qu'identit� administrative
	//constructeur par d�faut
	public Patient(String p, String n, String s, String d) {
		super(p,n,s,d);

	}
	
	
	public Patient(String p, String n, String s, String d, ArrayList<IdentiteAdministrative> ia, ArrayList<Cancer> ca) {
		super(p,n,s,d);
		this.ID_adm_array = ia;
		this.Cancer_array = ca;

	}
	
	public Patient(String p, String n, String s, String d, ArrayList<IdentiteAdministrative> ca) {
		super(p,n,s,d);
		this.ID_adm_array = ca;

	}
	
	
	//getters
	
	public ArrayList<IdentiteAdministrative> getIDa() {
		return ID_adm_array;
	}
	
	public ArrayList<Cancer> getCa(){
		return Cancer_array;
	}
	
	
	//setters individuels
	public void setIDa(ArrayList<IdentiteAdministrative> ida) {
		this.ID_adm_array = ida;
	}
	
	public void setCa(ArrayList<Cancer> ca) {
		this.Cancer_array= ca;
	}
	
}
