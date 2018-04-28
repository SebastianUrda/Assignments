package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;

public class NonAdmin {
	public static void display(){
	GridPane layoutNonAdmin = new GridPane();
    layoutNonAdmin.setPadding(new Insets(10, 10, 10, 10));
    ChoiceBox<String> choiceBoxNA = new ChoiceBox<>();
    GridPane.setConstraints(choiceBoxNA,2,2);
    Button viewButtonNA = new Button("View Torunament");
    GridPane.setConstraints(viewButtonNA,1,2);
    layoutNonAdmin.getChildren().addAll(viewButtonNA,choiceBoxNA);
    Scene nonAdmin = new Scene(layoutNonAdmin, 300, 200); 
	}
}
