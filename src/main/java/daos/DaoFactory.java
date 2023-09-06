package daos;

import java.sql.DriverManager;
import java.sql.SQLException;

import daos.daoImplemts.*;
import daos.daoInterfaces.*;

import java.sql.Connection;

public class DaoFactory {
 
	 private Connection connection;
	 
	 public Connection getConnection() {
		 try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SerAbShoeus","root","sqlMDP");
		 } catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 return connection;
	 }
	 
	 public DaoUser getUserDao() {
		 return new DaoUserImpl();
	 }

	 public DaoShoeus getShoeusDao() {
		 return new DaoShoeusImpl();
	 }

	 public DaoMessage getMessageDao() {
		 return new DaoMessageImpl();
	 }

	 public DaoCommand getCommandDao() {
		 return new DaoCommandImpl();
	 }

	 public DaoContains getContainsDao() {
		 return new DaoContainsImpl();
	 }
}
