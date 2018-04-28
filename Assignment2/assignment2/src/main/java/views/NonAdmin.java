package views;

import controllers.AdminController;
import controllers.PersonController;
import controllers.QuitController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NonAdmin {
	private static Stage window;
	public static void display(String Logged){
	window = new Stage();
	window.setTitle("User");
	GridPane layoutNonAdmin = new GridPane();
    layoutNonAdmin.setPadding(new Insets(10, 10, 10, 10));
    layoutNonAdmin.setVgap(8);
    layoutNonAdmin.setHgap(10);
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
    Button updateButton = new Button("Update your data");
    GridPane.setConstraints(updateButton,1,4);
    Button search = new Button("Search Torunaments");
    GridPane.setConstraints(search,2,5);
    TextField name = new TextField();
    name.setPrefSize(100, 30);
    GridPane.setConstraints(name,1,5);
    ChoiceBox<String> enrl =new ChoiceBox<>();
    GridPane.setConstraints(enrl,1,6);
    Button enroll= new Button("Enroll");
    GridPane.setConstraints(enroll,2,6);
    layoutNonAdmin.getChildren().addAll(enrl,enroll,name,search,updateButton,viewButton,freeLabel,free,paidLabel,paid);
    Scene nonAdmin = new Scene(layoutNonAdmin, 300, 200); 
    AdminController.populateFreeCB(free);
    AdminController.populatePaidCB(paid);
    AdminController.bindUpdateSelf(updateButton, Logged);
    AdminController.bindViewButton(viewButton,free,paid);
    AdminController.populateDeletable(enrl);
    PersonController.enroll(enroll, enrl, Logged);
    
    AdminController.findByName(name, search);
    window.setOnCloseRequest(e -> {
			
			e.consume();
			QuitController.closeProgram(window);
			
    	});
    window.setScene(nonAdmin);
    window.show();
	}
}
