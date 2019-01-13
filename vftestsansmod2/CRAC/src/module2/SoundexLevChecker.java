package module2;

import java.util.ArrayList;
import java.util.Iterator;

import module1.*;
import module3.*;

public class SoundexLevChecker {
	
	private ArrayList<Patient> arr_pa = new ArrayList<Patient>();
	
	public SoundexLevChecker(ArrayList<Patient> arr_pa) {
		this.arr_pa = arr_pa;
		
	}
	
	public void generateSoundLev() {
		
		ArrayList<Patient> arr_pa_comp = arr_pa;
		
		
		for (Iterator<Patient> iterator = arr_pa.iterator(); iterator.hasNext();) {
		//for (Patient pa : this.arr_pa) {
			Patient pa = iterator.next();
			
			
			for(Iterator<Patient> iterator2 = arr_pa_comp.iterator(); iterator2.hasNext();) {
			//for(Patient pac : arr_pa_comp) {
				Patient pac = iterator2.next();
				
				// TROISEME REQUETE : SOUNDEX + LEVENSHTEIN
				//QUATRIEME REQUETE : LEVENSHTEIN sur Nom, Prenom si DateNaissance, Sexe identiques
				if (pa.getNom() != pac.getNom() && pa.getPrenom() != pac.getPrenom() && pa.getDdN() == pac.getDdN() && pa.getSexe() == pac.getSexe()){
					
					String str1 = pa.getPrenom() + pa.getNom();
					String str2 = pac.getPrenom() + pac.getNom();
					
					Integer dist = Lev1.editDistDP(str1, str2, str1.length(), str2.length());
					
					if (dist<=2 && dist>0) {
						
						//on rajoute les caractéristiques de ce patient aux caractéristiques de patient identique
						pa.getIDa().addAll(pac.getIDa());
						this.arr_pa.remove(pac);
						
						
					} else {
					
						
					String stra = pa.getNom() + pa.getPrenom();
					String strb = pac.getNom() + pac.getPrenom();
					
					String sounda = Soundex.soundex(stra);
					String soundb = Soundex.soundex(strb);
					
					Integer dist2 = Lev1.editDistDP(sounda, soundb, sounda.length(), soundb.length());
					
					if (dist2<=2 && dist2>0) {
						
						pa.getIDa().addAll(pac.getIDa());
						arr_pa.remove(pac);
						
					} else {}
					
				}
			
					//CINQUIEME REQUETE : LEVENSHTEIN sur DateNaissance si Nom, Prenom, Sexe identiques
			} else if (pa.getNom() == pac.getNom() && pa.getPrenom() == pac.getPrenom() && pa.getDdN() != pac.getDdN() && pa.getSexe() == pac.getSexe()) {
				
				String stra = pa.getDdN();
				String strb = pac.getDdN();
				
				Integer dist3 = Lev1.editDistDP(stra,strb,stra.length(),strb.length());
				
				if (dist3 ==1) {
					
					pa.getIDa().addAll(pac.getIDa());
					arr_pa.remove(pac);
				} else if (pa.getNom() == pac.getNom() && pa.getPrenom() == pac.getPrenom() && pa.getDdN() == pac.getDdN() && pa.getSexe() != pac.getSexe()) {
				
					System.out.println("simple erreur de sexe");
					
					pa.getIDa().addAll(pac.getIDa());
					arr_pa.remove(pac);
				}
			}
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
		}
		
		
	}
	
	public ArrayList<Patient> getPatient(){
		return this.arr_pa;
	}

}
