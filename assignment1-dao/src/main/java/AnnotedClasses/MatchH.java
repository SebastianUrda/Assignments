package AnnotedClasses;

import javax.persistence.*;


@Entity
@Table(name = "assignment1.match")
public class MatchH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmatch")
	private int id;
	@ManyToOne
	@JoinColumn(name="id_player1")
	private PersonH player1;
	@ManyToOne
	@JoinColumn(name="id_player2")
	private PersonH player2;
	@ManyToOne
	@JoinColumn(name="id_set1")
	private SetH set1;
	@ManyToOne
	@JoinColumn(name="id_set2")
	private SetH set2;
	@ManyToOne
	@JoinColumn(name="id_set3")
	private SetH set3;
	@ManyToOne
	@JoinColumn(name="id_set4")
	private SetH set4;
	@ManyToOne
	@JoinColumn(name="id_set5")
	private SetH set5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PersonH getPlayer1() {
		return player1;
	}
	public void setPlayer1(PersonH player1) {
		this.player1 = player1;
	}
	public PersonH getPlayer2() {
		return player2;
	}
	public void setPlayer2(PersonH player2) {
		this.player2 = player2;
	}
	public SetH getSet1() {
		return set1;
	}
	public void setSet1(SetH set1) {
		this.set1 = set1;
	}
	public SetH getSet2() {
		return set2;
	}
	public void setSet2(SetH set2) {
		this.set2 = set2;
	}
	public SetH getSet3() {
		return set3;
	}
	public void setSet3(SetH set3) {
		this.set3 = set3;
	}
	public SetH getSet4() {
		return set4;
	}
	public void setSet4(SetH set4) {
		this.set4 = set4;
	}
	public SetH getSet5() {
		return set5;
	}
	public void setSet5(SetH set5) {
		this.set5 = set5;
	}
}
