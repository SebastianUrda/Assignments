package Business;
import java.util.Observable;

import AnnotedClasses.MatchH;
import HibernateDAO.MatchDAOH;
import HibernateDaoInterfaces.MatchDao;
public class MatchBusiness extends Observable {
	public static void update(MatchH match)
	{
		MatchDao matchDao= new MatchDAOH();
		matchDao.update(match);
	}
}
