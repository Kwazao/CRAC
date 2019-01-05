package module1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class IdAdmDAO extends DAO<IdentiteAdministrative>{
	

	//Cette arraylist va contenir tous les objets "IdentiteAdministrative" générés
	private ArrayList<IdentiteAdministrative> gen_idadm = new ArrayList<IdentiteAdministrative>();
	
	public IdAdmDAO(Connection conn) {
		super(conn);
		gen_idadm = new ArrayList<>();
	}


	
	//Génération de tous les objets IdentiteAdminsitrative à partir de la bdd (objet connexion)
	public void generateIdAdm() {
	
		//Connexion à la base
		try {
			ResultSet result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM pmsi");
			
			if (result.first()) {
				result.beforeFirst();
				
				int compte = 0;
				String typecodedp = "DP";
				String typecodedr = "DR";
				
				while(result.next()) {
					
					IdentiteAdministrative idadm = new IdentiteAdministrative(
							result.getString("Prenom"),
							result.getString("Nom"),
							result.getString("Sexe"),
							result.getString("DateNaissance")
							);
					
					//récupération du diagnostic principal
					Diagnostic diagdp = new Diagnostic(
							typecodedp,
							result.getString("DP")
							);
					//recupération du diagnostic relié
					Diagnostic diagdr = new Diagnostic(
							typecodedr,
							result.getString("DR")
							);
					
					//ajout dans l'objet identité administrative crée
					idadm.addDiag(diagdp);
					idadm.addDiag(diagdr);
					
					
					//affichage de l'import en en cours
					System.out.println("Import du patient, nom: "+ idadm.getNom()+ " /  prénom : "+ idadm.getPrenom()+" / ddn : " + idadm.getDdN() + " / sexe : " + idadm.getSexe() );
					
					//affichage des diagnostic (parcourt de l'array diag dans l'objet identite administrative
					System.out.println("Diagnostics : ");
					for (Diagnostic dia : idadm.getDiag()) {
						System.out.println(dia.getCodediag());
					}
					
					//Ajout du patient dans l'arraylist
					gen_idadm.add(idadm);
					compte += 1;
					
					
				}
				
				// fin de l'import
				System.out.println("Un total de "+ compte +" patients à été importé de  la base pmsitest");
				compte = 0;
			}
			
			
			
		}
		catch (SQLException e) {
		      e.printStackTrace();
		    }
		
		
	}
	
	
	
	//Récupération de l'arraylist contenant toutes les identités adminsitratives
	public ArrayList<IdentiteAdministrative> getIdAdm(){
		
		
		return gen_idadm;
	}
	
	
	public boolean create(IdentiteAdministrative obj) {
		return false;
	}
	
	public boolean update(IdentiteAdministrative obj) {
		return false;
	}
	
	public boolean delete(IdentiteAdministrative obj) {
		return false;
	}
	
	
	
}
