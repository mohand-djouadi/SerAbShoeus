package daos.daoInterfaces;

import java.util.List;
import javabeans.shoeus;

public interface DaoShoeus {
	
	public List<shoeus> getAllShoeus();
	public shoeus getShoeusById(int id);
	
}
