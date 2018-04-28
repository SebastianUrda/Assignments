package Hibernate;


import Hibernate.HibernateUtil;
import Models.Person;

import org.hibernate.Session;
public class HibernateMain {

	public static void main(String[] args) {
		Person emp = new Person();
		emp.setName("SebastianUrda");
		emp.setEmail("Sebi@bazatu.com");
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}
