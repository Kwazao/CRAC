package module1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class DiagnosticDAO extends DAO<Diagnostic>{

	//Cette arraylist va contenir tous les diagnostics g�n�r�s par l'import
	private ArrayList<Diagnostic> gen_diag = new ArrayList<>();
	private ArrayList<IdentiteAdministrative> gen_idadm = new ArrayList<>();
	
	
	public DiagnosticDAO(Connection conn) {
		super(conn);
		gen_diag = new ArrayList<>();
		gen_idadm = new ArrayList<>();
	}
	
	  
	//G�n�ration de tous les objets Diagnostics � partir de la bdd (objet connexion)
	public void generateDiag() {
		
			
		//Connexion � la base
		try {
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anapath");
				
			if (result.first()) {
				result.beforeFirst();
				
				int compte = 0;
				String typecode = "adicap";
				
				while(result.next()) {
						
					/*
					 * Boucle de cr�ation des identit�s administratives et diagnostics � partir de la table anapath	 
					 * 1ere etape : creation identite administrative
					 * 2eme etape : boucle sur diagnostics pour les extraire des ";" avec extractor
					 * 3eme etape : creation des objets diagnostics
					 * 4eme etape : ajout des objets diagnostic aux objets identite adm
					 */
					
					IdentiteAdministrative idadm = new IdentiteAdministrative(
							result.getString("Prenom"),
							result.getString("Nom"),
							result.getString("Sexe"),
							result.getString("DateNaissance"));
					
					System.out.println("ajout de l'identite administrative : " + idadm.getNom() );
					
					
					//stockage de la valeur des champs adicap dans objets extractor
					Extractor extractcode1 = new Extractor(result.getString("ADICAP1"));
					Extractor extractcode2 = new Extractor(result.getString("ADICAP2"));
						
					//application de la m�thode extract pour s�parer les codes entre ";"
					extractcode1.extract();
					extractcode2.extract();
						
						//iteration sur les array obtenus avec le getter pour  creer autant d'objets diagnostics qu'il y a de codes
					Iterator itr1 = extractcode1.getArray().iterator();
					Iterator itr2 = extractcode2.getArray().iterator();
					
					//boucle parcourant l'array pour la colonne adicap1
					while(itr1.hasNext()) {
						
						//stockage du code unique dans une variable String
						String code = itr1.next().toString();
						
						System.out.println("ajout du code : "+ code );

						
						//finalisation avec cr�ation de l'objet diagnostic qui reprend les diff�rents diagnostics trouv�s dans le champs adicap1
						Diagnostic diag = new Diagnostic(
								typecode,
								code,
								idadm
								);
						
						gen_diag.add(diag);
						idadm.addDiag(diag);
					}
					
					//boucle parcourant l'array pour la colonne adicap2
					while(itr2.hasNext()) {
						
						//stockage du code unique dans une variable String
						String code = itr2.next().toString();
						
						System.out.println("ajout du code : "+ code );
						
						
						
						//finalisation avec cr�ation de l'objet diagnostic qui reprend les diff�rents diagnostics trouv�s dans le champs adicap2
						Diagnostic diag = new Diagnostic(
								code,
								typecode,
								idadm
								);
						
						gen_diag.add(diag);
						idadm.addDiag(diag);
					}						
					
					
					gen_idadm.add(idadm);
					compte += 1;
				}
				
				System.out.println("Un total de "+ compte +" patients � �t� import� de la base anapath");
			
				
				
				compte = 0;
				
				
			}
		
				
				
		}
		catch (SQLException e) {
		      e.printStackTrace();
		    }
			
			
	}
	
	//R�cup�ration de l'arraylist contenant toutes les identit�s adminsitratives
	public ArrayList<IdentiteAdministrative> getIdAdm(){
		return gen_idadm;
	}
	
	//R�cup�ration de l'arraylist contenant tous les diagnostics g�n�r�s
	public ArrayList<Diagnostic> getDiag(){
		return gen_diag;
	}
		
	
	public boolean create(Diagnostic obj) {
		return false;
	}
	
	public boolean update(Diagnostic obj) {
		return false;
	}
	
	public boolean delete(Diagnostic obj) {
		return false;
	}
}
