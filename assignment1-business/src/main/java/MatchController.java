import java.util.ArrayList;
import java.util.List;

import DAO.MatchDB;
import DAO.PersonDB;
import DAO.SetDB;
import Models.Match;
import Models.Set;

public class MatchController {
	public static Match createMatch (String player1,String player2)
	{
		Match match=null;
		if(PersonDB.findByName(player1)==null) System.out.println("Player1 not in DataBase");
		else if(PersonDB.findByName(player2)==null) System.out.println("Player 2 not in DataBase");
		else match=new Match(PersonDB.findByName(player1),PersonDB.findByName(player2));
		Set set=new Set(0,0);
		int setId= SetDB.insert(set);
		List<Set> setsToAdd=new ArrayList<Set>();
		set.setId(setId);
		setsToAdd.add(set);
		match.setSets(setsToAdd);
		match.setSetsWonPlayer1(0);
		match.setSetsWonplayer2(0);
		MatchDB.insertForeignKeys(match);
		return match;
	}
	public static void addMatch (Match match)
	{
		MatchDB.insert(match);
	}
	public static Boolean testIfWon(Match match)
	{
		if(match.getSetsWonPlayer1()==3) return true;
		else if(match.getSetsWonPlayer2()==3) return true;
		else return false;
	}
	public static void setTheWinner (Match match)
	{
		if(testIfWon(match))
			if(match.getSetsWonPlayer1()>match.getSetsWonPlayer2()) match.setWinner(match.getPlayer1());
			else match.setWinner(match.getPlayer2());
	}
	public static Boolean testIfSetWon(Set set)
	{
		if(set.getPointsPlayer1()>=11 && (set.getPointsPlayer1()>=(set.getPointsPlayer2()+2)))
			return true;
		else if(set.getPointsPlayer2()>=11 && (set.getPointsPlayer2()>=(set.getPointsPlayer1()+2)))
			return true;
		else return false;
	}
	public static void play(Match match)
	{
			Set set=match.getSets().get(match.getSets().size()-1);
           if( testIfSetWon(set)) 
        	   {if(set.getPointsPlayer1()>set.getPointsPlayer2()) 
        		   {
        		   	match.setSetsWonPlayer1(match.getSetsWonPlayer1()+1);
        		   	MatchDB.update(match);
        		   
        		   }
        	   else {
        		   match.setSetsWonPlayer2(match.getSetsWonPlayer2()+1);
        		   MatchDB.update(match);
        	   }
        	   if(!testIfWon(match)) 
        		   {
        		   	Set newSet=new Set(0,0);
        		   	newSet.setId(SetDB.insert(newSet));
        		   	match.getSets().add(newSet);
        		   	MatchDB.update(match);
        			MatchDB.insertForeignKeys(match);
        		   	
        		   }
        	   else {
        		   setTheWinner(match);
        		   System.out.println(match.getWinner().getName());
        		   
        	   }
        	   }
        
	}
	public static void updateScore(Match match,int p1,int p2)
	{
		if(!testIfWon(match))
		{
			match.getSets().get(match.getSets().size()-1).setPointsPlayer1(p1);
			match.getSets().get(match.getSets().size()-1).setPointsPlayer2(p2);
		}
			
	}
	public static void updateMatchDB(Match match)
	{
		if(!testIfWon(match))
		MatchDB.update(match);
		MatchDB.insertForeignKeys(match);
	}
	
	
}
