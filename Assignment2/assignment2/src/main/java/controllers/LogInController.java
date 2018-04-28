package controllers;

import views.Admin;
import views.AlertWindow;
import views.Login;
import views.NonAdmin;
import Business.UserBusiness;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class LogInController {
	
public static void login(Stage window){
		
		window.close();
		Login.display();
}
public static void loginProgram(TextField name, TextField pass, Stage window){
	
	String nameInput = name.getText();
	String passInput = pass.getText();
	
	UserBusiness ubl = new UserBusiness();
	boolean checkCredentials = ubl.authenticate(nameInput, passInput);
	
	if(checkCredentials){
		
		if(ubl.checkIfAdmin(nameInput))
		{
			
			window.close();
			Admin.display();
		}
		else 
		{
			window.close();
			NonAdmin.display(name.getText());
		}
		
	}
	else AlertWindow.display("Log in Fail!","Wrong username or password.");
}
	public static void bindLoginButton(Button loginButton, TextField nameInput, TextField passInput, Stage window) {
	
	loginButton.setOnAction(e -> loginProgram(nameInput, passInput, window));
	
}
}
