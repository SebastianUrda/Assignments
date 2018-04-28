package views;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class Admin {
	
	public static void display(){
	 GridPane layoutAdmin = new GridPane();
     layoutAdmin.setPadding(new Insets(10, 10, 10, 10));
     layoutAdmin.setVgap(8);
     layoutAdmin.setHgap(10);
     Scene admin = new Scene(layoutAdmin, 300, 200);
     Button button2 = new Button("Create Trournament");
     
     GridPane.setConstraints(button2,1,1);
     ChoiceBox<String> choiceBox = new ChoiceBox<>();
     GridPane.setConstraints(choiceBox,2,2);
  
     Button viewButton = new Button("View Torunament");
     GridPane.setConstraints(viewButton,1,2);
     Button deleteButton = new Button("Delete Torunament");
     GridPane.setConstraints(deleteButton,1,4);
     Button createAccount = new Button("Create Account");
     GridPane.setConstraints(createAccount,1,3);
     Button deleteAccount = new Button("Delte/Update Account");
     GridPane.setConstraints(deleteAccount,1,5);
     layoutAdmin.getChildren().addAll(button2,viewButton,choiceBox,createAccount,deleteButton,deleteAccount);
	}
	
}
