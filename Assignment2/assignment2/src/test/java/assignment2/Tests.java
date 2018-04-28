package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

import AnnotedClasses.AccountH;
import AnnotedClasses.PersonH;
import AnnotedClasses.TournamentH;
import HibernateDAO.AccountDAOH;
import HibernateDAO.PersonDAOH;
import HibernateDAO.TournamentDAOH;
import HibernateDaoInterfaces.AccountDao;
import HibernateDaoInterfaces.PersonDao;
import HibernateDaoInterfaces.TournamentDao;


public class Tests {

	@Test
	public void testInsertPersonAccount() {
		 PersonH toinsert =new PersonH();
		 PersonDao personDao = new PersonDAOH();
		 toinsert.setName("JUNIT");
		 toinsert.setEmail("JUNIT");
		 toinsert.setIsadmin(true);	
		 AccountH account =new AccountH();
		 account.setBalance(1000);
		 toinsert.setAccount(account);
		 AccountDao accountDao=new AccountDAOH();
		accountDao.insert(account);
		 personDao.insert(toinsert);
		 PersonH found =personDao.findByName("JUNIT");
		assertEquals(1000,found.getAccount().getBalance());
		personDao.delete(found);
	}
	@Test
	public void testInsertTournamentAccount() {
		TournamentH tournament=new TournamentH();
		 AccountDao accountDao=new AccountDAOH();
	      tournament.setName("US Open");
	      tournament.setStartDate(java.sql.Date.valueOf("2018-04-04"));
	      tournament.setEndDate(java.sql.Date.valueOf("2018-04-06"));
	      tournament.setTax(0);
	      AccountH account =new AccountH();
	  		account.setBalance(0);
	  		tournament.setAccount(account);
	  		accountDao=new AccountDAOH();
	  		accountDao.insert(account);
	      TournamentDao tournamentDao=new TournamentDAOH();
	      tournamentDao.insert(tournament);
	      TournamentH found=tournamentDao.findByName("US Open");
	      assertEquals(0,found.getAccount().getBalance());
	      tournamentDao.delete(found);
	}

}
