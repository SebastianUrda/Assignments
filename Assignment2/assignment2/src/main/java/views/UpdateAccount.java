package views;

import AnnotedClasses.PersonH;
import controllers.PersonController;
import controllers.QuitController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdateAccount {
	private static Stage window;
	
	public static void display(PersonH toUpdate){
		window = new Stage();	
		window.setTitle("Update Person Data");
		System.out.println("From Update Account "+toUpdate.getName());
	GridPane layoutUpdateAccount = new GridPane();
    layoutUpdateAccount.setPadding(new Insets(10, 10, 10, 10));
    layoutUpdateAccount.setVgap(8);
    layoutUpdateAccount.setHgap(10);
    Scene updateAccountScene = new Scene(layoutUpdateAccount, 400, 250);
    TextField nameUpdate = new TextField();
    nameUpdate.setPrefSize(100, 30);
    GridPane.setConstraints(nameUpdate,3,2);
    TextField emailUpdate = new TextField();
    emailUpdate.setPrefSize(100, 30);
    GridPane.setConstraints(emailUpdate,3,3);
    TextField passwordUpdate = new TextField();
    passwordUpdate.setPrefSize(100, 30);
    GridPane.setConstraints(passwordUpdate,3,4);
    TextField balanceUpdate = new TextField();
    balanceUpdate.setPrefSize(100, 30);
    GridPane.setConstraints(balanceUpdate,3,6);
    CheckBox isAdminUpdate = new CheckBox();
    GridPane.setConstraints(isAdminUpdate,3,5);
    Label nameLabel1Update = new Label("Name: ");
    GridPane.setConstraints(nameLabel1Update,2,2);
    nameLabel1Update.setFont(new Font("Arial", 15));
    Label emailLabelUpdate = new Label("E mail: ");
    GridPane.setConstraints(emailLabelUpdate,2,3);
    emailLabelUpdate.setFont(new Font("Arial", 15));
    Label passwordLabelUpdate = new Label("Password: ");
    GridPane.setConstraints(passwordLabelUpdate,2,4);
    passwordLabelUpdate.setFont(new Font("Arial", 15));
    Label isAdminLabelUpdate = new Label("Is Admin: ");
    GridPane.setConstraints(isAdminLabelUpdate,2,5);
    isAdminLabelUpdate.setFont(new Font("Arial", 15));
    Button updateAccountInside = new Button("Update");
    Label balanceLabelUpdate = new Label("Balance: ");
    GridPane.setConstraints(balanceLabelUpdate,2,6);
    balanceLabelUpdate.setFont(new Font("Arial", 15));
    GridPane.setConstraints(updateAccountInside,2,7);
    layoutUpdateAccount.getChildren().addAll(nameUpdate,nameLabel1Update,balanceLabelUpdate,balanceUpdate,emailUpdate,emailLabelUpdate,passwordUpdate,passwordLabelUpdate,isAdminUpdate,isAdminLabelUpdate,updateAccountInside);    
    PersonController.bindUpdateButton(updateAccountInside, toUpdate, nameUpdate, passwordUpdate, emailUpdate, isAdminUpdate, balanceUpdate,window);
    window.setOnCloseRequest(e -> {
		
		e.consume();
		QuitController.closeWindow(window);
		
	});
    window.setScene(updateAccountScene);
    window.show();
}
}
