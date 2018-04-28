package views;

import AnnotedClasses.TournamentH;
import controllers.QuitController;
import controllers.TorunamentController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tournament {
	private static Stage window;
	public static void display(TournamentH tournament){
		System.out.println("Tournament "+tournament.getName());
			window = new Stage();
			window.setTitle("Tournament");
			TextField player1 = new TextField();
	        player1.setPrefSize(80, 30);
	        GridPane.setConstraints(player1,20,60);
	        Button plusPlayer1= new Button("+");
	        plusPlayer1.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer1,21,60);
	        TextField player2 = new TextField();
	        player2.setPrefSize(100, 30);
	        GridPane.setConstraints(player2,20,61);
	        Button plusPlayer2= new Button("+");
	        plusPlayer2.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer2,21,61);     
	        TextField player3 = new TextField();
	        player3.setPrefSize(100, 30);
	        GridPane.setConstraints(player3,20,64);  
	        TextField player4 = new TextField();
	        player4.setPrefSize(100, 30);
	        GridPane.setConstraints(player4,20,65); 
	        Button plusPlayer3= new Button("+");
	        plusPlayer3.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer3,21,64);
	        Button plusPlayer4= new Button("+");
	        plusPlayer4.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer4,21,65); 
	        TextField player5 = new TextField();
	        player5.setPrefSize(100, 30);
	        GridPane.setConstraints(player5,35,62);
	        TextField player6 = new TextField();
	        player6.setPrefSize(100, 30);
	        GridPane.setConstraints(player6,35,63);
	        TextField player7 = new TextField();
	        GridPane.setConstraints(player7,50,62);
	        TextField player8 = new TextField();
	        player8.setPrefSize(100, 30);
	        GridPane.setConstraints(player8,50,63);
	        TextField player9 = new TextField();
	        Button plusPlayer5= new Button("+");
	        plusPlayer5.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer5,36,62);
	        Button plusPlayer6= new Button("+");
	        plusPlayer6.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer6,36,63); 
	        Button plusPlayer7= new Button("+");
	        TextField winner = new TextField();
	        winner.setPrefSize(100, 30);
	        GridPane.setConstraints(winner,50,65);
	        plusPlayer7.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer7,51,62);
	        Button plusPlayer8= new Button("+");
	        plusPlayer8.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer8,51,63); 
	        player9.setPrefSize(100, 30);
	        GridPane.setConstraints(player9,65,62);
	        TextField player10 = new TextField();
	        player10.setPrefSize(100, 30);
	        GridPane.setConstraints(player10,65,63);
	        TextField player11 = new TextField();
	        Button plusPlayer9= new Button("+");
	        plusPlayer9.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer9,66,62);
	        Button plusPlayer10= new Button("+");
	        plusPlayer10.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer10,66,63); 
	        player11.setPrefSize(100, 30);
	        GridPane.setConstraints(player11,80,60);
	        TextField player12 = new TextField();
	        player12.setPrefSize(100, 30);
	        GridPane.setConstraints(player12,80,61);
	        Button plusPlayer11= new Button("+");
	        plusPlayer11.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer11,81,60);
	        Button plusPlayer12= new Button("+");
	        plusPlayer12.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer12,81,61); 
	        TextField player13 = new TextField();
	        player13.setPrefSize(100, 30);
	        GridPane.setConstraints(player13,80,64);
	        TextField player14 = new TextField();
	        player14.setPrefSize(100, 30);
	        GridPane.setConstraints(player14,80,65);
	        Button plusPlayer13= new Button("+");
	        plusPlayer13.setPrefSize(30, 30);     
	        GridPane.setConstraints(plusPlayer13,81,64);
	        Button plusPlayer14= new Button("+");
	        plusPlayer14.setPrefSize(30, 30);
	        GridPane.setConstraints(plusPlayer14,81,65); 
	        Label winnerLabel = new Label("   WINNER");
	        GridPane.setConstraints(winnerLabel,50,64);
	        winnerLabel.setFont(new Font("Arial", 17));
	        Label tournamentLabel = new Label("Tournament Name");
	        GridPane.setConstraints(tournamentLabel,50,12);
	        TextField tournamentName = new TextField();
	        tournamentName .setPrefSize(100, 30);
	        GridPane.setConstraints(tournamentName,50,13);
	        Label balanceLabel = new Label("Balance");
	        GridPane.setConstraints(balanceLabel,50,14);
	        Label balance = new Label("Balance");
	        GridPane.setConstraints(balance,50,15);
	        Label feeLabel = new Label("Tax");
	        GridPane.setConstraints(feeLabel,50,16);
	        Label fee = new Label("Fee");
	        GridPane.setConstraints(fee,50,17);
	        GridPane layout2 = new GridPane();
	        layout2.setVgap(1);
	        layout2.setHgap(1);
	        layout2.getChildren().addAll(feeLabel,fee,plusPlayer1,plusPlayer2,plusPlayer3,plusPlayer4,plusPlayer5,plusPlayer6,plusPlayer7,plusPlayer8,plusPlayer9,plusPlayer10,plusPlayer11,plusPlayer12,plusPlayer13,plusPlayer14,balanceLabel,balance,tournamentName,tournamentLabel,winnerLabel,winner,player14,player13,player12,player11,player10,player9,player8,player7,player6,player5,player4,player3,player2,player1);
	        Scene turneu = new Scene(layout2, 800, 400);
	        TorunamentController.populateStaff(tournament,fee,tournamentName, balance, player1, player2, player3, player4, player11, player12, player13, player14);
	        window.setOnCloseRequest(e -> {
				
				e.consume();
				QuitController.closeWindow(window);
				
	    	});
	        window.setScene(turneu);
	        window.show();
			}
}
