package module1;

import java.util.ArrayList;

public class ConflitId {
	
	private IdentiteAdministrative idAdm1;
	private IdentiteAdministrative idAdm2;
	private String resolution; // attribut qui est modifié par l'utilisateur via l'interface du module 4
	
	//constructeur par defaut prenant 2 identite administrative 
	public ConflitId(IdentiteAdministrative ida, IdentiteAdministrative idb) {
		this.idAdm1 =ida;
		this.idAdm2=idb;
		this.resolution = "nonres"; //valeur par défaut "non résolu"
		
	}
	
	//renvoie sous forme d'arraylist les deux identites administrative de l'objet conflit
	public ArrayList<IdentiteAdministrative> getIdAdm() {
		
		ArrayList<IdentiteAdministrative> arr = new ArrayList<IdentiteAdministrative>();
		arr.add(idAdm1);
		arr.add(idAdm2);
		return arr;
		
	}
	
	//setter utilisé par le module 4 par marine pour choisir la résolution
	
	public void setReso(String r) {
		if (r == "1") {
			this.resolution = "meme";
		}else if (r == "2") {
			this.resolution ="diff";
		}else {}
	}
	
	
		
	

}
