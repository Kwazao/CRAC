package module2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Module2 {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        // TODO Auto-generated method stub

        
        /**
         * 3306 is the default port for MySQL in XAMPP. Note both the 
         * MySQL server and Apache must be running. 
         */
        String url = "jdbc:mysql://localhost/projetime202";

        /**
         * The MySQL user.
         */
        String user = "root";

        /**
         * Password for the above MySQL user. If no password has been 
         * set (as is the default for the root user in XAMPP's MySQL),
         * an empty string can be used.
         */
        String password = "";
    	

//while (true){ //Relance le programme à l'infini
        try
        {
        	while (true){
        		
        		Class.forName("com.mysql.jdbc.Driver").newInstance();
        		Connection con = DriverManager.getConnection(url, user, password);
        		java.sql.Statement stt = con.createStatement();

        		// CHOIX de la BDD :
        		String bdd = "identitovigilance_test";
        		//String bdd = "pmsi";   


        		// PREMIERE REQUETE : Test d'intégrité des données
        
        		int nb_integr = 0;

        		System.out.println("_______________________________________________________________ \nTest d'intégrité des données: \n");
    
        		//Requête SQL vérifiant qu'aucune valeur n'est vide
        		ResultSet inté = stt.executeQuery("SELECT * FROM "+bdd+" WHERE `Sexe` =! (1 OR 2) OR `DateNaissance` ='' OR `Prenom` ='' OR `Nom` =''");
        		//Affiche les données non intègres
        		while (inté.next()){
        			System.out.println("\nID" + inté.getString(1) + "\nSexe: " + inté.getString(2) + "\nDate de naissance: " + inté.getString(3)+ "\nPrenom: " + inté.getString(4)+ "\nNom: " + inté.getString(5));
        			nb_integr +=1;
        			System.out.println("\nNombre de cases vides :" + nb_integr);
       
        	}
        		
        		
        		
        		
        		
            		
// DEUXIEME REQUETE : Détection des doublons
int nb_doublon = 0;       
       
System.out.println("Test des doublons stricts: \n");
            			
       //Requête SQL sortant tous les doublons strics et les co
       ResultSet doub = stt.executeQuery("SELECT COUNT(*) AS nbr_doublon, `Sexe`, `DateNaissance`, `Prenom`,`Nom` FROM "+bdd+" GROUP BY `Sexe`, `DateNaissance`, `Prenom`,`Nom` HAVING COUNT(*) > 1");
       //Affiche les données retournées
       while (doub.next()){
    	   System.out.println("\nLignes identiques :" + doub.getString(1) + "\nSexe: " + doub.getString(2) + "\nDate de naissance: " + doub.getString(3)+ "\nPrenom: " + doub.getString(4)+ "\nNom: " + doub.getString(5));
    	   nb_doublon +=1;
    	   
       }
       		System.out.println("\nNombre de doublons:" + nb_doublon);
// TROISEME REQUETE : SOUNDEX + LEVENSHTEIN
int same_soundex = 0;       

       
System.out.println("\nTest des SOUNDEX: \n");
ArrayList<String> l3 = new ArrayList<String>();

	//Requête SQL regroupant SOUNDEX identiques seulement:
//	ResultSet sound = stt.executeQuery("SELECT COUNT(*) AS same_soundex, SOUNDEX(`Prenom`), SOUNDEX(`Nom`) FROM "+bdd+" GROUP BY SOUNDEX(`Prenom`), SOUNDEX(`Nom`) HAVING COUNT(*) > 1");
    
	//Requête SQL SOUNDEX si DateNaissance, Sexe identiques:
	ResultSet sound = stt.executeQuery("SELECT DISTINCT SOUNDEX(Nom), SOUNDEX(Prenom) FROM "+bdd+" AS t1 WHERE EXISTS ( SELECT * FROM "+bdd+" AS t2 WHERE (t1.Nom <> t2.Nom OR t1.Prenom <> t2.Prenom) AND t1.DateNaissance = t2.DateNaissance AND t1.Sexe = t2.Sexe )");
	while (sound.next()) {
//    	System.out.println("\nSOUNDEX(Nom): " + sound.getString(1) + "\nSOUNDEX(Prenom): " + sound.getString(2));
 	   	String str1 = sound.getString(1) + sound.getString(2);
//		System.out.println(str1);
		l3.add(str1);
//		System.out.println(l1);
		for(int i = 0; i < l3.size()-1; i++) {
			String str2 = l3.get(i);
			int dist = Lev1.editDistDP( str1 , str2 , str1.length(), str2.length());
			if (dist<=2 & dist>0){
				System.out.println(str1 + " " + str2 + ":");
				System.out.println(dist);
				same_soundex +=1;
			}
		}
    
	}
    System.out.println("\nNombre de SOUNDEX+LEV similaires:" + same_soundex);
    
//QUATRIEME REQUETE : LEVENSHTEIN sur Nom, Prenom si DateNaissance, Sexe identiques
int similar_lev = 0;
ArrayList<String> l1 = new ArrayList<String>();


System.out.println("\nTest de LEVENSHTEIN sur les Noms, Prenoms: \n");    

	//Requête SQL :
	ResultSet lev1 = stt.executeQuery("SELECT DISTINCT Nom, Prenom FROM "+bdd+" AS t1 WHERE EXISTS ( SELECT * FROM "+bdd+" AS t2 WHERE (t1.Nom <> t2.Nom OR t1.Prenom <> t2.Prenom) AND t1.DateNaissance = t2.DateNaissance AND t1.Sexe = t2.Sexe )");
	while (lev1.next()) {
		String str1 = lev1.getString(1) + lev1.getString(2);
//		System.out.println(str1);
		l1.add(str1);
//		System.out.println(l1);
		for(int i = 0; i < l1.size()-1; i++) {
			String str2 = l1.get(i);
			int dist = Lev1.editDistDP( str1 , str2 , str1.length(), str2.length());
			if (dist<=2 & dist>0){
				System.out.println(str1 + " " + str2 + ":");
				System.out.println(dist);
				similar_lev += 1;
			}

			
		}
		
	}
	System.out.println("\nNombre de scores similaires pour Nom, Prenom:" + similar_lev);
	
//CINQUIEME REQUETE : LEVENSHTEIN sur DateNaissance si Nom, Prenom, Sexe identiques
int similar_lev2 = 0;
ArrayList<String> l2 = new ArrayList<String>();


System.out.println("\nTest de LEVENSHTEIN sur DateNaissance: \n");    

		//Requête SQL :
		ResultSet lev2 = stt.executeQuery("SELECT DISTINCT DateNaissance FROM "+bdd+" AS t1 WHERE EXISTS ( SELECT * FROM "+bdd+" AS t2 WHERE t1.DateNaissance <> t2.DateNaissance AND t1.Prenom = t2.Prenom AND t1.Nom = t2.Nom AND t1.Sexe = t2.Sexe )");
		while (lev2.next()) {
			String str1 = lev2.getString(1);
//			System.out.println(str1);
			l2.add(str1);
//			System.out.println(l1);
			for(int i = 0; i < l2.size()-1; i++) {
				String str2 = l2.get(i);
				int dist2 = Lev1.editDistDP( str1 , str2 , str1.length(), str2.length());
				if (dist2 == 1){
					System.out.println(str1 + " " + str2 + ":");
					System.out.println(dist2);
					similar_lev += 1;
				}

				
			}
			
		}
		System.out.println("\nNombre de scores similaires pour DateNaissance:" + similar_lev);
	
//SIXIEME REQUETE : Détection des erreur de sexe
	//Requête SQL :
	ResultSet sex = stt.executeQuery("SELECT DISTINCT * FROM "+bdd+" AS t1 WHERE EXISTS ( SELECT * FROM "+bdd+" AS t2 WHERE t1.Sexe <> t2.Sexe AND t1.Prenom = t2.Prenom AND t1.Nom = t2.Nom AND t1.DateNaissance = t2.DateNaissance )");
	while (sex.next()) {
		System.out.println("\nID: " + sex.getString(1) + "\nSexe: " + sex.getString(2) + "\nDate de naissance: " + sex.getString(3)+ "\nPrenom: " + sex.getString(4)+ "\nNom: " + sex.getString(5));
 	   
		
	}
            
            
            
            
            
            
            
       return;
        	}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {}
//		}
    }
}
    