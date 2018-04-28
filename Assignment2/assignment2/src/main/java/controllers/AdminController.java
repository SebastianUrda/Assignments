package controllers;

import javafx.scene.control.TextField;
import java.util.ArrayList;

import java.util.List;
import java.util.Observable;

import AnnotedClasses.TournamentH;
import AnnotedClasses.PersonH;
import HibernateDAO.PersonDAOH;
import HibernateDAO.TournamentDAOH;
import HibernateDaoInterfaces.PersonDao;
import HibernateDaoInterfaces.TournamentDao;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import views.CreateAccount;
import views.CreateTournament;
import views.CreateTournamentShort;
import views.Tournament;
import views.UpdateAccount;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Business.*;
public class AdminController extends Observable{
public static void registerProgram()	{
		
		CreateAccount.display();
		
}
public static void createTournament()	{
	
	CreateTournamentShort.display();
	
}
public static void viewTournament(String name)	{
	
	Tournament.display(TournamentBusiness.findByName(name));
	
}
public static void populateFreeCB(ChoiceBox<String> choice)
{	
	TournamentBusiness tb=new TournamentBusiness();
	List<String> toPrint= new ArrayList<String>();
	for(Object tour: tb.getFreeTorunaments())
	{
		toPrint.add(((TournamentH) tour).getName());
	}
	choice.getItems().addAll(toPrint);
	
}
public static void populatePaidCB(ChoiceBox<String> choice)
{
	TournamentBusiness tb=new TournamentBusiness();
	List<String> toPrint= new ArrayList<String>();
	for(Object tour: tb.getPaidTorunaments())
	{
		toPrint.add(((TournamentH) tour).getName());
	}
	choice.getItems().addAll(toPrint);
}
public static void findByName(TextField name,Button find)
{
	
	find.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	TournamentH tour=TournamentBusiness.findByName(name.getText());
        	if(tour!=null)
        	Tournament.display(tour);
        	else
        		AlertController.createAlert("Fail!", "Wrong Name Insertet!");
        }
    });	
}
public static void populateDeletable(ChoiceBox<String> choice)
{
	TournamentBusiness tb=new TournamentBusiness();
	List<String> toPrint= new ArrayList<String>();
	for(Object tour: tb.getAllTorunaments())
	{
		toPrint.add(((TournamentH) tour).getName());
	}
	choice.getItems().addAll(toPrint);
}
public static void populateDeletablePersons(ChoiceBox<String> choice)
{
	UserBusiness tb=new UserBusiness();
	List<String> toPrint= new ArrayList<String>();
	for(Object tour: tb.getAllPersons())
	{
		toPrint.add(((PersonH) tour).getName());
	}
	choice.getItems().addAll(toPrint);
}
public static void deleteTournament(ChoiceBox<String> choice)
{
	TournamentBusiness tb=new TournamentBusiness();
	TournamentH tournament=new TournamentH ();
	tb.deleteTournament(choice.getValue());
	
}

public static void bindCreateButton(Button regButton) {
	
	regButton.setOnAction(e -> AdminController.registerProgram());	
}
public static void bindViewButton(Button viewButton,ChoiceBox<String> choice1,ChoiceBox<String> choice2) {
	
	viewButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	if(choice1.getValue()==null)
        		AdminController.viewTournament(choice2.getValue());
        	else 	
        		AdminController.viewTournament(choice1.getValue());
        }
    });
}
public static void bindDeleteTButton(Button delete,ChoiceBox<String> choice) {
	
	
	delete.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	AdminController.deleteTournament(choice);
        	AlertController.createAlert("Success!", "Tournament was deleted Successfully!");
        }
    });
}
public static void bindCreateTournament(Button create)
{
	create.setOnAction(e -> AdminController.createTournament());
}
public static void bindDeletePersonButton(Button delete,ChoiceBox<String> deletecb)
{
	delete.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
        	UserBusiness.deleteUser(deletecb.getValue());
        	AlertController.createAlert("Success!", "Tournament was deleted Successfully!");
        }
    });
	
}
public static void bindUpdatePersonButton (Button update, ChoiceBox<String> updatecb)
{
	update.setOnAction(e -> UpdateAccount.display(UserBusiness.findByName(updatecb.getValue())));
}
public static void bindUpdateSelf (Button update,String person)
{
	update.setOnAction(e -> UpdateAccount.display(UserBusiness.findByName(person)));
}

}