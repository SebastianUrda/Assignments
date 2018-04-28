package views;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.Observable;
import java.util.Observer;

import org.hibernate.jpa.event.spi.jpa.Listener;

import controllers.AdminController;
import controllers.QuitController;
import javafx.geometry.*;
public class Admin implements Observer {
	private static Stage window;
	public static void display(){
		window = new Stage();	
		window.setTitle("Admin");
	 GridPane layoutAdmin = new GridPane();
     layoutAdmin.setPadding(new Insets(10, 10, 10, 10));
     layoutAdmin.setVgap(8);
     layoutAdmin.setHgap(10);
     Scene admin = new Scene(layoutAdmin, 320, 320);
     Button button2 = new Button("Create Trournament");
     GridPane.setConstraints(button2,1,1);
     
     Button viewButton = new Button("View Torunament");
     GridPane.setConstraints(viewButton,1,3);
     //free tournament choice box
     Label freeLabel = new Label("Free");
     GridPane.setConstraints(freeLabel,2,2);
     ChoiceBox<String> free = new ChoiceBox<>();
     GridPane.setConstraints(free,2,3);
  
     //paid tournament
     Label paidLabel = new Label("Paid");
     GridPane.setConstraints(paidLabel,3,2);
     ChoiceBox<String> paid = new ChoiceBox<>();
     GridPane.setConstraints(paid,3,3);
    
     Button deleteButton = new Button("Delete Torunament");
     GridPane.setConstraints(deleteButton,1,5);
     ChoiceBox<String> deletable = new ChoiceBox<>();
     GridPane.setConstraints(deletable,2,5);
     
     Button createAccount = new Button("Create Account");
     GridPane.setConstraints(createAccount,1,4);
     Button deleteAccount = new Button("Delte Account");
     GridPane.setConstraints(deleteAccount,1,6);
     ChoiceBox<String> deletablePersons = new ChoiceBox<>();
    

     GridPane.setConstraints(deletablePersons,2,6);
     Button updateAccount = new Button("Update Account");
     GridPane.setConstraints(updateAccount,1,7);
     Button search = new Button("Search Torunaments");
     GridPane.setConstraints(search,2,8);
     TextField name = new TextField();
     name.setPrefSize(100, 30);
     GridPane.setConstraints(name,1,8);
     layoutAdmin.getChildren().addAll(search,name,button2,viewButton,updateAccount,free,paid,deletable,deletablePersons,freeLabel,paidLabel,createAccount,deleteButton,deleteAccount);
     AdminController.bindCreateButton(createAccount);
     AdminController.bindCreateTournament(button2);
     AdminController.populateFreeCB(free);
     AdminController.populatePaidCB(paid);
     AdminController.populateDeletable(deletable);
     AdminController.bindDeleteTButton(deleteButton, deletable);
     AdminController.populateDeletablePersons(deletablePersons);
     AdminController.bindDeletePersonButton(deleteAccount, deletablePersons);
     AdminController.bindUpdatePersonButton(updateAccount, deletablePersons);
     AdminController.bindViewButton(viewButton,free,paid);
     AdminController.findByName(name, search);
     window.setOnCloseRequest(e -> {
			
			e.consume();
			QuitController.closeProgram(window);
			
});
     window.setScene(admin);
     window.show();
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
}
