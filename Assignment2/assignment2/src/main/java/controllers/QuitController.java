package controllers;
import org.hibernate.SessionFactory;

import javafx.stage.Stage;
import Hibernate.HibernateUtil;
import views.Ask;
public class QuitController {
public static void closeProgram(Stage window){
		
		boolean answer = Ask.display("Confirmation", "Are you sure you want to quit?");
		
		if(answer) {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			sessionFactory.close();
			window.close();
			
		}
}
public static void closeWindow(Stage window){
				window.close();	
}
}
