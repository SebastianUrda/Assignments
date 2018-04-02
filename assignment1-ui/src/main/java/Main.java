import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;	
import javafx.scene.control.ChoiceBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application{
	
	 Stage window;
	 Button button;
	 Scene turneu,scene,admin,createTournament,createAccountScene,nonAdmin,updateAccountScene;
	 int eAdmin=0;
	 String logged;
	public static void main(String[] args) {
        launch(args);
}
	 public String getSubstringUntilFirstNumber(String source) {
         return source.split("[0-9]")[0];
     }
	@Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Table Tennis");
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
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            if(PersonController.testLogIn(nameInput.getText(), passInput.getText())==1)
            	{window.setScene(admin);eAdmin=1;}
            else if(PersonController.testLogIn(nameInput.getText(), passInput.getText())==0){ window.setScene(nonAdmin);eAdmin=0;logged=nameInput.getText();System.out.println(logged);}
            else {
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Log in fail!");
            	alert.setHeaderText(null);
            	alert.setContentText("The Name Password combination you entered did not match.Please try again!");
            	alert.showAndWait();
            }
            }
        });
        
        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
        //scene 2
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
        plusPlayer1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player1.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player2.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player1.setText(TournamentController.toPrintInTB1());
            	
            	TournamentController.matchesTester();
            	player5.setText(TournamentController.toPrintInTB5());
            	System.out.println("Plus player 1");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
                
            }
        });
        plusPlayer2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player1.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player2.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player2.setText(TournamentController.toPrintInTB2());
            	TournamentController.matchesTester();
            	player5.setText(TournamentController.toPrintInTB5());
            	System.out.println("Plus player 2");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            	
            }
        });
        plusPlayer3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player3.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player4.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player3.setText(TournamentController.toPrintInTB3());
            	TournamentController.matchesTester();
            	player6.setText(TournamentController.toPrintInTB6());
            	System.out.println("Plus player 3");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        plusPlayer4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player3.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player4.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player4.setText(TournamentController.toPrintInTB4());
            	TournamentController.matchesTester();
            	player6.setText(TournamentController.toPrintInTB6());
            	System.out.println("Plus player 4");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        player7.setPrefSize(100, 30);
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
        plusPlayer5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player5.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player6.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player5.setText(TournamentController.toPrintInTB5());
            	TournamentController.matchesTester();
            	player7.setText(TournamentController.toPrintInTB7());
            	System.out.println("Plus player 3");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        plusPlayer6.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player5.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player6.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player6.setText(TournamentController.toPrintInTB6());
            	TournamentController.matchesTester();
            	player7.setText(TournamentController.toPrintInTB7());
            	System.out.println("Plus player 4");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        Button plusPlayer7= new Button("+");
        TextField winner = new TextField();
        winner.setPrefSize(100, 30);
        GridPane.setConstraints(winner,50,65);
        plusPlayer7.setPrefSize(30, 30);     
        GridPane.setConstraints(plusPlayer7,51,62);
        Button plusPlayer8= new Button("+");
        plusPlayer8.setPrefSize(30, 30);
        GridPane.setConstraints(plusPlayer8,51,63); 
        plusPlayer7.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player7.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player8.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player7.setText(TournamentController.toPrintInTB7());
            	TournamentController.matchesTester();
            	winner.setText(TournamentController.toPrintInTBWinner());
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        plusPlayer8.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player7.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player8.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player8.setText(TournamentController.toPrintInTB8());
            	TournamentController.matchesTester();
            	winner.setText(TournamentController.toPrintInTBWinner());
            	//System.out.println("Plus player 4");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
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
        plusPlayer9.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player9.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player10.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player9.setText(TournamentController.toPrintInTB9());
            	TournamentController.matchesTester();
            	player8.setText(TournamentController.toPrintInTB8());
            	System.out.println("Plus player 3");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        plusPlayer10.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player9.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player10.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player10.setText(TournamentController.toPrintInTB10());
            	TournamentController.matchesTester();
            	player8.setText(TournamentController.toPrintInTB8());
            	System.out.println("Plus player 4");
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
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
        plusPlayer11.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player11.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player12.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player11.setText(TournamentController.toPrintInTB11());
            	TournamentController.matchesTester();
            	player9.setText(TournamentController.toPrintInTB9());
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            	
            }
        });
        plusPlayer12.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player11.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player12.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	System.out.println("First player: "+firstPlayer+"Second player: "+secondPlayer);
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player12.setText(TournamentController.toPrintInTB12());
            	TournamentController.matchesTester();
            	player9.setText(TournamentController.toPrintInTB9());
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            	
            }
        });
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
        plusPlayer13.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player13.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player14.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp1++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player13.setText(TournamentController.toPrintInTB13());
            	TournamentController.matchesTester();
            	player10.setText(TournamentController.toPrintInTB10());
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        plusPlayer14.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	String firstPlayer=getSubstringUntilFirstNumber(player13.getText());
            	firstPlayer = firstPlayer.substring(0, firstPlayer.length() - 1);
            	String secondPlayer=getSubstringUntilFirstNumber(player14.getText());
            	secondPlayer = secondPlayer.substring(0, secondPlayer.length() - 1);
            	if(eAdmin==1 || firstPlayer.equals(logged)|| secondPlayer.equals(logged))
            	{
            	int pp1=TournamentController.getInitialScorePlayer1(firstPlayer,secondPlayer);
            	int pp2=TournamentController.getInitialScorePlayer2(firstPlayer,secondPlayer);
            	//System.out.println("Score "+firstPlayer+pp1+"Score"+secondPlayer+pp2);
            	pp2++;
            	TournamentController.updateScore(firstPlayer, secondPlayer, pp1, pp2);
            	TournamentController.playMatch(firstPlayer, secondPlayer);
            	player14.setText(TournamentController.toPrintInTB14());
            	TournamentController.matchesTester();
            	player10.setText(TournamentController.toPrintInTB10());
            	}
            	else 
            	{
            		Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Update Fail!");
                	alert.setHeaderText(null);
                	alert.setContentText("You are not allowed to alter this match!");
                	alert.showAndWait();
            	}
            }
        });
        
        Label winnerLabel = new Label("   WINNER");
        GridPane.setConstraints(winnerLabel,50,64);
        winnerLabel.setFont(new Font("Arial", 17));
        Label tournamentLabel = new Label("Tournament Name");
        GridPane.setConstraints(tournamentLabel,50,14);
        TextField tournamentName = new TextField();
        tournamentName .setPrefSize(100, 30);
        GridPane.setConstraints(tournamentName,50,15);
        Button BackButtonTournamentView = new Button("Back");
        GridPane.setConstraints(BackButtonTournamentView,50,66);
        BackButtonTournamentView.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(eAdmin==1)window.setScene(admin);
            	else window.setScene(nonAdmin);
            }
        });
        GridPane layout2 = new GridPane();
        layout2.setVgap(1);
        layout2.setHgap(1);
        layout2.getChildren().addAll(plusPlayer1,plusPlayer2,plusPlayer3,plusPlayer4,plusPlayer5,plusPlayer6,plusPlayer7,plusPlayer8,plusPlayer9,plusPlayer10,plusPlayer11,plusPlayer12,plusPlayer13,plusPlayer14,BackButtonTournamentView,tournamentName,tournamentLabel,winnerLabel,winner,player14,player13,player12,player11,player10,player9,player8,player7,player6,player5,player4,player3,player2,player1);
        turneu = new Scene(layout2, 750, 350);
        //admin
        GridPane layoutAdmin = new GridPane();
        layoutAdmin.setPadding(new Insets(10, 10, 10, 10));
        layoutAdmin.setVgap(8);
        layoutAdmin.setHgap(10);
        admin = new Scene(layoutAdmin, 300, 200);
        Button button2 = new Button("Create Trournament");
        button2.setOnAction(e -> window.setScene(createTournament));
        GridPane.setConstraints(button2,1,1);
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        GridPane.setConstraints(choiceBox,2,2);
        choiceBox.getItems().addAll(TournamentController.listOfNames());
        Button viewButton = new Button("View Torunament");
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.setScene(turneu);
            	tournamentName.setText(choiceBox.getValue());
            	TournamentController.findInListByName(choiceBox.getValue());
                 player1.setText(TournamentController.toPrintInTB1());
                 player2.setText(TournamentController.toPrintInTB2());
                 player3.setText(TournamentController.toPrintInTB3());
                 player4.setText(TournamentController.toPrintInTB4());
                 player5.setText(TournamentController.toPrintInTB5());
                 player6.setText(TournamentController.toPrintInTB6());
                 player7.setText(TournamentController.toPrintInTB7());
                 player8.setText(TournamentController.toPrintInTB8());
                 player9.setText(TournamentController.toPrintInTB9());
                 player10.setText(TournamentController.toPrintInTB10());
                 player11.setText(TournamentController.toPrintInTB11());
                 player12.setText(TournamentController.toPrintInTB12());
                 player13.setText(TournamentController.toPrintInTB13());
                 player14.setText(TournamentController.toPrintInTB14());
                 TournamentController.matchesTester();
                 winner.setText(TournamentController.toPrintInTBWinner());
            }
        });
        GridPane.setConstraints(viewButton,1,2);
        Button deleteButton = new Button("Delete Torunament");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	tournamentName.setText(choiceBox.getValue());
            	TournamentController.findInListByName(choiceBox.getValue());  
            	TournamentController.deleteTournament();
            	ChoiceBox<String> choiceBox=new ChoiceBox<>();
            	choiceBox.getItems().addAll(TournamentController.listOfNames());
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Tournament deleted!");
            	alert.setHeaderText(null);
            	alert.setContentText("The tournament was succesfully deleted!");
            	alert.showAndWait();
            }
        });
        GridPane.setConstraints(deleteButton,1,4);
        Button createAccount = new Button("Create Account");
        createAccount.setOnAction(e -> window.setScene(createAccountScene));
        GridPane.setConstraints(createAccount,1,3);
        Button deleteAccount = new Button("Delte/Update Account");
        deleteAccount.setOnAction(e -> window.setScene(updateAccountScene));
        GridPane.setConstraints(deleteAccount,1,5);
        layoutAdmin.getChildren().addAll(button2,viewButton,choiceBox,createAccount,deleteButton,deleteAccount);
        //non-admin
        GridPane layoutNonAdmin = new GridPane();
        layoutNonAdmin.setPadding(new Insets(10, 10, 10, 10));
        ChoiceBox<String> choiceBoxNA = new ChoiceBox<>();
        GridPane.setConstraints(choiceBoxNA,2,2);
        choiceBoxNA.getItems().addAll(TournamentController.listOfNames());
        Button viewButtonNA = new Button("View Torunament");
        viewButtonNA.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.setScene(turneu);
            	tournamentName.setText(choiceBoxNA.getValue());
            	TournamentController.findInListByName(choiceBoxNA.getValue());
                 player1.setText(TournamentController.toPrintInTB1());
                 player2.setText(TournamentController.toPrintInTB2());
                 player3.setText(TournamentController.toPrintInTB3());
                 player4.setText(TournamentController.toPrintInTB4());
                 player5.setText(TournamentController.toPrintInTB5());
                 player6.setText(TournamentController.toPrintInTB6());
                 player11.setText(TournamentController.toPrintInTB11());
                 player12.setText(TournamentController.toPrintInTB12());
                 player13.setText(TournamentController.toPrintInTB13());
                 player14.setText(TournamentController.toPrintInTB14());
                 
            }
        });
        GridPane.setConstraints(viewButtonNA,1,2);
        layoutNonAdmin.getChildren().addAll(viewButtonNA,choiceBoxNA);
        nonAdmin = new Scene(layoutNonAdmin, 300, 200); 
        //create tournament
        GridPane createtournamentl = new GridPane();
        createtournamentl.setPadding(new Insets(10, 10, 10, 10));
        createtournamentl.setVgap(8);
        createtournamentl.setHgap(10);
        createTournament = new Scene(createtournamentl, 250, 390);
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
        CreateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	TournamentController.setTournamnetName(namet.getText());
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(player1t.getText(),player2t.getText()));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(player3t.getText(),player4t.getText()));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(player5t.getText(),player6t.getText()));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(player7t.getText(),player8t.getText()));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(" "," "));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(" "," "));
            	TournamentController.addMatchToTournamnet(MatchController.createMatch(" "," "));
            	TournamentController.printMatchesId();
            	TournamentController.insertMatchesDB();
            	TournamentController.insertNameIntoDB();
            	TournamentController.InsertMatchesFK();
            	 choiceBox.getItems().addAll(TournamentController.listOfNames().get(TournamentController.listOfNames().size()-1));
            	 Alert alert = new Alert(AlertType.INFORMATION);
             	alert.setTitle("Success!");
             	alert.setHeaderText(null);
             	alert.setContentText("The Tournament was successfully created!");
             	alert.showAndWait();
            }
        });
        GridPane.setConstraints(CreateButton,2,10);
        Button BackButton = new Button("Back");
        BackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.setScene(admin);
            }
        });
        GridPane.setConstraints(BackButton,2,11);
        createtournamentl.getChildren().addAll(player1t,p1label,player2t,p2label,player3t,p3label,player4t,p4label,player5t,p5label,player6t,p6label,player7t,p7label,player8t,p8label,namet,namel,CreateButton,BackButton);      
        //create account scene
        GridPane layoutCreateAccount = new GridPane();
        layoutCreateAccount.setPadding(new Insets(10, 10, 10, 10));
        layoutCreateAccount.setVgap(8);
        layoutCreateAccount.setHgap(10);
        createAccountScene = new Scene(layoutCreateAccount, 300, 200);
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
        createAccountBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.setScene(admin);
            }
        });
        GridPane.setConstraints(createAccountBackButton,3,6);
        System.out.println("Aici1");
        Button createAccountInside = new Button("Create");
        createAccountInside.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	Boolean isAdminVar;
                if(isAdmin.isSelected())
                	{
                		isAdminVar=true;
                	}
                else isAdminVar=false;
            	PersonController.createAccount(name.getText(), email.getText(), password.getText(), isAdminVar);	
            	Alert alert = new Alert(AlertType.INFORMATION);
             	alert.setTitle("Success!");
             	alert.setHeaderText(null);
             	alert.setContentText("The Person was successfully created!");
             	alert.showAndWait();
            }
        });
        GridPane.setConstraints(createAccountInside,2,6);
        layoutCreateAccount.getChildren().addAll(name,nameLabel1,email,emailLabel,password,passwordLabel,isAdmin,isAdminLabel,createAccountInside,createAccountBackButton);    
        //delete Account Scene
        GridPane layoutUpdateAccount = new GridPane();
        layoutUpdateAccount.setPadding(new Insets(10, 10, 10, 10));
        layoutUpdateAccount.setVgap(8);
        layoutUpdateAccount.setHgap(10);
        updateAccountScene = new Scene(layoutUpdateAccount, 400, 250);
        TextField nameUpdate = new TextField();
        nameUpdate.setPrefSize(100, 30);
        GridPane.setConstraints(nameUpdate,3,2);
        TextField nameToUpdate = new TextField();
        nameToUpdate.setPrefSize(100, 30);
        GridPane.setConstraints(nameToUpdate,4,3);
        TextField emailUpdate = new TextField();
        emailUpdate.setPrefSize(100, 30);
        GridPane.setConstraints(emailUpdate,3,3);
        TextField passwordUpdate = new TextField();
        passwordUpdate.setPrefSize(100, 30);
        GridPane.setConstraints(passwordUpdate,3,4);
        CheckBox isAdminUpdate = new CheckBox();
        GridPane.setConstraints(isAdminUpdate,3,5);
        Label nameLabel1Update = new Label("Name: ");
        GridPane.setConstraints(nameLabel1Update,2,2);
        nameLabel1Update.setFont(new Font("Arial", 15));
        Label nameLabelToUpdate = new Label("Name to update/delete");
        GridPane.setConstraints(nameLabelToUpdate,4,2);
        nameLabelToUpdate.setFont(new Font("Arial", 15));
        Label emailLabelUpdate = new Label("E mail: ");
        GridPane.setConstraints(emailLabelUpdate,2,3);
        emailLabelUpdate.setFont(new Font("Arial", 15));
        Label passwordLabelUpdate = new Label("Password: ");
        GridPane.setConstraints(passwordLabelUpdate,2,4);
        passwordLabelUpdate.setFont(new Font("Arial", 15));
        Label isAdminLabelUpdate = new Label("Is Admin: ");
        GridPane.setConstraints(isAdminLabelUpdate,2,5);
        isAdminLabelUpdate.setFont(new Font("Arial", 15));
        Button updateAccountBackButton = new Button("Back");
        updateAccountBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	window.setScene(admin);
            }
        });
        GridPane.setConstraints(updateAccountBackButton,3,6);
        Button updateAccountInside = new Button("Update");
        updateAccountInside.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	Boolean isAdminVar;
                if(isAdminUpdate.isSelected())
                	{
                		isAdminVar=true;
                	}
                else isAdminVar=false;
            	PersonController.updateAccount(nameToUpdate.getText(), nameUpdate.getText(),emailUpdate.getText(), passwordUpdate.getText(), isAdminVar);	
            	Alert alert = new Alert(AlertType.INFORMATION);
             	alert.setTitle("Success!");
             	alert.setHeaderText(null);
             	alert.setContentText("The Person was successfully updated!");
             	alert.showAndWait();
            }
        });
        GridPane.setConstraints(updateAccountInside,2,6);
        Button deleteAccountInside = new Button("Delete");
        deleteAccountInside.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	PersonController.deleteAccount(nameToUpdate.getText());	
            	Alert alert = new Alert(AlertType.INFORMATION);
             	alert.setTitle("Success!");
             	alert.setHeaderText(null);
             	alert.setContentText("The Person was successfully deleted!");
             	alert.showAndWait();
            }
        });
        GridPane.setConstraints(deleteAccountInside,2,7);
        layoutUpdateAccount.getChildren().addAll(nameUpdate,nameToUpdate,nameLabel1Update,nameLabelToUpdate,emailUpdate,emailLabelUpdate,passwordUpdate,passwordLabelUpdate,isAdminUpdate,isAdminLabelUpdate,updateAccountInside,deleteAccountInside,updateAccountBackButton);    
        
       
}
}
