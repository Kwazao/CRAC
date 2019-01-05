package module1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

public class IdAdmDAO extends DAO<IdentiteAdministrative>{
	

	//Cette arraylist va contenir tous les objets "IdentiteAdministrative" g�n�r�s
	private ArrayList<IdentiteAdministrative> gen_IdAdm = new ArrayList<>();
	
	public IdAdmDAO(Connection conn) {
		super(conn);
		gen_IdAdm = new ArrayList<>();
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
				
				while(result.next()) {
					
					IdentiteAdministrative idadm = new IdentiteAdministrative(
							result.getString("Prenom"),
							result.getString("Nom"),
							result.getString("Sexe"),
							result.getString("DateNaissance")
							);
					
					//affichage de l'import en en cours
					System.out.println("Import du patient, nom: "+ idadm.getNom()+ " /  pr�nom : "+ idadm.getPrenom()+" / ddn : " + idadm.getDdN() + " / sexe : " + idadm.getSexe() );
					
					//Ajout du patient dans l'arraylist
					gen_IdAdm.add(idadm);
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
		
		
		return gen_IdAdm;
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
