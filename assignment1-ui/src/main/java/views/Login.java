package views;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Login {
	private static Stage window;

	public static void display(){
	
	 window = new Stage();
     window.setTitle("Log in");
     GridPane grid = new GridPane();
     grid.setPadding(new Insets(10, 10, 10, 10));
     grid.setVgap(8);
     grid.setHgap(10);

     //Name Label - constrains use (child, column, row)
     Label nameLabel = new Label("Username:");
     GridPane.setConstraints(nameLabel, 2, 5);

     //Name Input
     TextField nameInput = new TextField();
     nameInput.setPromptText("user");
     GridPane.setConstraints(nameInput, 3, 5);

     //Password Label
     Label passLabel = new Label("Password:");
     GridPane.setConstraints(passLabel, 2, 6);

     //Password Input
     TextField passInput = new TextField();
     passInput.setPromptText("password");
     GridPane.setConstraints(passInput, 3, 6);

     //Login
     Button loginButton = new Button("Log In");
     GridPane.setConstraints(loginButton, 3, 7);
     
     
     grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
     
     Scene scene = new Scene(grid, 300, 200);
     
     window.setScene(scene);
     window.show();
	
	}
}
