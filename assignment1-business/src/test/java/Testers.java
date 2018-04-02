import static org.junit.Assert.*;

import org.junit.Test;

import Models.Match;
import Models.Person;
import Models.Set;

public class Testers {

	@Test
	public void testSet() {
		Set set=new Set(11,8);
		Boolean test=MatchController.testIfSetWon(set);
		assertEquals(true,test);
	}
	@Test
	public void testMatch() {
		Person p1=new Person();
		Person p2=new Person();
		Match match =new Match(p1,p2);
		match.setSetsWonPlayer1(3);
		match.setSetsWonPlayer2(2);
		MatchController.setTheWinner(match);
		Person winner=match.getWinner();
		assertEquals(p1,winner);
	}
}
