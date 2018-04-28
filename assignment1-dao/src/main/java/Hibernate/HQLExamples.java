package Hibernate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import AnnotedClasses.PersonH;
import Hibernate.HibernateUtil;

public class HQLExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		//HQL example - Get All PersonHs
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from PersonH");
		List<PersonH> empList = query.list();
		for(PersonH emp : empList){
			System.out.println("List of PersonHs::"+emp.getId()+","+emp.getEmail());
		}
		
		//HQL example - Get PersonH with id
		query = session.createQuery("from PersonH where id= :id");
		query.setLong("id", 1);
		PersonH emp = (PersonH) query.uniqueResult();
		System.out.println("PersonH Name="+emp.getName()+", City="+emp.getEmail());
		
		//HQL pagination example
		query = session.createQuery(" from PersonH");
		query.setFirstResult(0); //starts with 0
		query.setFetchSize(2);
		empList = query.list();
		for(PersonH emp4 : empList){
			System.out.println("Paginated PersonHs::"+emp4.getId()+","+emp4.getEmail());
		}
		
		//HQL Update PersonH
		query = session.createQuery("update PersonH set name= :name where id= :id");
		query.setParameter("name", "Sebastian");
		query.setLong("id", 1);
		int result = query.executeUpdate();
		System.out.println("PersonH Update Status="+result);
		

		//HQL Delete PersonH, we need to take care of foreign key constraints too
		/*query = session.createQuery(" delete from Address where id= :id");
		query.setLong("id", 16);
		result = query.executeUpdate();
		System.out.println("Address Delete Status="+result);*/
		
		query = session.createQuery(" delete from PersonH where id= :id");
		query.setLong("id", 16);
		result = query.executeUpdate();
		System.out.println("PersonH Delete Status="+result);
		
		//HQL Aggregate function examples
		/*query = session.createQuery(" select sum(salary) from PersonH");
		double sumSalary = (Double) query.uniqueResult();
		System.out.println("Sum of all Salaries= "+sumSalary);*/
		
		//HQL join examples
		/*query = session.createQuery("select e.name, a.city from PersonH e "
				+ "INNER JOIN e.address a");
		List<Object[]> list = query.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}*/
		
		//HQL group by and like example
		/*query = session.createQuery("select e.name, sum(e.salary), count(e)"
				+ " from PersonH e where e.name like '%i%' group by e.name");
		List<Object[]> groupList = query.list();
		for(Object[] arr : groupList){
			System.out.println(Arrays.toString(arr));
		}
		*/
		//HQL order by example
		/*query = session.createQuery("from PersonH e order by e.id desc");
		empList = query.list();
		for(PersonH emp3 : empList){
			System.out.println("ID Desc Order PersonH::"+emp3.getId()+","+emp3.getAddress().getCity());
		}
		*/
		//rolling back to save the test data
		tx.rollback();
		
		//closing hibernate resources
		sessionFactory.close();
	}

}