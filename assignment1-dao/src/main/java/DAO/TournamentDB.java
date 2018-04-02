package DAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Models.Match;
import Models.Tournament;
public class TournamentDB {

	private static final String insertStatementString = "INSERT INTO assignment1.tournament (name)"
			+ " VALUES (?)";
	private final static String findStatementString = "SELECT * FROM tournament";
	private final static String deleteStatementString = "DELETE FROM tournament where idtournament = ?";
	protected static final Logger LOGGER = Logger.getLogger(TournamentDB.class.getName());
	public static int insertName(Tournament tour) {
		
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, tour.getName());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TournamentDB:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	
	public static void insertForeignKeys(Tournament tour)
	{
		int i=1;
		 for(Match match : tour.getMatches()) {
			String updateStatementString = "UPDATE assignment1.tournament SET match"+i+"=? WHERE idtournament = ?";
			  //UPDATE `assignment1`.`tournament` SET `match1`='6' WHERE `idtournament`='4';
			  Connection dbConnection = ConnectionFactory.getConnection();

				PreparedStatement insertStatement = null;
				int insertedId = -1;
				try {
					insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
					insertStatement.setInt(1, match.getId());
					insertStatement.setInt(2, tour.getId());
					insertStatement.executeUpdate();

					ResultSet rs = insertStatement.getGeneratedKeys();
					if (rs.next()) {
						insertedId = rs.getInt(1);
					}
				} catch (SQLException e) {
					LOGGER.log(Level.WARNING, "TournamentDB FK:insert " + e.getMessage());
				} finally {
					ConnectionFactory.close(insertStatement);
					ConnectionFactory.close(dbConnection);
				}
				i++;
			}
	   }
	public static List<Tournament> findAll() {
		Tournament toReturn = null;
		List<Tournament> toReturnList=new ArrayList<Tournament>();

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			rs = findStatement.executeQuery();
			while(rs.next())
			{int id=rs.getInt("idtournament");
			String name = rs.getString("name");
			int match1 = rs.getInt("match1");
			System.out.println("gasesc bine id-ul primului meci "+match1);
			int match2 = rs.getInt("match2");
			int match3 = rs.getInt("match3");
			int match4 = rs.getInt("match4");
			int match5 = rs.getInt("match5");
			int match6 = rs.getInt("match6");
			int match7 = rs.getInt("match7");
			toReturn = new Tournament(id, name);
			toReturn.addMatch(MatchDB.findById(match1));
			toReturn.addMatch(MatchDB.findById(match2));
			toReturn.addMatch(MatchDB.findById(match3));
			toReturn.addMatch(MatchDB.findById(match4));
			if(match5!=0)
			toReturn.addMatch(MatchDB.findById(match5));
			if(match6!=0)
			toReturn.addMatch(MatchDB.findById(match6));
			if(match7!=0)
			toReturn.addMatch(MatchDB.findById(match7));
			toReturnList.add(toReturn);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CustomerDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturnList;
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
			
			LOGGER.log(Level.WARNING, "TournamentDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
}
