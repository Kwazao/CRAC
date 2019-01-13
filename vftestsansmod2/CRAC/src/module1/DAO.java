package module1;

import java.sql.Connection;
// TODO créer DAO capable d'instancier les objets (fait appel à la classe connexion et instancie des objets identite et diagnostic


public abstract class DAO<T> {
	protected Connection connect = null;
	   
	  public DAO(Connection conn){
	    this.connect = conn;
	  }
	
	 public abstract boolean create(T obj);

	 
	 public abstract boolean delete(T obj);

	 
	 public abstract boolean update(T obj);


}
