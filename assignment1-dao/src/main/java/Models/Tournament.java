package Models;

import java.util.ArrayList;
import java.util.List;
import DAO.MatchDB;;
public class Tournament {
	private int id;
	private String name;
	private List<Match> matches = new ArrayList<Match>();

	public Tournament(String name){this.name=name;System.out.println("I was created "+this.name.toString());}
	public Tournament(){}
	
	public Tournament(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addMatch(Match match)
	{
		matches.add(match);
	}
	public void printMatches()
	{
		   System.out.println(this.name);
        for(Match match : matches) {
            System.out.println(match.getId()+" "+match.getPlayer1().getName()+" "+match.getPlayer2().getName());
        }
	}

	public List<Match> getMatches() {
		return matches;
	}
	
	
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
