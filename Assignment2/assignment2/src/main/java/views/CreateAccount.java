package views;

import controllers.PersonController;
import controllers.QuitController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateAccount {
	private static Stage window;
	public static void display(){
		window = new Stage();	
		window.setTitle("Create Account");
		GridPane layoutCreateAccount = new GridPane();
        layoutCreateAccount.setPadding(new Insets(10, 10, 10, 10));
        layoutCreateAccount.setVgap(8);
        layoutCreateAccount.setHgap(10);
        Scene createAccountScene = new Scene(layoutCreateAccount, 300, 220);
        TextField name = new TextField();
        name.setPrefSize(100, 30);
        GridPane.setConstraints(name,3,2);
        TextField email = new TextField();
        email.setPrefSize(100, 30);
        GridPane.setConstraints(email,3,3);
        TextField password = new TextField();
        password.setPrefSize(100, 30);
        GridPane.setConstraints(password,3,4);
        Label nameLabel1 = new Label("Name: ");
        GridPane.setConstraints(nameLabel1,2,2);
        nameLabel1.setFont(new Font("Arial", 15));
        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel,2,3);
        emailLabel.setFont(new Font("Arial", 15));
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel,2,4);
        passwordLabel.setFont(new Font("Arial", 15));
        Label isAdminLabel = new Label("Is Admin: ");
        GridPane.setConstraints(isAdminLabel,2,5);
        isAdminLabel.setFont(new Font("Arial", 15));
        CheckBox isAdmin = new CheckBox();
        GridPane.setConstraints(isAdmin,3,5);
        Label balanceLabel = new Label("Balance: ");
        GridPane.setConstraints(balanceLabel,2,6);
        balanceLabel.setFont(new Font("Arial", 15));
        TextField balance = new TextField();
        GridPane.setConstraints(balance,3,6);
        Button createAccountBackButton = new Button("Back");
        GridPane.setConstraints(createAccountBackButton,3,7);
        Button createAccountInside = new Button("Create");
        GridPane.setConstraints(createAccountInside,2,7);
        layoutCreateAccount.getChildren().addAll(name,nameLabel1,email,emailLabel,password,passwordLabel,isAdmin,isAdminLabel,createAccountInside,balanceLabel,balance);    
        PersonController.bindCreateButton(createAccountInside,name, password,email,isAdmin, balance, window );
        window.setOnCloseRequest(e -> {
			
			e.consume();
			QuitController.closeWindow(window);
			
        	});
        window.setScene(createAccountScene);
        window.show();
	}
	
}
