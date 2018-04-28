package HibernateDAO;
import java.util.List;

import org.hibernate.*;

import AnnotedClasses.PersonH;
import AnnotedClasses.TournamentH;
import Hibernate.HibernateUtil;
import HibernateDaoInterfaces.PersonDao;
public class PersonDAOH implements PersonDao{
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public PersonH find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		PersonH PersonH = (PersonH) currentSession.get(PersonH.class, id);
		transaction.commit();
		return PersonH;
	}
	public PersonH findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		Query query = currentSession.createQuery("from PersonH");
		
		query = currentSession.createQuery("from PersonH where name= :name");
		query.setString("name",name);
		PersonH emp = (PersonH) query.uniqueResult();
		transaction.commit();
		return emp;
	}

	
	public void delete(PersonH objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.delete(objectToDelete);
		transaction.commit();
	}

	
	public void update(PersonH objectToUpdate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.update(objectToUpdate);
		transaction.commit();
	}

	
	public void insert(PersonH objectToCreate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		currentSession.persist(objectToCreate);
		transaction.commit();
	}


	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		//delete items
		currentSession.createQuery("delete from PersonH where idperson= :idParameter").setLong("idParameter", id).executeUpdate();
		//delete PersonH
		Query hqlQuery = currentSession.createQuery("delete from PersonH where id= :idParameter");
		hqlQuery.setLong("idParameter", id);
		hqlQuery.executeUpdate();

		transaction.commit();
	}

	
	public void closeConnection() {
		sessionFactory.close();
}
	@Override
	public List<PersonH> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(PersonH.class);
		List<PersonH> empList = criteria.list();
		for(PersonH emp : empList){
			System.out.println("ID="+emp.getId()+", Zipcode="+emp.getName());
		}
		tx.commit();
		return empList;
	}
	

	
}
