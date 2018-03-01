package javafx;/**
 * Created on 22.05.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SceneBuild extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        //add leafnode
        Circle cr = new Circle(200, 200, 100);
        cr.setFill(Color.CORAL);
        root.getChildren().add(cr);


        Scene scene = new Scene(root,400, 400);
        primaryStage.setTitle("Scene graph Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
