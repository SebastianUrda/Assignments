package HibernateDAO;
import org.hibernate.*;

import AnnotedClasses.SetH;
import Hibernate.HibernateUtil;
import HibernateDaoInterfaces.SetDao;
public class SetDAOH implements SetDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public SetH find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		SetH SetH = (SetH) currentSession.get(SetH.class, id);
		transaction.commit();
		return SetH;
	}

	
	public void delete(SetH objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.delete(objectToDelete);
		transaction.commit();
	}

	
	public void update(SetH objectToUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.update(objectToUpdate);
		transaction.commit();
	}

	
	public void insert(SetH objectToCreate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.persist(objectToCreate);
		transaction.commit();
	}


	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		//delete items
		currentSession.createQuery("delete from SetH where idSet= :idParameter").setLong("idParameter", id).executeUpdate();
		//delete SetH
		Query hqlQuery = currentSession.createQuery("delete from SetH where id= :idParameter");
		hqlQuery.setLong("idParameter", id);
		hqlQuery.executeUpdate();

		transaction.commit();
	}

	
	public void closeConnection() {
		sessionFactory.close();
}


	
}
