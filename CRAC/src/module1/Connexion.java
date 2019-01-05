/* Codé par Kevin Ouazzani */
package module1;

/*TODO 
 * 1) etablir une connexion avec base locale
 * 2) Importer des data depuis le base et instancier les objets
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connexion{

	  //URL de connexion
	  private static String url = "jdbc:mysql://localhost:3306/crac";
	  //Nom du user
	  private static String user = "root";
	  //Mot de passe de l'utilisateur
	  private static String passwd = "";
	  //Objet Connection
	  private static Connection connect;	

	  
  /**
  * Méthode qui va retourner notre instance
  * et la créer si elle n'existe pas...
  * @return
  */
  public static Connection getInstance(){
    if(connect == null){
      try {
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
        connect = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
      } catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }		
    return connect;	
  }
}