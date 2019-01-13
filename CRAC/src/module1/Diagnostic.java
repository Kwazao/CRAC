/* Codé par Kevin Ouazzani */
package module1;

public class Diagnostic {
	

	private String d_type;
	private String d_code;
	private	IdentiteAdministrative id_adm;
	private Cancer cancer;
	//rajouter libelle avec requete sur table de corres code et libele
	
	public Diagnostic(String t, String c) {
		this.d_type = t;
		this.d_code = c;
	}

	public Diagnostic(String t, String c, IdentiteAdministrative ia) {
		this.d_type = t;
		this.d_code = c;
		this.id_adm = ia;
		
	}
	
	public Diagnostic(String t, String c, IdentiteAdministrative ia, Cancer ca) {
		this.d_type = t;
		this.d_code = c;
		this.id_adm = ia;
		this.cancer = ca;
		
	}
	
	public void setTypediag(String t) {
		this.d_type=t;
	}
	
	public void setCodediag(String c) {
		this.d_code =c;
	}
	
	public void setIdAdm(IdentiteAdministrative ia) {
		this.id_adm = ia;
	}
	
	public void setCancer(Cancer ca) {
		this.cancer =ca;
	}
	
	
	public String getTypediag() {
		return d_type;
	}
	
	public String getCodediag() {
		return d_code;
	}
	
	public IdentiteAdministrative getIdAdm() {
		return id_adm;
	}
	
	public Cancer getCancer() {
		return cancer;
	}
	
	
}
