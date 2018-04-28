package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import AnnotedClasses.PersonH;
import Hibernate.HibernateUtil;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		PersonH emp = new PersonH();
		emp.setName("David");
		emp.setEmail("Developeru@bazatu.com");
		emp.setPassword("SDeviatamea");
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
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