package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.collections.*;
import javafx.scene.control.ChoiceBox;
import AnnotedClasses.AccountH;
import AnnotedClasses.MatchH;
import AnnotedClasses.TournamentH;
import HibernateDAO.*;
import HibernateDaoInterfaces.AccountDao;
import HibernateDaoInterfaces.MatchDao;
import HibernateDaoInterfaces.TournamentDao;

public class TournamentBusiness extends Observable {
	public ObservableList<TournamentH> getAllTorunaments()
	{
		TournamentDao tournamentDao= new TournamentDAOH();
		List<TournamentH> toPrint= tournamentDao.getAll();
		ObservableList<TournamentH> at = FXCollections.observableArrayList(toPrint);
		return at;
	}
	public ObservableList<TournamentH> getPaidTorunaments()
	{
		TournamentDao tournamentDao= new TournamentDAOH();
		List<TournamentH> toPrint= tournamentDao.getByTaxNonZero();
		ObservableList<TournamentH> at = FXCollections.observableArrayList(toPrint);
		return at;
	}
	public ObservableList<TournamentH> getFreeTorunaments()
	{
		TournamentDao tournamentDao= new TournamentDAOH();
		List<TournamentH> toPrint= tournamentDao.getByTaxZero();
		ObservableList<TournamentH> at = FXCollections.observableArrayList(toPrint);
		return at;
	}
	public static void deleteTournament(String choice)
	{
		TournamentDao tournamentDao= new TournamentDAOH();
		TournamentH tournament=new TournamentH ();
		tournament=tournamentDao.findByName(choice);
		tournamentDao.delete(tournament);
		
	}
	public static void createTorunament(String name,String startDate,String endDate,String tax)
	{
		TournamentH tournament=new TournamentH();
		MatchDao matchDao=new MatchDAOH();
		MatchH match1=new MatchH();
		MatchH match2=new MatchH();
		MatchH match3=new MatchH();
		MatchH match4=new MatchH();
		MatchH match5=new MatchH();
		MatchH match6=new MatchH();
		MatchH match7=new MatchH();
		matchDao.insert(match1);
		matchDao.insert(match2);
		matchDao.insert(match3);
		matchDao.insert(match4);
		matchDao.insert(match5);
		matchDao.insert(match6);
		matchDao.insert(match7);
		AccountH account =new AccountH();
		TournamentDao tournamentDao= new TournamentDAOH();
		AccountDao accountDao= new AccountDAOH();
	    tournament.setName(name);
	    tournament.setStartDate(java.sql.Date.valueOf(startDate));
	    tournament.setEndDate(java.sql.Date.valueOf(endDate));
	    tournament.setTax(Integer.parseInt(tax));
	    tournament.setMatch1(match1);
	    tournament.setMatch2(match2);
	    tournament.setMatch3(match3);
	    tournament.setMatch3(match3);
	    tournament.setMatch4(match4);
	    tournament.setMatch5(match5);
	    tournament.setMatch6(match6);
	    tournament.setMatch7(match7);
	    account =new AccountH();
	  	account.setBalance(0);
	  	accountDao.insert(account);
	  	tournament.setAccount(account);
	  	tournamentDao.insert(tournament);
	}
	public static TournamentH findByName (String name)
	{
		TournamentDao tournamentDao= new TournamentDAOH();
		return tournamentDao.findByName(name);
	}
}
