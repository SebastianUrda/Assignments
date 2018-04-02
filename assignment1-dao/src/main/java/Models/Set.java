package Models;


public class Set {
	private int pointsPlayer1;
	private int pointsPlayer2;
	private int id;
	public Set ( int pp1,int pp2)
	{
		this.pointsPlayer1=pp1;
		this.pointsPlayer2=pp2;
	}
	public void updateScore( int pp1, int pp2)
	{
		this.pointsPlayer1=pp1;
		this.pointsPlayer2=pp2;
	}
	public int getPointsPlayer1() {
		return pointsPlayer1;
	}
	public int getPointsPlayer2() {
		return pointsPlayer2;
	}
	public void setPointsPlayer1(int pointsplayer1) {
		this.pointsPlayer1 = pointsplayer1;
	}
	public void setPointsPlayer2(int pointsplayer2) {
		this.pointsPlayer2 = pointsplayer2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
