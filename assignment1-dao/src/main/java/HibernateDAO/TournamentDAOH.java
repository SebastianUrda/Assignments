package HibernateDAO;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import AnnotedClasses.TournamentH;
import Hibernate.HibernateUtil;
import HibernateDaoInterfaces.TournamentDao;
public class TournamentDAOH implements TournamentDao{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public TournamentH find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		TournamentH TournamentH = (TournamentH) currentSession.get(TournamentH.class, id);
		transaction.commit();
		return TournamentH;
	}
	
	public void delete(TournamentH objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.delete(objectToDelete);
		transaction.commit();
	}
	public void getAll()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(TournamentH.class);
		List<TournamentH> empList = criteria.list();
		for(TournamentH emp : empList){
			System.out.println("ID="+emp.getId()+", Zipcode="+emp.getName());
		}
		tx.commit();
		sessionFactory.close();
	}
	public void getByTaxZero()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<TournamentH> empList = session.createCriteria(TournamentH.class)
				.add(Restrictions.eq("tax", 0)).list();
		for(TournamentH emp : empList){
			System.out.println("ID="+emp.getId()+", Name="+emp.getName());
		}
		tx.commit();
	}
	public void getByTaxNonZero()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<TournamentH> empList = session.createCriteria(TournamentH.class)
				.add(Restrictions.not(Restrictions.eq("tax", 0))).list();
		for(TournamentH emp : empList){
			System.out.println("ID="+emp.getId()+", Name="+emp.getName());
		}
		tx.commit();
	}

	
	public void update(TournamentH objectToUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.update(objectToUpdate);
		transaction.commit();
	}

	
	public void insert(TournamentH objectToCreate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.persist(objectToCreate);
		transaction.commit();
	}


	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		//delete items
		currentSession.createQuery("delete from TournamentH where idtournament= :idParameter").setLong("idParameter", id).executeUpdate();
		//delete TournamentH
		Query hqlQuery = currentSession.createQuery("delete from assignment1.Tournament where id= :idParameter");
		hqlQuery.setLong("idParameter", id);
		hqlQuery.executeUpdate();

		transaction.commit();
	}

	
	public void closeConnection() {
		sessionFactory.close();
}

}
