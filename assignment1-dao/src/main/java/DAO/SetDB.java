package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Models.Match;
import Models.Set;

public class SetDB {
	protected static final Logger LOGGER = Logger.getLogger(PersonDB.class.getName());
	private static final String insertStatementString = "INSERT INTO assignment1.set (points_player1,points_player2)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM assignment1.set where idset = ?";
	private final static String updateStatementString = "UPDATE assignment1.set SET points_player1=?, points_player2=? WHERE idset = ?";
	private final static String deleteStatementString = "DELETE FROM assignment1.set where idset = ?";
	public static int insert(Set set) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, set.getPointsPlayer1());
			insertStatement.setInt(2, set.getPointsPlayer2());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "SetDB:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	public static Set findById(int Id) {
		Set toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1,Id);
			rs = findStatement.executeQuery();
			rs.next();

			int pp1 = rs.getInt("points_player1");
			int pp2 = rs.getInt("points_player2");
		
			toReturn = new Set(pp1,pp2);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"SetDB:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		toReturn.setId(Id);
		return toReturn;
	}
	public static int update(Set set) {
		Connection dbConnection = ConnectionFactory.getConnection();
		
		PreparedStatement updateStatement = null;
		int updated=-1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setInt(1, set.getPointsPlayer1());
			updateStatement.setInt(2, set.getPointsPlayer2());
			updateStatement.setInt(3, set.getId());
			updateStatement.executeUpdate();
			
			updated=set.getId();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "SetDAO:update " + e.getMessage());
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
			
			LOGGER.log(Level.WARNING, "SetDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
}
