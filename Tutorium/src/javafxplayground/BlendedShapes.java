package javafxplayground;/**
 * Created on 31.05.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BlendedShapes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        StackPane pane = new StackPane();
        Button btn = new Button();
        pane.getChildren().add(btn);

        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
