package module1;

import java.sql.Connection;
import java.util.ArrayList;

public class CancerDAO extends DAO<Cancer>{
	
	private ArrayList<Cancer> calist = new ArrayList<Cancer>();
	
	public CancerDAO(Connection conn) {
		super(conn);
		this.calist = new ArrayList<Cancer>();
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
