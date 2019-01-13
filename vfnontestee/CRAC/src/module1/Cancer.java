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
	 * Pour Marine :
	 * Sortir une arraylist avec Patient + Arraylist<cancer>
	 * 
	 */
		
	private String cimo_to;
	private String cimo_mo;
	private String iacr_to;
	private String iacr_mo;

	//TODO à rajouter dans la version de marine
	public Cancer() {}
	
	//Constructeur à partir de la cimo
	public Cancer (String ct, String mo) {
		this.cimo_to = ct;
		this.cimo_mo = mo;
		
	}
	

	/**
	 * @return the cimo_to
	 */
	public String getCimot() {
		return cimo_to;
	}

	/**
	 * @param cimo_to the cimo_to to set
	 */
	public void setCimot(String cimo_to) {
		this.cimo_to = cimo_to;
	}

	/**
	 * @return the cimo_mo
	 */
	public String getCimom() {
		return cimo_mo;
	}

	/**
	 * @param cimo_mo the cimo_mo to set
	 */
	public void setCimom(String cimo_mo) {
		this.cimo_mo = cimo_mo;
	}

	/**
	 * @return the iacr_to
	 */
	public String getIacrt() {
		return iacr_to;
	}

	/**
	 * @param iacr_to the iacr_to to set
	 */
	public void setIacrt(String iacr_to) {
		this.iacr_to = iacr_to;
	}

	/**
	 * @return the iacr_mo
	 */
	public String getIacrm() {
		return iacr_mo;
	}

	/**
	 * @param iacr_mo the iacr_mo to set
	 */
	public void setIacrm(String iacr_mo) {
		this.iacr_mo = iacr_mo;
	}
}
