package daos.daoInterfaces;

import javabeans.command;
import java.util.List;

public interface DaoCommand {
	
	public List<command> getAllCommand();
	public command getCommand(int id);
}
