/* Codé par Kevin Ouazzani */
package module1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// TEST AVEC IDENTITE ADMINISTRATIVES
		//IdAdmDAO idadmdao = new IdAdmDAO(Connexion.getInstance());
		
		//System.out.println("Création des identités administratives... ");//on génère toutes les identités patient à partir du fichier 
		
		
		
		
		// TEST AVEC DIAGNOSTICS
		
		/*
		for (IdentiteAdministrative idadm : diagdao.getIdAdm()) {
			System.out.println(idadm.getNom());
		}
		*/
		
		//
		
		
		//pour récup les cancer
		//initialisation d'un objet patientdao
		PatientDAO patientdao = new PatientDAO(Connexion.getInstance());
		
		//recup des id avec diag depuis anapath
		DiagnosticDAO diagdao = new DiagnosticDAO(Connexion.getInstance());
		diagdao.generateDiag(); //génération des identite administratives a partir du fichier anapath
		
		//recup des id a depuis pmsi
		IdAdmDAO idadmdao = new IdAdmDAO(Connexion.getInstance());
		idadmdao.generateIdAdm();//génération des identite administratives
		
		
		// liste patient a récupérer suite au traitement du module 2
		//on creer la liste patient à partir des deux listes générées à partir de pmsi et d'anapath ci dessus
		ArrayList<IdentiteAdministrative> listidadm = new ArrayList<IdentiteAdministrative>();
		listidadm.addAll(diagdao.getIdAdm());
		listidadm.addAll(idadmdao.getIdAdm());
		 
		 
		patientdao.generatePatient(listidadm); // génère tous les patients à partir de la list IdAdm (module2)
		 
		patientdao.getPatients(); // recupération de tous les patients générés sous forme d'array
		 
		// boucle EXEMPLE pour récupérer les cancers de tous les patients de la liste patient
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
