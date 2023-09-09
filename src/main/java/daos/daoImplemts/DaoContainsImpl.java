package daos.daoImplemts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.DaoFactory;
import daos.daoInterfaces.DaoContains;
import javabeans.command;
import javabeans.contains;

public class DaoContainsImpl implements DaoContains {

	Connection conn = new DaoFactory().getConnection();
	
	contains cn = new contains();
	ArrayList<contains> contains = new ArrayList<contains>();
	
	@Override
	public List<contains> getContains() {
		
		try {
			String sql = "SELECT * FROM contains";
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet result = pstat.executeQuery();
			while(result.next()) {
				cn.setCommandId(result.getInt("command_id"));
				cn.setShoeusId(result.getInt("shoeus_id"));
				cn.setQuantity(result.getInt("quantity"));
				contains.add(cn);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return contains;
	}
	
	@Override
	public List<contains> getCommandContains(command command) {
		
		try {
			String sql = "SELECT shoeus_id,quantity FROM contains WHERE command_id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, command.getId());
			ResultSet result = pstat.executeQuery();
			while (result.next()) {
				cn.setShoeusId(result.getInt("shoeus_id"));
				cn.setQuantity(result.getInt("quantity"));
				contains.add(cn);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return contains;
	}
	
	@Override
	public void addContain(contains contains) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("INSERT INTO contains VALUES(?,?,?)");
			pstat.setInt(1, contains.getCommandId());
			pstat.setInt(2, contains.getShoeusId());
			pstat.setInt(3, contains.getQuantity());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void updateContainQuantity(contains contain, int qty) {
		
		try {
			String sql = "UPDATE contains SET quantity = ? WHERE command_id = ? AND shoeus_id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, qty);
			pstat.setInt(2, contain.getCommandId());
			pstat.setInt(3, contain.getShoeusId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void deleteContain(int idcmd, int idsh) {
		
		try {
			String sql = "DELETE FROM contains WHERE command_id = ? AND shoeus_id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, idcmd);
			pstat.setInt(2, idsh);
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
