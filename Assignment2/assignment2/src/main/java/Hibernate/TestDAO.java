package Hibernate;





import java.text.SimpleDateFormat;
import java.util.Date;

import AnnotedClasses.*;

import HibernateDAO.*;
import HibernateDaoInterfaces.AccountDao;
import HibernateDaoInterfaces.MatchDao;
import HibernateDaoInterfaces.PersonDao;
import HibernateDaoInterfaces.SetDao;
import HibernateDaoInterfaces.TournamentDao;
public class TestDAO {
	public static void main(String[] args)
    {
	  
     /* PersonH person=new PersonH();
      person.setName("George");
      person.setEmail("George@gmail.com");
      person.setPassword("pass");*/
    // PersonDao personDao = new PersonDAOH();
     //System.out.println(personDao.findByName("George").getEmail());
     //personDao.deleteById(15);
     // System.out.println("deleted id 15");
     //personDao.insert(person);
     //System.out.println("Inserted");
     //personDao.deleteById(19);
      //System.out.println("deleted");
     PersonH toinsert =new PersonH();
    PersonDao personDao = new PersonDAOH();
     toinsert.setName("bosu2");
     toinsert.setEmail("bosu2");
     toinsert.setIsadmin(true);
    	
    	AccountH account =new AccountH();
    	account.setBalance(1000);
    	//toinsert.setAccount(account);
    	AccountDao accountDao=new AccountDAOH();
    	accountDao.insert(account);
    	personDao.insert(toinsert);
    	System.out.println("O mers");
      SetH set=new SetH();
      set.setPp1(0);
      set.setPp2(0);
      SetDao setDao=new SetDAOH(); 
      setDao.insert(set);
      System.out.println("Inserted");
      set.setPp1(11);
      setDao.update(set);
      System.out.println("Updated");
      set=new SetH();
      setDao.insert(set);
      System.out.println("Inserted again");
      /*setDao.delete(set);
      System.out.println("Delete de second");
      */
      /*MatchH match=new MatchH();
      match.setPlayer1(personDao.findByName("George"));
      match.setPlayer2(personDao.findByName("sebi"));
      match.setSet1(set);
      MatchDao matchDao =new MatchDAOH();
      matchDao.insert(match);
      //matchDao.deleteById(27);
      //match=matchDao.find(27);
      //matchDao.delete(match);
      TournamentH tournament=new TournamentH();
      tournament.setName("US Open");
      tournament.setMatch1(match);
      tournament.setStartDate(java.sql.Date.valueOf("2018-04-04"));
      tournament.setEndDate(java.sql.Date.valueOf("2018-04-06"));
      tournament.setTax(0);
      account =new AccountH();
  		account.setBalance(0);
  	
  		tournament.setAccount(account);
  		accountDao=new AccountDAOH();
  		accountDao.insert(account);
      TournamentDao tournamentDao=new TournamentDAOH();
      tournamentDao.insert(tournament);
      //tournamentDao.deleteById(2);
      System.out.println("Non Zero");
      tournamentDao.getByTaxNonZero();
      System.out.println("Zero");
      tournamentDao.getByTaxZero();
      
      */
		/*PersonH person=new PersonH();
		PersonDao personDao=new PersonDAOH();
		AccountH account=new AccountH();
		AccountDao accountDao =new AccountDAOH();
		person.setName("boss");
		person.setPassword("boss");
		person.setEmail("boss");
	    person.setIsadmin(false);
	    account.setBalance(Integer.parseInt("1000"));
	    accountDao.insert(account);
	    person.setAccount(account);
	    personDao.insert(person);*/
	    System.out.println("DONE!");
     
      
      
}	
 
}
