package module1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class DiagnosticDAO extends DAO<Diagnostic>{

	//Cette arraylist va contenir tous les diagnostics générés par l'import
	private ArrayList<Diagnostic> gendiag = new ArrayList<>();
	
	
	public DiagnosticDAO(Connection conn) {
		super(conn);
		gendiag = new ArrayList<>();
	}
	
	
	//Génération de tous les objets Diagnostics à partir de la bdd (objet connexion)
		public void generateDiag() {
		
			
			//Connexion à la base
			try {
				ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anapath");
				
				if (result.first()) {
					result.beforeFirst();
					
					int compte = 0;
					String typecode = "adicap";
					
					while(result.next()) {
						
						//TODO plusieurs étapes à suivre :
						/*
						 * 1. Générer l'objet Diagnostic avec un id_adm vide ?
						 * 
						 * 	2. avec setters : ajouter l'objet id administrative (appeler les setters dédiés)
						 */
						
						//stockage de la valeur des champs adicap dans objets extractor
						Extractor extractcode1 = new Extractor(result.getString("ADICAP1"));
						Extractor extractcode2 = new Extractor(result.getString("ADICAP2"));
						
						//application de la méthode extract pour séparer les codes entre ";"
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
							
							IdentiteAdministrative idadm = new IdentiteAdministrative(
									result.getString("Prenom"),
									result.getString("Nom"),
									result.getString("Sexe"),
									result.getString("DateNaissance"));
							
							System.out.println("ajout de l'identite administrative : " + idadm.getNom() );
							
							//finalisation avec création de l'objet diagnostic qui reprend les différents diagnostics trouvés dans le champs adicap1
							Diagnostic diag = new Diagnostic(
									code,
									typecode,
									idadm
									);
							
							gendiag.add(diag);
						}
						
						//boucle parcourant l'array pour la colonne adicap2
						while(itr2.hasNext()) {
							
							//stockage du code unique dans une variable String
							String code = itr2.next().toString();
							
							System.out.println("ajout du code : "+ code );
							
							IdentiteAdministrative idadm = new IdentiteAdministrative(
									result.getString("Prenom"),
									result.getString("Nom"),
									result.getString("Sexe"),
									result.getString("DateNaissance"));
							
							System.out.println("ajout de l'identite administrative : " + idadm.getNom() );
							
							//finalisation avec création de l'objet diagnostic qui reprend les différents diagnostics trouvés dans le champs adicap2
							Diagnostic diag = new Diagnostic(
									code,
									typecode,
									idadm
									);
							
							gendiag.add(diag);
						}						
						
						
						compte += 1;
					}
					
					System.out.println("Un total de "+ compte +" patients à été importé de la base anapath");
					compte = 0;
				}
				
				
				
			}
			catch (SQLException e) {
			      e.printStackTrace();
			    }
			
			
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
