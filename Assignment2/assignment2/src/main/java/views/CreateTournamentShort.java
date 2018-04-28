package views;

import controllers.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateTournamentShort {
	private static Stage window;
	public static void display(){
		window = new Stage();	
		window.setTitle("Create Tournament");
		GridPane createtournamentl = new GridPane();
	        createtournamentl.setPadding(new Insets(10, 10, 10, 10));
	        createtournamentl.setVgap(8);
	        createtournamentl.setHgap(10);
	        Scene createTournament = new Scene(createtournamentl, 250, 300);
	        Label nameLabel = new Label("Name: ");
	        GridPane.setConstraints(nameLabel,1,1);
	        nameLabel.setFont(new Font("Arial", 15));
	        TextField name = new TextField("name");
	        name.setPrefSize(100, 30);
	        GridPane.setConstraints(name,2,1);
	        Label startDateLabel = new Label("Start Date");
	        GridPane.setConstraints(startDateLabel,1,2);
	        startDateLabel.setFont(new Font("Arial", 15));
	        TextField startDate = new TextField("2018-04-16");
	        startDate.setPrefSize(100, 30);
	        GridPane.setConstraints(startDate,2,2);
	        Label endDateLabel = new Label("End Date");
	        GridPane.setConstraints(endDateLabel,1,3);
	        endDateLabel.setFont(new Font("Arial", 15));
	        TextField endDate = new TextField("2018-04-18");
	        endDate.setPrefSize(100, 30);
	        GridPane.setConstraints(endDate,2,3);
	        Label taxLabel = new Label("Tax");
	        GridPane.setConstraints(taxLabel,1,4);
	        taxLabel.setFont(new Font("Arial", 15));
	        TextField tax = new TextField("0");
	        tax.setPrefSize(100, 30);
	        GridPane.setConstraints(tax,2,4);
	        Button createButton = new Button("Create");
	        GridPane.setConstraints(createButton,2,5);
	        createtournamentl.getChildren().addAll(tax,taxLabel,endDate,endDateLabel,startDate,startDateLabel,name,nameLabel,createButton);      
	        TorunamentController.bindCreateButton(createButton,name,startDate,endDate,tax);
	        window.setOnCloseRequest(e -> {
				
				e.consume();
				QuitController.closeWindow(window);
				
			});
			
			window.setScene(createTournament);
			window.show();
	}
}
