package views;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import controllers.QuitController;
import javafx.geometry.*;

public class CreateTournament {
	private static Stage window;
	public static void display(){
		window = new Stage();	
		window.setTitle("Create Tournament");
		 GridPane createtournamentl = new GridPane();
	        createtournamentl.setPadding(new Insets(10, 10, 10, 10));
	        createtournamentl.setVgap(8);
	        createtournamentl.setHgap(10);
	        Scene createTournament = new Scene(createtournamentl, 250, 390);
	        Label p1label = new Label("Player 1: ");
	        GridPane.setConstraints(p1label,1,1);
	        p1label.setFont(new Font("Arial", 15));
	        TextField player1t = new TextField("playerone");
	        player1t.setPrefSize(100, 30);
	        GridPane.setConstraints(player1t,2,1);
	        Label p2label = new Label("Player 2: ");
	        GridPane.setConstraints(p2label,1,2);
	        p2label.setFont(new Font("Arial", 15));
	        TextField player2t = new TextField("playertwo");
	        player2t.setPrefSize(100, 30);
	        GridPane.setConstraints(player2t,2,2);
	        Label p3label = new Label("Player 3: ");
	        GridPane.setConstraints(p3label,1,3);
	        p3label.setFont(new Font("Arial", 15));
	        TextField player3t = new TextField("playertree");
	        player3t.setPrefSize(100, 30);
	        GridPane.setConstraints(player3t,2,3);
	        Label p4label = new Label("Player 4: ");
	        GridPane.setConstraints(p4label,1,4);
	        p4label.setFont(new Font("Arial", 15));
	        TextField player4t = new TextField("playerfour");
	        player4t.setPrefSize(100, 30);
	        GridPane.setConstraints(player4t,2,4);
	        Label p5label = new Label("Player 5: ");
	        GridPane.setConstraints(p5label,1,5);
	        p5label.setFont(new Font("Arial", 15));
	        TextField player5t = new TextField("playerfive");
	        player5t.setPrefSize(100, 30);
	        GridPane.setConstraints(player5t,2,5);
	        Label p6label = new Label("Player 6: ");
	        GridPane.setConstraints(p6label,1,6);
	        p6label.setFont(new Font("Arial", 15));
	        TextField player6t = new TextField("playersix");
	        player6t.setPrefSize(100, 30);
	        GridPane.setConstraints(player6t,2,6);
	        Label p7label = new Label("Player 7: ");
	        GridPane.setConstraints(p7label,1,7);
	        p7label.setFont(new Font("Arial", 15));
	        TextField player7t = new TextField("playerseven");
	        player7t.setPrefSize(100, 30);
	        GridPane.setConstraints(player7t,2,7);
	        Label p8label = new Label("Player 8: ");
	        GridPane.setConstraints(p8label,1,8);
	        p8label.setFont(new Font("Arial", 15));
	        TextField player8t = new TextField("playereight");
	        player8t.setPrefSize(100, 30);
	        GridPane.setConstraints(player8t,2,8);
	        Label namel = new Label("Tournament: ");
	        GridPane.setConstraints(namel,1,9);
	        namel.setFont(new Font("Arial", 15));
	        TextField namet = new TextField("Tournament");
	        namet.setPrefSize(100, 30);
	        GridPane.setConstraints(namet,2,9);
	        Button CreateButton = new Button("Create");
	        GridPane.setConstraints(CreateButton,2,10);
	        Button BackButton = new Button("Back");
	        GridPane.setConstraints(BackButton,2,11);
	        createtournamentl.getChildren().addAll(player1t,p1label,player2t,p2label,player3t,p3label,player4t,p4label,player5t,p5label,player6t,p6label,player7t,p7label,player8t,p8label,namet,namel,CreateButton,BackButton);      
			window.setOnCloseRequest(e -> {
				
				e.consume();
				QuitController.closeWindow(window);
				
			});
			
			window.setScene(createTournament);
			window.show();
	}
}
