package daos.daoImplemts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.DaoFactory;
import daos.daoInterfaces.DaoMessage;
import javabeans.message;
import javabeans.user;

public class DaoMessageImpl implements DaoMessage {

	Connection conn = new DaoFactory().getConnection();
	message msg = new message();
	
	@Override
	public List<message> getAllMessages(user user) {
		
		ArrayList<message> messages = new ArrayList<message>();
		 
		try {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM message WHERE usr_id = ?");
			pstat.setInt(1,user.getId());
			ResultSet result = pstat.executeQuery();
			
			while (result.next()) {
				msg.setId(result.getInt("id"));
				msg.setObjectif(result.getString("objectif"));
				msg.setText(result.getString("text"));
				msg.setSendDate(result.getDate("send_date"));
				messages.add(msg);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return messages;
	}

	@Override
	public void sendMessage(message meg) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("INSERT INTO message(usr_id,objectif,text) VALUES(?,?,?)");
			pstat.setInt(1, meg.getUserId());
			pstat.setString(2, meg.getObjectif());
			pstat.setString(3, meg.getText());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateMessageText(message msg, user user, String objectif) {
		
		try {
			String sql = "UPDATE message SET objectif = ? WHERE usr_id = ? AND id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, objectif);
			pstat.setInt(2, user.getId());
			pstat.setInt(3, msg.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		

	}
	
	@Override
	public void updateMessageObjectif(message msg, user user, String text) {
		
		try {
			String sql = "UPDATE message SET text = ? WHERE usr_id = ? AND id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, text);
			pstat.setInt(2, user.getId());
			pstat.setInt(3, msg.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void deleteMessage(message msg) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("DELETE FROM message WHERE id = ?");
			pstat.setInt(1, msg.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
