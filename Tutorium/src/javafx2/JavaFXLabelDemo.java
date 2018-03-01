package javafx2;/**
 * Created on 07.06.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXLabelDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //give the stage a title
        primaryStage.setTitle("JavaFX LabelDemo");

        // Create a root node. In this case, a flow layout pane
        // is used, but several alternatives exist.

        FlowPane rootNode = new FlowPane();

        //set the scene on the stage
            primaryStage.setScene(new Scene(rootNode, 300, 200));

        //create Label
        Label label = new Label("This is a JavaFX Label!       ");

        //add Label
        rootNode.getChildren().add(label);
        rootNode.getChildren().add(new Label("Another Label"));

        //show the stage and its scene
        primaryStage.show();

    }
}
