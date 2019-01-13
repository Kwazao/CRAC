package module1;

import java.sql.Connection;
import java.util.ArrayList;

public class PatientDAO extends DAO<Patient>{
	
	private ArrayList<Patient> gen_pat = new ArrayList<Patient>();
	
	public PatientDAO(Connection conn) {
		super(conn);
		this.gen_pat = new ArrayList<Patient>();
	}
	
	public void generatePatient(ArrayList<IdentiteAdministrative> arr) {
		
		//integrer le module2
		//recup array
		
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

