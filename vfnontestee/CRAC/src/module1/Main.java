/* Cod� par Kevin Ouazzani */
package module1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// TEST AVEC IDENTITE ADMINISTRATIVES
		//IdAdmDAO idadmdao = new IdAdmDAO(Connexion.getInstance());
		
		//System.out.println("Cr�ation des identit�s administratives... ");//on g�n�re toutes les identit�s patient � partir du fichier 
		
		
		
		
		// TEST AVEC DIAGNOSTICS
		
		/*
		for (IdentiteAdministrative idadm : diagdao.getIdAdm()) {
			System.out.println(idadm.getNom());
		}
		*/
		
		//
		
		
		//pour r�cup les cancer
		//initialisation d'un objet patientdao
		PatientDAO patientdao = new PatientDAO(Connexion.getInstance());
		
		//recup des id avec diag depuis anapath
		DiagnosticDAO diagdao = new DiagnosticDAO(Connexion.getInstance());
		diagdao.generateDiag(); //g�n�ration des identite administratives a partir du fichier anapath
		
		//recup des id a depuis pmsi
		IdAdmDAO idadmdao = new IdAdmDAO(Connexion.getInstance());
		idadmdao.generateIdAdm();//g�n�ration des identite administratives
		
		
		// liste patient a r�cup�rer suite au traitement du module 2
		//on creer la liste patient � partir des deux listes g�n�r�es � partir de pmsi et d'anapath ci dessus
		ArrayList<IdentiteAdministrative> listidadm = new ArrayList<IdentiteAdministrative>();
		listidadm.addAll(diagdao.getIdAdm());
		listidadm.addAll(idadmdao.getIdAdm());
		 
		 
		patientdao.generatePatient(listidadm); // g�n�re tous les patients � partir de la list IdAdm (module2)
		 
		patientdao.getPatients(); // recup�ration de tous les patients g�n�r�s sous forme d'array
		 
		// boucle EXEMPLE pour r�cup�rer les cancers de tous les patients de la liste patient
		for (Patient patient : patientdao.getPatients()) {
			 
			System.out.println("Nom du patient : " + patient.getNom());
			 
			for (Cancer cancer : patient.getCa()) { //on boucle ensuite sur les cancer de chaque patient
				 
				System.out.println("code IACR morpho : " + cancer.getIacrm());
				System.out.println("code IACR topo :" + cancer.getIacrt());
			}
		}
		
		
		
		
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
