package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import AnnotedClasses.PersonH;
import AnnotedClasses.TournamentH;
import Business.AccountBusiness;
import Business.MatchBusiness;
import Business.TournamentBusiness;


public class TorunamentController {
	public static void bindCreateButton(Button button,TextField name,TextField startDate,TextField endDate,TextField tax) {
		button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	TournamentBusiness.createTorunament(name.getText(), startDate.getText(), endDate.getText(), tax.getText());
            	AlertController.createAlert("Success!", "Tournament was created Successfully!");
            }
        });
	}
	public static void populateStaff(TournamentH tour,Label fee, TextField name,Label balance,TextField player1,TextField player2,TextField player3,TextField player4,TextField player5,TextField player6,TextField player7,TextField player8)
	{
		name.setText(tour.getName());
		balance.setText(String.valueOf(tour.getAccount().getBalance()));
		fee.setText(String.valueOf(tour.getTax()));
		if(tour.getMatch1()!=null)
		{
			if(tour.getMatch1().getPlayer1()!=null)
				player1.setText(tour.getMatch1().getPlayer1().getName());
			if(tour.getMatch1().getPlayer2()!=null)
				player2.setText(tour.getMatch1().getPlayer2().getName());
		}
		if(tour.getMatch2()!=null)
		{
			if(tour.getMatch2().getPlayer1()!=null)
				player3.setText(tour.getMatch2().getPlayer1().getName());
			if(tour.getMatch2().getPlayer2()!=null)
				player4.setText(tour.getMatch2().getPlayer2().getName());
		}
		if(tour.getMatch3()!=null)
		{
			if(tour.getMatch3().getPlayer1()!=null)
				player5.setText(tour.getMatch3().getPlayer1().getName());
			if(tour.getMatch3().getPlayer2()!=null)
				player6.setText(tour.getMatch3().getPlayer2().getName());
		}
		if(tour.getMatch4()!=null)
		{
			if(tour.getMatch4().getPlayer1()!=null)
				player7.setText(tour.getMatch4().getPlayer1().getName());
			if(tour.getMatch4().getPlayer2()!=null)
				player8.setText(tour.getMatch4().getPlayer2().getName());
		}
	}
	public static void enroll(TournamentH tour,PersonH person)
	{
		if(tour.getMatch1().getPlayer1()==null)
		{
			tour.getMatch1().setPlayer1(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch1());
			
		}
		else
		if(tour.getMatch1().getPlayer2()==null)
		{
			tour.getMatch1().setPlayer2(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch1());
		}
		else
		if(tour.getMatch2().getPlayer1()==null)
		{
			tour.getMatch2().setPlayer1(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch2());
		}
		else
		if(tour.getMatch2().getPlayer2()==null)
		{
			tour.getMatch2().setPlayer2(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch2());
		}
		else
		if(tour.getMatch3().getPlayer1()==null)
		{
			tour.getMatch3().setPlayer1(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch3());
		}
		else
		if(tour.getMatch3().getPlayer2()==null)
		{
			tour.getMatch3().setPlayer2(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch3());
		}
		else
		if(tour.getMatch4().getPlayer1()==null)
		{
			tour.getMatch4().setPlayer1(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch4());
		}
		else
		if(tour.getMatch4().getPlayer2()==null)
		{
			tour.getMatch4().setPlayer2(person);
			person.getAccount().setBalance(person.getAccount().getBalance()-tour.getTax());
			tour.getAccount().setBalance(tour.getAccount().getBalance()+tour.getTax());
			AccountBusiness.update(person.getAccount());
			AccountBusiness.update(tour.getAccount());
			MatchBusiness.update(tour.getMatch4());
		}
		
	}
	
}
