package daos.daoImplemts;

import daos.daoInterfaces.DaoUser;
import daos.DaoFactory;
import javabeans.user;
import java.sql.*;

public class DaoUserImpl implements DaoUser{

	Connection conn = new DaoFactory().getConnection();
	
	@Override
	public user getUser(String username, String password) {
		
		user user = new user();
		try {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
			pstat.setString(1,username);
			pstat.setString(2, password);
			ResultSet result = pstat.executeQuery();
			
			user.setId(result.getInt("id"));
			user.setFirstname(result.getString("firstname"));
			user.setLastname(result.getString("lastname"));
			user.setEmail(result.getString("email"));
			user.setUsername(result.getString("username"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(user user) {
		
		try {
			String sql = "INSERT INTO user(firstname,lastname,email,username,password) VALUES(?,?,?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getFirstname());
			pstat.setString(2, user.getLastname());
			pstat.setString(3, user.getEmail());
			pstat.setString(4, user.getUsername());
			pstat.setString(5, user.getPassword());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateUsername(user user) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("UPDATE user SET username = ? WHERE id = ?");
			pstat.setString(1,user.getUsername());
			pstat.setInt(2,user.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void updatePassword(user user) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("UPDATE user SET password = ? WHERE id = ?");
			pstat.setString(1,user.getPassword());
			pstat.setInt(2,user.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void deleteUser(int id) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("DELETE FROM user WHERE id = ?");
			pstat.setInt(1, id);
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
