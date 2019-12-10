/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awa.pkg4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author etudiant
 */
public class AWA4 extends Application {
 
	String login = "administrateur";
	String mdp = "azerty";
	String checkLogin, checkMdp;
	

     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion");
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
       
        Label lblUserName = new Label("Identifiant");
        final TextField txtLogin = new TextField();
        Label lblPassword = new Label("Mot de passe");
        final PasswordField motDePasse = new PasswordField();
        Button btnLogin = new Button("Se connecter");
        final Label lblMessage = new Label();
        
        
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtLogin, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(motDePasse, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);
        
        


        

        Text text = new Text("Connexion");
        text.setFont(Font.font ("Verdana", 30));

        

        hb.getChildren().add(text);
                          

        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");
                
 
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		checkLogin = txtLogin.getText().toString();
        		checkMdp = motDePasse.getText().toString();
        		if(checkLogin.equals(login) && checkMdp.equals(mdp)){
        			lblMessage.setText("Vous êtes connectés!");
        			lblMessage.setTextFill(Color.GREEN);
                                Alert dlgNok = new Alert (Alert.AlertType.INFORMATION  );
                                dlgNok.setTitle( "Connecté" );
                                dlgNok.setHeaderText("C'est Bon ");
                                dlgNok.setContentText("Vous êtes connectés ! ");
                              
                                dlgNok.showAndWait();
        		}
        		else{
                                Alert dlgNok = new Alert (Alert.AlertType.ERROR );
                                dlgNok.setTitle( "Authentification" );
                                dlgNok.setHeaderText("Echec  l'authentification");
                                dlgNok.setContentText("Nom de connexion ou mot de passe incorect ! ");
                                dlgNok.showAndWait();
        		}
        		txtLogin.setText("");
        		motDePasse.setText("");
        	}
        	});
       

        bp.setTop(hb);
        bp.setCenter(gridPane);  
        

    	Scene scene = new Scene(bp);

    	primaryStage.setScene(scene);
    	primaryStage.setResizable(false);
    	primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
