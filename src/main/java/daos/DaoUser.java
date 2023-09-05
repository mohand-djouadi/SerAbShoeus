package daos;

import javabeans.user;

public interface DaoUser {
	
	public user getUser(int id);
	public void addUser(String firstname, String lastname, String email, String username, String password);
	
}
