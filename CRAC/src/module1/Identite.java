/* Codé par Kevin Ouazzani */
package module1;

import java.sql.Date;

public class Identite {
	private String prenom;
	private String nom;
	private String sexe;
	private Date ddn;
	
	//constructeur par défaut
	public Identite(String p, String n, String s, Date d ) {
		prenom = p;
		nom=n;
		sexe=s;
		ddn=d;
	}
	
	//getters
	public String getPrenom() {
		return prenom;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Date getDdN() {
		return ddn;
	}
	
	
	
	//setters individuels
	public void setPrenom(String p) {
		this.prenom = p ;
	}
	
	public void setSexe(String s) {
		this.sexe = s ;
	}
	
	public void setNom(String n) {
		this.nom =n;
	}
	
	public void setDdN(Date d) {
		this.ddn =d;
	}

}
