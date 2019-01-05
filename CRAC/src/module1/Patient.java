/* Cod� par Kevin Ouazzani */
package module1;

import java.sql.Date;
import java.util.ArrayList;



public class Patient extends Identite{
	
	//on ajoute les attributs sp�cifiques au patient = IDAdm (une ou plusieurs) et Cancer (1ou plusieurs)
	private ArrayList<IdentiteAdministrative> ID_adm_array = new ArrayList<>();
	private ArrayList<Cancer> Cancer_array = new ArrayList<>();

	//rajouter attributs:
	/*
	 * 
	 */
	
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
	
	//methode de traitement des cancer
		public void mod4() {
			//TODO : r�cup�re le cancer cimo3 morpho,
			//Si fini par 3 : le marque � delete
			//Si iacr morpho 8 � 15 : codage  iacr topo en S
			//utiliser les getter des cancers
			//et remove()
			//
		}
}
