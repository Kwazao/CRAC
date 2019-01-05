/* Codé par Kevin Ouazzani */
package module1;

import java.sql.Date;
import java.util.ArrayList;



public class Patient extends Identite{
	
	//on ajoute les attributs spécifiques au patient = IDAdm (une ou plusieurs) et Cancer (1ou plusieurs)
	private ArrayList<IdentiteAdministrative> ID_adm_array = new ArrayList<>();
	private ArrayList<Cancer> Cancer_array = new ArrayList<>();

	//rajouter attributs:
	/*
	 * 
	 */
	
	//TODO à redefinir comme sous classe d'identité (sur même modèle qu'identité administrative
	//constructeur par défaut
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
			//TODO : récupère le cancer cimo3 morpho,
			//Si fini par 3 : le marque à delete
			//Si iacr morpho 8 à 15 : codage  iacr topo en S
			//utiliser les getter des cancers
			//et remove()
			//
		}
}
