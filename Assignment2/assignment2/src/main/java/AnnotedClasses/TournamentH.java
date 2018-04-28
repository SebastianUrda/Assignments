package AnnotedClasses;

import javax.persistence.*;
import AnnotedClasses.MatchH;

import java.sql.Date;

@Entity
@Table(name = "assignment1.tournament")
public class TournamentH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtournament")
	private int id;

	@Column(name="name", length=100, nullable=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="match1")
	private MatchH match1;
	@ManyToOne
	@JoinColumn(name="match2")
	private MatchH match2;
	@ManyToOne
	@JoinColumn(name="match3")
	private MatchH match3;
	@ManyToOne
	@JoinColumn(name="match4")
	private MatchH match4;
	@ManyToOne
	@JoinColumn(name="match5")
	private MatchH match5;
	@ManyToOne
	@JoinColumn(name="match6")
	private MatchH match6;
	@ManyToOne
	@JoinColumn(name="match7")
	private MatchH match7;
	@ManyToOne
	@JoinColumn(name="accountid")
	private AccountH account;
	
	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "enddate")
	private Date endDate;
	@Column(name = "tax")
	private int tax;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MatchH getMatch1() {
		return match1;
	}
	public void setMatch1(MatchH match1) {
		this.match1 = match1;
	}
	public MatchH getMatch2() {
		return match2;
	}
	public void setMatch2(MatchH match2) {
		this.match2 = match2;
	}
	public MatchH getMatch3() {
		return match3;
	}
	public void setMatch3(MatchH match3) {
		this.match3 = match3;
	}
	public MatchH getMatch4() {
		return match4;
	}
	public void setMatch4(MatchH match4) {
		this.match4 = match4;
	}
	public MatchH getMatch5() {
		return match5;
	}
	public void setMatch5(MatchH match5) {
		this.match5 = match5;
	}
	public MatchH getMatch6() {
		return match6;
	}
	public void setMatch6(MatchH match6) {
		this.match6 = match6;
	}
	public MatchH getMatch7() {
		return match7;
	}
	public void setMatch7(MatchH match7) {
		this.match7 = match7;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public AccountH getAccount() {
		return account;
	}
	public void setAccount(AccountH account) {
		this.account = account;
	}

}