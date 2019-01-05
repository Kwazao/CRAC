package module1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

public class IdAdmDAO extends DAO<IdentiteAdministrative>{
	

	//Cette arraylist va contenir tous les objets "IdentiteAdministrative" g�n�r�s
	private ArrayList<IdentiteAdministrative> gen_idadm = new ArrayList<IdentiteAdministrative>();
	
	public IdAdmDAO(Connection conn) {
		super(conn);
		gen_idadm = new ArrayList<>();
	}


	
	//G�n�ration de tous les objets IdentiteAdminsitrative � partir de la bdd (objet connexion)
	public void generateIdAdm() {
	
		//Connexion � la base
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
					
					//r�cup�ration du diagnostic principal
					Diagnostic diagdp = new Diagnostic(
							typecodedp,
							result.getString("DP")
							);
					//recup�ration du diagnostic reli�
					Diagnostic diagdr = new Diagnostic(
							typecodedr,
							result.getString("DR")
							);
					
					//ajout dans l'objet identit� administrative cr�e
					idadm.addDiag(diagdp);
					idadm.addDiag(diagdr);
					
					
					//affichage de l'import en en cours
					System.out.println("Import du patient, nom: "+ idadm.getNom()+ " /  pr�nom : "+ idadm.getPrenom()+" / ddn : " + idadm.getDdN() + " / sexe : " + idadm.getSexe() );
					
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
				System.out.println("Un total de "+ compte +" patients � �t� import� de  la base pmsitest");
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
