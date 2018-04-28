package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import AnnotedClasses.PersonH;
import Hibernate.HibernateUtil;

public class HibernateJavaConfigMain {

	public static void main(String[] args) {
		PersonH emp = new PersonH();
		emp.setName("Lisa");
		emp.setEmail("Manager");
		
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}