package views;

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

public class CreateAccount {
	public static void display(){
		GridPane layoutCreateAccount = new GridPane();
        layoutCreateAccount.setPadding(new Insets(10, 10, 10, 10));
        layoutCreateAccount.setVgap(8);
        layoutCreateAccount.setHgap(10);
        Scene createAccountScene = new Scene(layoutCreateAccount, 300, 200);
        TextField name = new TextField();
        name.setPrefSize(100, 30);
        GridPane.setConstraints(name,3,2);
        TextField email = new TextField();
        email.setPrefSize(100, 30);
        GridPane.setConstraints(email,3,3);
        TextField password = new TextField();
        password.setPrefSize(100, 30);
        GridPane.setConstraints(password,3,4);
        CheckBox isAdmin = new CheckBox();
        GridPane.setConstraints(isAdmin,3,5);
        Label nameLabel1 = new Label("Name: ");
        GridPane.setConstraints(nameLabel1,2,2);
        nameLabel1.setFont(new Font("Arial", 15));
        Label emailLabel = new Label("E mail: ");
        GridPane.setConstraints(emailLabel,2,3);
        emailLabel.setFont(new Font("Arial", 15));
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel,2,4);
        passwordLabel.setFont(new Font("Arial", 15));
        Label isAdminLabel = new Label("Is Admin: ");
        GridPane.setConstraints(isAdminLabel,2,5);
        isAdminLabel.setFont(new Font("Arial", 15));
        Button createAccountBackButton = new Button("Back");
        GridPane.setConstraints(createAccountBackButton,3,6);
        System.out.println("Aici1");
        Button createAccountInside = new Button("Create");
        GridPane.setConstraints(createAccountInside,2,6);
        layoutCreateAccount.getChildren().addAll(name,nameLabel1,email,emailLabel,password,passwordLabel,isAdmin,isAdminLabel,createAccountInside,createAccountBackButton);    
	}
}
