package module1;

import java.sql.Connection;
import module2.*;
import module3.*;
import java.util.ArrayList;

public class PatientDAO extends DAO<Patient>{
	
	private ArrayList<Patient> gen_pat = new ArrayList<Patient>();
	
	public PatientDAO(Connection conn) {
		super(conn);
		this.gen_pat = new ArrayList<Patient>();
	}
	
	public void generatePatient(ArrayList<IdentiteAdministrative> arr) {
		
		//INTEGRITE
		//checker l'integrite
		IntegriteChecker integre = new IntegriteChecker(arr);
		integre.checkIntegrite();
				
		//DOUBLONS
		//nouvel objet doublon
		DoublonChecker doublon = new DoublonChecker(arr);
		//traitement des doublons
		doublon.generateDoublonCheck();
		//stockage de la nouvelle liste patient sans doublon strict dans this.gen_pat
		this.gen_pat.addAll(doublon.getArraypa());
		
		//SOUNDEX LEVENSHTEIN
		SoundexLevChecker slchecker = new SoundexLevChecker(this.gen_pat);
		//génération du soundlevcheck
		slchecker.generateSoundLev();
		//recuperation de la liste patient après traitement
		slchecker.getPatient();
		//test print
		for(Patient pa : slchecker.getPatient()) {
			System.out.println("Patient importé : "+ pa.getNom()+" "+pa.getPrenom());
		}
		
		
		
		
		
		
		
	}
	
	public ArrayList<Patient> getPatients() {
		return this.gen_pat;
	}
	
	public boolean create(Patient obj) {
		return false;
	}
	
	public boolean update(Patient obj) {
		return false;
	}
	
	public boolean delete(Patient obj) {
		return false;
	}
}

