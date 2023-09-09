package daos.daoInterfaces;

import javabeans.command;
import javabeans.shoeus;
import javabeans.user;

import java.util.List;

public interface DaoCommand {
	
	public List<command> getAllCommand(user user);
	public List<shoeus> getCommandContains(command command);
	public void addCommand(command command);
	public void deleteCommand(command command);
}
