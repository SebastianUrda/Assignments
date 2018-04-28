package HibernateDAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import AnnotedClasses.AccountH;

import HibernateDaoInterfaces.AccountDao;
import Hibernate.HibernateUtil;

public class AccountDAOH implements AccountDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public AccountH find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		AccountH AccountH = (AccountH) currentSession.get(AccountH.class, id);
		transaction.commit();
		return AccountH;
	}

	
	public void delete(AccountH objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.delete(objectToDelete);
		transaction.commit();
	}

	
	public void update(AccountH objectToUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.update(objectToUpdate);
		transaction.commit();
	}

	
	public void insert(AccountH objectToCreate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.persist(objectToCreate);
		transaction.commit();
	}


	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		//delete items
		currentSession.createQuery("delete from AccountH where idaccount= :idParameter").setLong("idParameter", id).executeUpdate();
		//delete AccountH
		Query hqlQuery = currentSession.createQuery("delete from AccountH where id= :idParameter");
		hqlQuery.setLong("idParameter", id);
		hqlQuery.executeUpdate();

		transaction.commit();
	}

	
	public void closeConnection() {
		sessionFactory.close();
}
}
