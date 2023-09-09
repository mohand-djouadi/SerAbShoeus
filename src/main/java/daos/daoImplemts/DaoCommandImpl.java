package daos.daoImplemts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.DaoFactory;
import daos.daoInterfaces.DaoCommand;
import daos.daoInterfaces.DaoContains;
import daos.daoInterfaces.DaoShoeus;
import javabeans.command;
import javabeans.contains;
import javabeans.shoeus;
import javabeans.user;

public class DaoCommandImpl implements DaoCommand {

	Connection conn = new DaoFactory().getConnection();
	DaoContains daocn = new DaoContainsImpl();
	DaoShoeus daosh = new DaoShoeusImpl();
	command cmd = new command();
	
	@Override
	public List<command> getAllCommand(user user) {
		
		ArrayList<command> commands = new ArrayList<command>();
		
		try {
			PreparedStatement pstat = conn .prepareStatement("SELECT * FROM command WHERE user_id = ?");
			pstat.setInt(1, user.getId());
			ResultSet result = pstat.executeQuery();
			while (result.next()) {
				cmd.setId(result.getInt("id"));
				cmd.setUserId(result.getInt("user_id"));
				cmd.setTotalPrice(result.getDouble("total_price"));
				for (contains conts : daocn.getCommandContains(cmd)) {
					cmd.addShoeus(daosh.getShoeusById(conts.getShoeusId()), conts.getQuantity());
				}
				commands.add(cmd);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return commands;
	}

	@Override
	public void addCommand(command command) {
		
		try {
			String sql = "INSERT INTO command(user_id,total_price) VALUES(?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, command.getUserId());
			pstat.setDouble(2, command.getTotalPrice());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteCommand(command command) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("DELETE FROM command WHERE id = ?");
			pstat.setInt(1, command.getId());
			pstat.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
