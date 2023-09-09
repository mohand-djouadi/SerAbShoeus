package daos.daoImplemts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.DaoFactory;
import daos.daoInterfaces.DaoShoeus;
import javabeans.shoeus;

public class DaoShoeusImpl implements DaoShoeus {

	Connection conn = new DaoFactory().getConnection();
	shoeus sh = new shoeus();
	
	@Override
	public List<shoeus> getAllShoeus() {
		
		ArrayList<shoeus> allShoeus = new ArrayList<shoeus>();
		
		try {
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM shoeus");
			while (result.next()) {
				sh.setId(result.getInt("id"));
				sh.setBrand(result.getString("brand"));
				sh.setCategory(result.getString("category"));
				sh.setColor(result.getString("color"));
				sh.setModel(result.getString("model"));
				sh.setPrice(result.getDouble("price"));
				allShoeus.add(sh);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return allShoeus;
	}

	@Override
	public shoeus getShoeusById(int id) {
		
		try {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM shoeus WHERE id = ?");
			pstat.setInt(1, id);
			ResultSet result = pstat.executeQuery();
			sh.setId(result.getInt("id"));
			sh.setBrand(result.getString("brand"));
			sh.setCategory(result.getString("category"));
			sh.setColor(result.getString("color"));
			sh.setModel(result.getString("model"));
			sh.setPrice(result.getDouble("price"));
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return sh;
	}

}
