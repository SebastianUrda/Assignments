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
import Models.Tournament;
public class MatchDB {
	private static final String insertStatementString = "INSERT INTO assignment1.match (id_player1,id_player2,id_set1,sets_player1,sets_player2)"
			+ " VALUES (?,?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM assignment1.match where idmatch = ?";
	private final static String updateStatementString = "UPDATE assignment1.match SET id_player1=?, id_player2=?, sets_player1=?, sets_player2=? WHERE idmatch = ?";
	private final static String deleteStatementString = "DELETE FROM assignment1.match where idmatch = ?";
	protected static final Logger LOGGER = Logger.getLogger(MatchDB.class.getName());
	public static int insert(Match match) {
		
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, match.getPlayer1().getId());
			//System.out.println("DONE");
			insertStatement.setInt(2, match.getPlayer2().getId());
			//System.out.println("DONE");
			insertStatement.setInt(3, match.getSets().get(0).getId());
			//System.out.println("DONE");
			insertStatement.setInt(4, match.getSetsWonPlayer1());
			//System.out.println("DONE");
			insertStatement.setInt(5, match.getSetsWonplayer2());
			//System.out.println("DONE");
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "MatchDB:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	public static Match findById(int customerId) {
		Match toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, customerId);
			rs = findStatement.executeQuery();
			rs.next();
			
			int idPlayer1 = rs.getInt("id_player1");
			int idPlayer2 = rs.getInt("id_player2");
			int idSet1=rs.getInt("id_set1");
			int idSet2=rs.getInt("id_set2");
			int idSet3=rs.getInt("id_set3");
			int idSet4=rs.getInt("id_set4");
			int idSet5=rs.getInt("id_set5");
			//System.out.println("testez findById Match"+idPlayer1+" "+idPlayer2);
			int setsPlayer1=rs.getInt("sets_player1");
			int setsPlayer2=rs.getInt("sets_player2");
			toReturn = new Match(PersonDB.findById(idPlayer1),PersonDB.findById(idPlayer2));
			if(idSet1!=0)
			toReturn.getSets().add(SetDB.findById(idSet1));
			if(idSet2!=0)
				toReturn.getSets().add(SetDB.findById(idSet2));
			if(idSet3!=0)
				toReturn.getSets().add(SetDB.findById(idSet3));
			if(idSet4!=0)
				toReturn.getSets().add(SetDB.findById(idSet4));
			if(idSet5!=0)
				toReturn.getSets().add(SetDB.findById(idSet5));
			toReturn.setSetsWonPlayer1(setsPlayer1);
			toReturn.setSetsWonplayer2(setsPlayer2);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"MatchDB:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		toReturn.setId(customerId);
		return toReturn;
	}
	public static void insertForeignKeys(Match match)
	{
		int i=1;
		 for(Set set : match.getSets()) {
			String updateStatementString = "UPDATE assignment1.match SET id_set"+i+"=? WHERE idmatch = ?";
			  //UPDATE `assignment1`.`tournament` SET `match1`='6' WHERE `idtournament`='4';
			  Connection dbConnection = ConnectionFactory.getConnection();

				PreparedStatement insertStatement = null;
				int insertedId = -1;
				try {
					insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
					insertStatement.setInt(1, set.getId());
					insertStatement.setInt(2, match.getId());
					insertStatement.executeUpdate();

					ResultSet rs = insertStatement.getGeneratedKeys();
					if (rs.next()) {
						insertedId = rs.getInt(1);
					}
				} catch (SQLException e) {
					LOGGER.log(Level.WARNING, "SetDB FK:insert " + e.getMessage());
				} finally {
					ConnectionFactory.close(insertStatement);
					ConnectionFactory.close(dbConnection);
				}
				i++;
			}
	   }
	public static int update(Match match) {
		Connection dbConnection = ConnectionFactory.getConnection();
		
		PreparedStatement updateStatement = null;
		int updated=-1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setInt(1, match.getPlayer1().getId());
			updateStatement.setInt(2, match.getPlayer2().getId());
			updateStatement.setInt(3, match.getSetsWonPlayer1());
			updateStatement.setInt(4, match.getSetsWonPlayer2());
			updateStatement.setInt(5, match.getId());
			for(Set set:match.getSets())
			{
				System.out.println(set.getId());
				SetDB.update(set);
			}
			updateStatement.executeUpdate();
			
			updated=match.getId();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "MatchDAO:update " + e.getMessage());
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
			
			LOGGER.log(Level.WARNING, "CustomerDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
}
