package module1;

public class Cancer {

	//TODO Attributs
	/*
	 * Code CIMO3 TOPO 
	 * Code IACR TOPO
	 * Code CIMO3 MORPHO
	 * Code IACR MORPHO
	 * 
	 * Methods
	 * getter CIMO3 morpho
	 * derniere lettre =3 (keep) ou !=3 (delete object) : regex find dernière lettre
	 * arraylist ( fin=3)
	 * fonction : où patient ==== 
	 * 
	 * 
	 */
	
	private String cimo_to;
	private String cimo_mo;
	private String iacr_to;
	private String iacr_mo;

	
	
	//Constructeur à partir de la cimo
	public Cancer (String ct, String mo) {
		this.cimo_to = ct;
		this.cimo_mo = mo;
		
	}
	
	public String getCimot() {
		return cimo_to;
	}
	
	public String getCimom() {
		return cimo_mo;
	}
	
	public String getIacrt() {
		return iacr_to;
	}
	
	public String getIacrm() {
		return iacr_mo;
	}

	
}
