package DAO;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;

public class PersonDB {
	protected static final Logger LOGGER = Logger.getLogger(PersonDB.class.getName());
	private static final String insertStatementString = "INSERT INTO assignment1.person (name,email,password,isadmin)"
			+ " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM person where name = ?";
	private final static String findStatementStringid = "SELECT * FROM person where idperson = ?";
	private final static String updateStatementString = "UPDATE assignment1.person SET name=?, email=?,password=?, isadmin=? WHERE idperson = ?";
	private final static String deleteStatementString = "DELETE FROM assignment1.person where idperson = ?";
	public static Person findByName(String name) {
		Person toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setString(1, name);
			rs = findStatement.executeQuery();
			rs.next();

			int id = rs.getInt("idperson");
			String password = rs.getString("password");
			String email = rs.getString("email");
			Boolean isAdmin = rs.getBoolean("isadmin");
			toReturn = new Person(id, name, password,email, isAdmin);
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"Person  migh  not be in the DB " + e.getMessage()+name);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	public static Person findById(int id) {
		Person toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementStringid);
			findStatement.setInt(1, id);
			rs = findStatement.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String email = rs.getString("email");
			Boolean isAdmin = rs.getBoolean("isadmin");
			toReturn = new Person(id, name, email, isAdmin);
			//System.out.println("testez find by id Person"+toReturn.getName());
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"Person  migh  not be in the DB " + e.getMessage()+id);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	public static int insert(Person persoana) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, persoana.getName());
			insertStatement.setString(2, persoana.getEmail());
			insertStatement.setString(3, persoana.getPassword());
			if(persoana.getIsAdmin()==true)
			insertStatement.setInt(4,1);
			else
			insertStatement.setInt(4,0);
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "PersonDB:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	public static int update(Person person) {
		Connection dbConnection = ConnectionFactory.getConnection();
		
		PreparedStatement updateStatement = null;
		int updated=-1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, person.getName());
			updateStatement.setString(2, person.getEmail());
			updateStatement.setString(3, person.getPassword());
			if(person.getIsAdmin()==true)
				updateStatement.setInt(4,1);
				else
				updateStatement.setInt(4,0);
			updateStatement.setInt(5, person.getId());
			updateStatement.executeUpdate();
			updated=person.getId();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "PersonDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return updated;
		
	}
	public static void delete  (int id)
	{
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			
			LOGGER.log(Level.WARNING, "PersonDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
}
