package module3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import module1.*;

public class AnapathToCancer extends DAO<Cancer>{
	
	private ArrayList<Patient> array_pat = new ArrayList<Patient>();
	
	public AnapathToCancer (Connection conn, ArrayList<Patient> arr ) {
	
		super(conn);
		this.array_pat = arr;
		
	}
	
		
	public void Cim10toCancer( ArrayList<Patient> arr_pa ) {
        // connecter la base de données

        ResultSet rs1 = null;
        PreparedStatement ptmt1 = null;
        ResultSet rs2 = null;
        PreparedStatement ptmt2 = null;
        ResultSet rs3 = null;
        PreparedStatement ptmt3 = null;
        ResultSet rs4 = null;
        PreparedStatement ptmt4 = null;
        ResultSet rs5 = null;
        PreparedStatement ptmt5 = null;
        ResultSet rs6 = null;
        PreparedStatement ptmt6 = null;
        ResultSet rs7 = null;
        PreparedStatement ptmt7 = null;
        ResultSet rs8 = null;
        PreparedStatement ptmt8 = null;
        ResultSet rs9 = null;
        PreparedStatement ptmt9 = null;

        //Cancer cancer = new Cancer();
        
        try {
        //Faire une boucle sur tous les cancer des patients en entrée
        for (Patient pa  : arr_pa) {
        	
        	for (IdentiteAdministrative ida : pa.getIDa()){
        
        		for (Diagnostic dia : ida.getDiag()){
        
             // METTRE ICI CE QUI UTILISE DP DAS DR ADICAP ?
             // AVEC DES CASE
             
        			switch (dia.getTypediag()) {
        			
        				case "dp" :
        					
        					String DP = dia.getCodediag();
        					
        					ptmt1= this.connect.prepareStatement("{call CIM10_DP(?)}");
        		            ptmt1.setString(1, DP);
        		            
        		            rs1=ptmt1.executeQuery();
        		            
        		            while (rs1.next()) {
        		            	//creation des groupe de to et mo
        		            	Cancer cancer = new Cancer();
        		                //System.out.println("CODMORPHOCIMO3"+" "+rs1.getString("CODMORPHOCIMO3"));
        		                String DP_CODMORPHOCIMO3=rs1.getString("CODMORPHOCIMO3");
        		                //System.out.println("CODTOPOCIMO3"+" "+rs1.getString("CODTOPOCIMO3"));    
        		                String DP_CODTOPOCIMO3=rs1.getString("CODTOPOCIMO3");
        		                
        		                ptmt2= this.connect.prepareStatement("{call CIM10_DP1(?)}");
        		                ptmt2.setString(1,DP_CODTOPOCIMO3);
        		                rs2=ptmt2.executeQuery();
        		                
        		                while(rs2.next()) {
        		                	
        		                	System.out.println("DP:"+ DP);
        		                	cancer.setCimot(DP_CODTOPOCIMO3);
        		                	
        		                    System.out.println("CODTOPOCIMO3"+" "+DP_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs2.getString("GROUPE_TOPO_IACR"));
        		                    cancer.setIacrt(rs2.getString("GROUPE_TOPO_IACR"));
        		                    
        		                    
        		                    ptmt3= connect.prepareStatement("{call CIM10_DP2(?)}");
        		                    ptmt3.setString(1,DP_CODMORPHOCIMO3);
        		                    rs3=ptmt3.executeQuery();
        		                    
        		                    while(rs3.next()) {
        		                    	
        		                        cancer.setCimom(DP_CODMORPHOCIMO3);
        		                        System.out.println("CODTOPOCIMO3"+" "+DP_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs3.getString("GROUPE_MORPHO_IACR"));
        		                        cancer.setIacrm(rs3.getString("GROUPE_MORPHO_IACR"));
        		                        System.out.println("---------------------------------------------------");
        		                      
        		                    }
        		                }
        		                
        		               pa.addCa(cancer); //on ajoute le cancer au patient
        		            }
        					
        		            
        				case "dr" :
        					
        					//DR
        		            String DR = dia.getCodediag();
        					
        		            ptmt4= this.connect.prepareStatement("{call CIM10_DR(?)}");
        		            ptmt4.setString(1, DR);
        		            rs4=ptmt4.executeQuery();
        		            
        		            if(DR=="") {
        		            	System.out.println("y a pas de DR POUR ce groupe diagnostic ");
        		            	System.out.println("---------------------------------------------------");
        		            }else {
        		            while (rs4.next()) {
        		            	Cancer cancer = new Cancer();
        		                //System.out.println("CODMORPHOCIMO3"+" "+rs4.getString("CODMORPHOCIMO3"));
        		                String DR_CODMORPHOCIMO3=rs4.getString("CODMORPHOCIMO3");
        		                //System.out.println("CODTOPOCIMO3"+" "+rs4.getString("CODTOPOCIMO3"));    
        		                String DR_CODTOPOCIMO3=rs4.getString("CODTOPOCIMO3");
        		                
        		                ptmt5= this.connect.prepareStatement("{call CIM10_DR1(?)}");
        		                ptmt5.setString(1,DR_CODTOPOCIMO3);
        		                rs5=ptmt5.executeQuery();
        		                
        		                while(rs5.next()) {
        		                	System.out.println("DR:"+"");
        		                	cancer.setCimot(DR_CODTOPOCIMO3);
        		                    System.out.println("CODTOPOCIMO3"+" "+DR_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs5.getString("GROUPE_TOPO_IACR"));
        		                    cancer.setIacrt(rs5.getString("GROUPE_TOPO_IACR"));
        		                    
        		                    
        		                    ptmt6= this.connect.prepareStatement("{call CIM10_DP2(?)}");
        		                    ptmt6.setString(1,DR_CODMORPHOCIMO3);
        		                    rs6=ptmt6.executeQuery();
        		                    while(rs6.next()) {
        		                    	
        		                        cancer.setCimom(DR_CODMORPHOCIMO3);
        		                        System.out.println("CODMORPHOCIMO3"+" "+DR_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs6.getString("GROUPE_MORPHO_IACR"));
        		                        cancer.setIacrm(rs6.getString("GROUPE_MORPHO_IACR"));
        		                        System.out.println("---------------------------------------------------");
        		                    }
        		                }
        		            
        		                pa.addCa(cancer);
        		            }
        		            }
        		         
        				case "das":
        					
        					String DAS = dia.getCodediag();
        					
        					ptmt7= this.connect.prepareStatement("{call CIM10_DAS(?)}");
        		            ptmt7.setString(1, DAS);
        		            rs7=ptmt7.executeQuery();
        		            
        		            while (rs7.next()) {
        		            	Cancer cancer = new Cancer();
        		                //System.out.println("CODMORPHOCIMO3"+" "+rs7.getString("CODMORPHOCIMO3"));
        		                String DAS_CODMORPHOCIMO3=rs7.getString("CODMORPHOCIMO3");
        		                //System.out.println("CODTOPOCIMO3"+" "+rs7.getString("CODTOPOCIMO3"));    
        		                String DAS_CODTOPOCIMO3=rs7.getString("CODTOPOCIMO3");
        		                
        		                ptmt8= this.connect.prepareStatement("{call CIM10_DAS1(?)}");
        		                ptmt8.setString(1,DAS_CODTOPOCIMO3);
        		                rs8=ptmt8.executeQuery();
        		                while(rs8.next()) {
        		                	System.out.println("DAS:"+DAS);
        		                	cancer.setCimot(DAS_CODTOPOCIMO3);
        		                    System.out.println("CODTOPOCIMO3"+" "+DAS_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs8.getString("GROUPE_TOPO_IACR"));
        		                    cancer.setIacrt(rs8.getString("GROUPE_TOPO_IACR"));
        		                    
        		                    
        		                    ptmt9= this.connect.prepareStatement("{call CIM10_DAS2(?)}");
        		                    ptmt9.setString(1,DAS_CODMORPHOCIMO3);
        		                    rs9=ptmt9.executeQuery();
        		                    while(rs9.next()) {
        		                    	
        		                        cancer.setCimom(DAS_CODMORPHOCIMO3);
        		                        System.out.println("CODMORPHOCIMO3"+" "+DAS_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs9.getString("GROUPE_MORPHO_IACR"));
        		                        cancer.setIacrm(rs9.getString("GROUPE_MORPHO_IACR"));
        		                        System.out.println("---------------------------------------------------");
        		                    }
        		                }
        		            
        		            pa.addCa(cancer);
        		            }
        					
        					
        					
        			
        			}
        		}
        	}
        
        }

    
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                if (rs1 != null)
                {
                    rs1.close();
                }
                if (ptmt1 != null)
                {
                    ptmt1.close();
                }
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
    
	
	
	
	
	public void AdicaptoCancer( ArrayList<Patient> arr_pa ) {
        // connecter la base de données
 
        ResultSet rs1 = null;
        PreparedStatement ptmt1 = null;
        ResultSet rs2 = null;
        PreparedStatement ptmt2 = null;
        ResultSet rs3 = null;
        PreparedStatement ptmt3 = null;
        ResultSet rs4 = null;
        PreparedStatement ptmt4 = null;
        
  
 
    
        try {
        
        for (Patient pa  : arr_pa) {
            	
            	for (IdentiteAdministrative ida : pa.getIDa()){
            
            		for (Diagnostic dia : ida.getDiag()){
            			
            			String lesion_patient = dia.getCodediag().substring(4,8);
            			String organe_patient = dia.getCodediag().substring(2,4);
            		
            			
            			if (dia.getTypediag() == "adicap") {
            				
            				Cancer cancer = new Cancer();
            				//conn = DBConnection.getConnection(); //oldcode
            				// manipulation de la base de données            StringBuilder sb1 = new StringBuilder();            //sb1.append("SELECT ADICAP_LESION,TRANSCODAGE_ADICAPCIMO3_MORPHO.CODMORPHOCIMO3 FROM anapath inner join TRANSCODAGE_ADICAPCIMO3_MORPHO on TRANSCODAGE_ADICAPCIMO3_MORPHO.LESION='lesion_patient'");
            				ptmt1= this.connect.prepareStatement("{call lesion(?)}");
            				ptmt1.setString(1, lesion_patient);
            				rs1=ptmt1.executeQuery();
            				
            				while (rs1.next()) {
            					
            					
            					
            					System.out.println("lesion:"+lesion_patient);
            					//System.out.println("CODMORPHOCIMO3"+" "+rs1.getString("CODMORPHOCIMO3"));
            					String MOR_CODMORPHOCIMO3=rs1.getString("CODMORPHOCIMO3");  
            					ptmt2= this.connect.prepareStatement("{call lesion2(?)}");
            					ptmt2.setString(1, MOR_CODMORPHOCIMO3);
            					rs2=ptmt2.executeQuery();
                
            					while(rs2.next()) {
            						cancer.setCimom(MOR_CODMORPHOCIMO3);
            						System.out.println("CODMORPHOCIMO3"+" "+MOR_CODMORPHOCIMO3+" "+"GROUPE_MORPHO_IACR"+" "+rs2.getString("GROUPE_MORPHO_IACR"));
            						cancer.setIacrm(rs2.getString("GROUPE_MORPHO_IACR"));
            						
            					}
            					
            				}

            				ptmt3= this.connect.prepareStatement("{call organe(?)}");
            				ptmt3.setString(1, organe_patient);
            				rs3=ptmt3.executeQuery();
            
            				while(rs3.next()) {
            					
            				
            					//System.out.println("CODTOPOCIMO3"+" "+rs3.getString("CODTOPOCIMO3"));
        
            					String TOPO_CODTOPOCIMO3=rs3.getString("CODTOPOCIMO3");
          
            					ptmt4= this.connect.prepareStatement("{call organe2(?)}");
            					ptmt4.setString(1,TOPO_CODTOPOCIMO3);
            					rs4=ptmt4.executeQuery();
            
            					while(rs4.next()) {
            						System.out.println("organe:"+organe_patient);
            						cancer.setCimot(TOPO_CODTOPOCIMO3);
            						System.out.println("CODTOPOCIMO3"+" "+TOPO_CODTOPOCIMO3+" "+"GROUPE_TOPO_IACR"+" "+rs4.getString("GROUPE_TOPO_IACR"));
            						cancer.setIacrt(rs4.getString("GROUPE_TOPO_IACR"));
            					}

            			
            				}
            				
            				pa.addCa(cancer);
    
            			}else {}
            			
            		}
            		
            	}
            	
        }
            			
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {

            try
            {
                if (rs1 != null)
                {
                    rs1.close();
                }
                if (ptmt1 != null)
                {
                    ptmt1.close();
                }
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	

    }
		
	public boolean create(Cancer obj) {
		return false;
	}
	
	public boolean update(Cancer obj) {
		return false;
	}
	
	public boolean delete(Cancer obj) {
		return false;
	}
		
	}
	

