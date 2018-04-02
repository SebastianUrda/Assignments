package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

public class Login {
	protected static final Logger LOGGER = Logger.getLogger(Login.class.getName());
	private final static String findStatementString = "SELECT * FROM person where name = ? and password=?";
	private String name;
	private String password;
	public Login(String name,String password){
		this.name=name;
		this.password=password;
	}
	public int test ()
	{
	Connection dbConnection=ConnectionFactory.getConnection();
	PreparedStatement findStatement = null;
	ResultSet rs = null;
	Integer isadmin=-1;
	try {
		findStatement = dbConnection.prepareStatement(findStatementString);
		findStatement.setString(1,name );
		findStatement.setString(2,password );
		rs = findStatement.executeQuery();
		//System.out.println("Am trecut de punctul asta");
		if(rs.next()) 
			{System.out.println("email and password matched");
				isadmin=rs.getInt("isadmin");
				//System.out.println(isadmin.toString());
			}
		else System.out.println("did not match");
		
	} catch (SQLException e) {
		LOGGER.log(Level.WARNING,"Not Valid" + e.getMessage());
	} finally {
		ConnectionFactory.close(rs);
		ConnectionFactory.close(findStatement);
		ConnectionFactory.close(dbConnection);
	}
	return isadmin;
	}
	}

