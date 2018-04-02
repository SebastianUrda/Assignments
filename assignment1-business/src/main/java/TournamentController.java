import java.util.ArrayList;
import java.util.List;

import DAO.MatchDB;
import DAO.SetDB;
import DAO.TournamentDB;
import Models.Match;
import Models.Tournament;
import Models.Set;

public class TournamentController {
	private static Tournament tour=new Tournament();
	public static void setTournamnetName(String name)
	{
		tour.setName(name);
	}
	public static void insertNameIntoDB()
	{
		tour.setId(TournamentDB.insertName(tour));
	}
	
	public static void testInsertion ()
	{
		//System.out.println(tour.getMatches().get(6));
		tour.printMatches();
		
	}
	public static void insertMatchesDB()
	{
		 for(Match match : tour.getMatches()) {
			 match.setId(MatchDB.insert(match));
		            //System.out.println(match.getPlayer1().getName()+" "+match.getPlayer2().getName());
		       }
	}
	public static void addMatchToTournamnet(Match match)
	{
		tour.addMatch(match);
	}
	public static void InsertMatchesFK()
	{
		TournamentDB.insertForeignKeys(tour);
	}
	public static List<String> testFindAll()
	{	
		System.out.println("Test find all");
	 	List<String> names =new ArrayList<String>();
		for(Tournament turneu : TournamentDB.findAll()) {
			System.out.println(turneu.getName());
			names.add(turneu.getName());
			for(Match match:turneu.getMatches())
            System.out.println(match.getPlayer1().getName()+" "+match.getPlayer2().getName());
        }
		return names;
	}
	public static List<String> listOfNames()
	{	
		//System.out.println("Test find all");
	 	List<String> names =new ArrayList<String>();
		for(Tournament turneu : TournamentDB.findAll()) {
			names.add(turneu.getName());
        }
		return names;
	}
	public static void findInListByName (String name)
	{
		for(Tournament turneu : TournamentDB.findAll())
		{
			if(turneu.getName().equals(name)) 
				{
					for(Match match:turneu.getMatches())
					{
						System.out.println(match.getId());
					}
					tour.setName(turneu.getName());
					tour.setMatches(turneu.getMatches());
					tour.setId(turneu.getId());
				}
		}
		System.out.println("Numele valorii globale "+tour.getName());
	}
	public static void deleteTournament()
	{
		TournamentDB.delete(tour.getId());
		for(Match match:tour.getMatches())
		{
			MatchDB.delete(match.getId());
			for(Set set:match.getSets())
			{
				SetDB.delete(set.getId());
			}	
		}
	}
	public static Tournament returnTour()
	{
		return tour;
	}
	public static String toPrintInTB1()
	{
		return tour.getMatches().get(0).getPlayer1().getName()+" "+tour.getMatches().get(0).getSetsWonPlayer1()+" "+tour.getMatches().get(0).getSets().get(tour.getMatches().get(0).getSets().size()-1).getPointsPlayer1();
	}
	public static String toPrintInTB2()
	{
		return tour.getMatches().get(0).getPlayer2().getName()+" "+tour.getMatches().get(0).getSetsWonPlayer2()+" "+tour.getMatches().get(0).getSets().get(tour.getMatches().get(0).getSets().size()-1).getPointsPlayer2();
		
	}
	public static String toPrintInTB3()
	{
		return tour.getMatches().get(1).getPlayer1().getName()+" "+tour.getMatches().get(1).getSetsWonPlayer1()+" "+tour.getMatches().get(1).getSets().get(tour.getMatches().get(1).getSets().size()-1).getPointsPlayer1();
	}
	public static String toPrintInTB4()
	{
		return tour.getMatches().get(1).getPlayer2().getName()+" "+tour.getMatches().get(1).getSetsWonPlayer2()+" "+tour.getMatches().get(1).getSets().get(tour.getMatches().get(1).getSets().size()-1).getPointsPlayer2();
		
	}
	public static String toPrintInTB5()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(0)))
		return tour.getMatches().get(4).getPlayer1().getName()+" "+tour.getMatches().get(4).getSetsWonPlayer1()+" "+tour.getMatches().get(4).getSets().get(tour.getMatches().get(4).getSets().size()-1).getPointsPlayer1();
		//else return " ";
	}
	public static String toPrintInTB6()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(1)))
		return tour.getMatches().get(4).getPlayer2().getName()+" "+tour.getMatches().get(4).getSetsWonPlayer2()+" "+tour.getMatches().get(4).getSets().get(tour.getMatches().get(4).getSets().size()-1).getPointsPlayer2();
		//else return " ";
	}
	public static String toPrintInTB7()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(1)))
		return tour.getMatches().get(6).getPlayer1().getName()+" "+tour.getMatches().get(6).getSetsWonPlayer1()+" "+tour.getMatches().get(6).getSets().get(tour.getMatches().get(6).getSets().size()-1).getPointsPlayer1();
		//else return " ";
	}
	public static String toPrintInTB8()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(1)))
		return tour.getMatches().get(6).getPlayer2().getName()+" "+tour.getMatches().get(6).getSetsWonPlayer2()+" "+tour.getMatches().get(6).getSets().get(tour.getMatches().get(6).getSets().size()-1).getPointsPlayer2();
		//else return " ";
	}
	public static String toPrintInTB9()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(2)))
		return tour.getMatches().get(5).getPlayer1().getName()+" "+tour.getMatches().get(5).getSetsWonPlayer1()+" "+tour.getMatches().get(5).getSets().get(tour.getMatches().get(5).getSets().size()-1).getPointsPlayer1();
		//else return " ";
	}
	public static String toPrintInTB10()
	{
		//if(MatchController.testIfWon(tour.getMatches().get(3)))
		return tour.getMatches().get(5).getPlayer2().getName()+" "+tour.getMatches().get(5).getSetsWonPlayer2()+" "+tour.getMatches().get(5).getSets().get(tour.getMatches().get(5).getSets().size()-1).getPointsPlayer2();
		//else return " ";
	}
	public static String toPrintInTB11()
	{
		return tour.getMatches().get(2).getPlayer1().getName()+" "+tour.getMatches().get(2).getSetsWonPlayer1()+" "+tour.getMatches().get(2).getSets().get(tour.getMatches().get(2).getSets().size()-1).getPointsPlayer1();
	}
	public static String toPrintInTB12()
	{
		return tour.getMatches().get(2).getPlayer2().getName()+" "+tour.getMatches().get(2).getSetsWonPlayer2()+" "+tour.getMatches().get(2).getSets().get(tour.getMatches().get(2).getSets().size()-1).getPointsPlayer2();
		
	}
	public static String toPrintInTB13()
	{
		return tour.getMatches().get(3).getPlayer1().getName()+" "+tour.getMatches().get(3).getSetsWonPlayer1()+" "+tour.getMatches().get(3).getSets().get(tour.getMatches().get(3).getSets().size()-1).getPointsPlayer1();
	}
	public static String toPrintInTB14()
	{
		return tour.getMatches().get(3).getPlayer2().getName()+" "+tour.getMatches().get(3).getSetsWonPlayer2()+" "+tour.getMatches().get(3).getSets().get(tour.getMatches().get(3).getSets().size()-1).getPointsPlayer2();
		
	}
	public static String toPrintInTBWinner()
	{
		if(MatchController.testIfWon(tour.getMatches().get(6)))
		return tour.getMatches().get(6).getWinner().getName();
		else return " ";
		
	}
	
	public static void updateScore (String player1,String player2,int pp1,int pp2)
	{
		for(Match match:tour.getMatches())
		{
			if(!(match==null))
			{if(match.getPlayer1().getName().equals(player1) && match.getPlayer2().getName().equals(player2)&& !MatchController.testIfWon(match))
			{
				match.getSets().get(match.getSets().size()-1).updateScore(pp1, pp2);
				System.out.println("From TC "+match.getPlayer1().getName()+" "+match.getSets().get(match.getSets().size()-1).getPointsPlayer1()+" "+match.getPlayer2().getName());
				
			}}
			else System.out.println("Meciul este nul");
		}
		
	}
	public static void playMatch (String player1,String player2)
	{
		for(Match match:tour.getMatches())
		{
			if(match.getPlayer1().getName().equals(player1) && match.getPlayer2().getName().equals(player2)&&!MatchController.testIfWon(match))
			{
				MatchController.play(match);
				MatchController.updateMatchDB(match);
				
			}
		}
	}
	public static void matchesTester ()
	{
		if(MatchController.testIfWon(tour.getMatches().get(0)))
			{
				MatchController.setTheWinner(tour.getMatches().get(0));
				tour.getMatches().get(4).setPlayer1(tour.getMatches().get(0).getWinner());
				MatchController.updateMatchDB(tour.getMatches().get(4));
			}
		if(MatchController.testIfWon(tour.getMatches().get(1)))
			{
			MatchController.setTheWinner(tour.getMatches().get(1));
				tour.getMatches().get(4).setPlayer2(tour.getMatches().get(1).getWinner());
				MatchController.updateMatchDB(tour.getMatches().get(4));
			}
		
		if(MatchController.testIfWon(tour.getMatches().get(2)))
			{
				MatchController.setTheWinner(tour.getMatches().get(2));
				tour.getMatches().get(5).setPlayer1(tour.getMatches().get(2).getWinner());
				MatchController.updateMatchDB(tour.getMatches().get(5));
			}
		if(MatchController.testIfWon(tour.getMatches().get(3)))
			{
				MatchController.setTheWinner(tour.getMatches().get(3));
				tour.getMatches().get(5).setPlayer2(tour.getMatches().get(3).getWinner());	
				MatchController.updateMatchDB(tour.getMatches().get(5));
			}
		if(MatchController.testIfWon(tour.getMatches().get(4)))
		{
			MatchController.setTheWinner(tour.getMatches().get(4));
			tour.getMatches().get(6).setPlayer1(tour.getMatches().get(4).getWinner());
			MatchController.updateMatchDB(tour.getMatches().get(6));
		}
		if(MatchController.testIfWon(tour.getMatches().get(5)))
		{
			MatchController.setTheWinner(tour.getMatches().get(5));
			tour.getMatches().get(6).setPlayer2(tour.getMatches().get(5).getWinner());	
			MatchController.updateMatchDB(tour.getMatches().get(6));
		}
		if(MatchController.testIfWon(tour.getMatches().get(6)))
		{
			MatchController.setTheWinner(tour.getMatches().get(6));
		}
		
	}
	public static void printMatchesId()
	{
		for(Match match:tour.getMatches())
		{
			System.out.println(match.getId()+match.getPlayer1().getName()+match.getPlayer2().getName());
		}
	}
	public static int getInitialScorePlayer1 (String player1,String player2)
	{
		int score=0;
		for(Match match:tour.getMatches())
		{	
			if(!(match.getPlayer1()==null)&&!(match.getPlayer2()==null))
			{
			if(match.getPlayer1().getName().equals(player1) && match.getPlayer2().getName().equals(player2))
			{
				score=match.getSets().get(match.getSets().size()-1).getPointsPlayer1();
			}
			
			//System.out.println("MEciuri"+match.getPlayer1().getName());
			//System.out.println(match.getPlayer2().getName());
			}
		}
		return score;
	}
	public static int getInitialScorePlayer2 (String player1,String player2)
	{
		
		int score=0;
		for(Match match:tour.getMatches())
		{
			if(!(match.getPlayer1()==null)&&!(match.getPlayer2()==null))
			{
			if(match.getPlayer1().getName().equals(player1) && match.getPlayer2().getName().equals(player2))
			{
				score=match.getSets().get(match.getSets().size()-1).getPointsPlayer2();
			}
			}
		}
		return score;
			
	}
	
	
	
	
}
