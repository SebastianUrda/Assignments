package Models;

import java.util.ArrayList;
import java.util.List;

public class Match {
		private int id;
		private Person player1=null;
		private Person player2=null;
		private Person winner=null;
		private int setsWonPlayer1;
		private int setsWonPlayer2;
		private Boolean end=false;
		private List<Set> sets=new ArrayList<Set>();
	
		
		public Match(Person player1, Person player2) {
			this.player1 = player1;
			this.player2 = player2;
			//System.out.println("I was created "+player1.getName()+" "+player2.getName());
		}
		

		/*public Match() {
			this.player1=null;
			this.player2=null;
		}*/
		

		public Boolean getEnd() {
			return end;
		}


		public void setEnd(Boolean end) {
			this.end = end;
		}


		public Person getPlayer1() {
			return player1;
		}

		public void setPlayer1(Person player1) {
			this.player1 = player1;
		}

		public Person getPlayer2() {
			return player2;
		}

		public void setPlayer2(Person player2) {
			this.player2 = player2;
		}

		public Person getWinner() {
			return winner;
		}
		public void setWinner(Person winner) {
			this.winner = winner;
		}

		public int getSetsWonPlayer1() {
			return setsWonPlayer1;
		}

		public void setSetsWonPlayer1(int setsWonPlayer1) {
			this.setsWonPlayer1 = setsWonPlayer1;
		}

		public int getSetsWonplayer2() {
			return setsWonPlayer2;
		}

		public void setSetsWonplayer2(int setswonplayer2) {
			this.setsWonPlayer2 = setswonplayer2;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		

		public int getSetsWonPlayer2() {
			return setsWonPlayer2;
		}

		public void setSetsWonPlayer2(int setsWonPlayer2) {
			this.setsWonPlayer2 = setsWonPlayer2;
		}

		public List<Set> getSets() {
			return sets;
		}

		public void setSets(List<Set> sets) {
			this.sets = sets;
		}
		
		
		
		
}
