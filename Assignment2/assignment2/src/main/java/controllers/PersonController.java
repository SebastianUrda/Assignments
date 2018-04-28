package controllers;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.AlertWindow;
import AnnotedClasses.AccountH;
import AnnotedClasses.PersonH;
import AnnotedClasses.TournamentH;
import Business.TournamentBusiness;
import Business.UserBusiness;
import HibernateDAO.AccountDAOH;
import HibernateDAO.PersonDAOH;
import HibernateDaoInterfaces.AccountDao;
import HibernateDaoInterfaces.PersonDao;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
public class PersonController {

public static void bindCreateButton(Button createButton,TextField name, TextField pass,TextField email,CheckBox isAdmin, TextField balance, Stage window ){

	createButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	UserBusiness.createUser(name, pass, email,isAdmin,balance,window);
        	AlertController.createAlert("Success!", "Person was created Successfully!");
        }
    });
}
public static void bindUpdateButton(Button updateButton,PersonH person,TextField name, TextField pass,TextField email,CheckBox isAdmin, TextField balance, Stage window)
{
	updateButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	UserBusiness.updateData(person,name, pass, email,isAdmin,balance,window);
        	AlertController.createAlert("Success!", "Person data was updated Successfully!");
        }
    });
}
public static void enroll (Button enroll,ChoiceBox<String> cb,String name)
{
	enroll.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	TournamentH tour=TournamentBusiness.findByName(cb.getValue());
        	PersonH person=UserBusiness.findByName(name);
        	TorunamentController.enroll(tour, person);
        	AlertController.createAlert("Success!", "Person was enrolled Successfully!");
        }
    });
}
}
