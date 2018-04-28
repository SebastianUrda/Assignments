package Business;

import java.util.Observable;

import AnnotedClasses.AccountH;
import HibernateDAO.AccountDAOH;
import HibernateDaoInterfaces.AccountDao;

public class AccountBusiness extends Observable {
	public static void updateBalance(int id,int newBalance)
	{
		AccountH account=new AccountH();
		AccountDao accountDao=new AccountDAOH();
		account=accountDao.find(id);
		account.setBalance(newBalance);
		accountDao.update(account);
		
	}
	public static void update(AccountH acc)
	{
		AccountDao accountDao=new AccountDAOH();
		accountDao.update(acc);
	}
}
