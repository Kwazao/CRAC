/* Cod� par Kevin Ouazzani */
package module1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// TEST AVEC IDENTITE ADMINISTRATIVES
		
		
		
		IdAdmDAO idadmdao = new IdAdmDAO(Connexion.getInstance());
		
		System.out.println("Cr�ation des identit�s administratives... ");
		idadmdao.generateIdAdm();
		
		System.out.println("R�cup�ration des objets g�n�r�s...");
		
		
		
		
		
		
		//TODO
		/*
		 * Import data -> SQL (R) : 
		 * 
		 * Depuis la base SQL ->instancier objets Ideetite adm
		 * 
		 * 
		 * 
		 * Module 2 sur tous les identite adminsitratives
		 * 
		 */
		
	}

}
