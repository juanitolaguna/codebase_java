package javafx2;/**
 * Created on 07.06.17.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXEventDemo extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //give the stage a title
        primaryStage.setTitle("Demonstrate JavaFX Buttons and Events.");

        // Create a root node. In this case, a flow layout pane
        // is used, but several alternatives exist.

        FlowPane rootNode = new FlowPane(10, 10);

        //center the Controls in the scene
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 200);

        //set the scene on the sta  ge
        primaryStage.setScene(myScene);

        //create Label
        response = new Label("push a button");

        //create two push Buttons
        Button btnAlpha = new Button("Alpha");
        Button btnBeta = new Button("Beta");
        Button scene = new Button("resize");

        //Handle the action events for the alpha Button
        btnAlpha.setOnAction((ae) -> response.setText("AlphaButton Pressed!"));
        btnBeta.setOnAction((ae) -> response.setText("BetaButton Pressed!"));
        scene.setOnAction((ae) -> {
            if (primaryStage.getHeight() < 500) {
                primaryStage.setHeight(500);
                primaryStage.setWidth(500);
            } else {
                primaryStage.setHeight(200);
                primaryStage.setWidth(200);
            }});




        //add Label
        rootNode.getChildren().addAll(btnAlpha, btnBeta, response, scene );


        //show the stage and its scene
        primaryStage.show();

    }
}
