package daos.daoInterfaces;

import javabeans.contains;
import javabeans.command;
import java.util.List;

public interface DaoContains {
	
	public List<contains> getContains();
	public void addContain(contains contains);
	public void updateContainQuantity(contains contain, int qty);
	public void deleteContain(int idcmd, int idsh);
	
}
