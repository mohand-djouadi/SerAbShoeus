package daos.daoInterfaces;

import javabeans.user;

public interface DaoUser {
	
	public user getUser(String username, String password);
	public void addUser(user user);
	public void updateUsername(user user);
	public void updatePassword(user user);
	public void deleteUser(int id);
	
}
