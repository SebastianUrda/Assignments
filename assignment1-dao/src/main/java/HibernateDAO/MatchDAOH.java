package HibernateDAO;

import org.hibernate.*;

import AnnotedClasses.MatchH;
import Hibernate.HibernateUtil;
import HibernateDaoInterfaces.MatchDao;
public class MatchDAOH implements MatchDao{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public MatchH find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		MatchH MatchH = (MatchH) currentSession.get(MatchH.class, id);
		transaction.commit();
		return MatchH;
	}

	
	public void delete(MatchH objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.delete(objectToDelete);
		transaction.commit();
	}

	
	public void update(MatchH objectToUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.update(objectToUpdate);
		transaction.commit();
	}

	
	public void insert(MatchH objectToCreate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.persist(objectToCreate);
		transaction.commit();
	}


	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		//delete items
		currentSession.createQuery("delete from MatchH where idmatch= :idParameter").setLong("idParameter", id).executeUpdate();
		//delete MatchH
		Query hqlQuery = currentSession.createQuery("delete from assignment1.Match where id= :idParameter");
		hqlQuery.setLong("idParameter", id);
		hqlQuery.executeUpdate();

		transaction.commit();
	}

	
	public void closeConnection() {
		sessionFactory.close();
}
}

