package javafx3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;


public class UseZoomOperator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Create panel
        StackPane zoomPane = new StackPane();
        zoomPane.getChildren().add(new Circle(100, 100, 10));
        zoomPane.getChildren().add(new Circle(200, 200, 20));

        // Create operator
        AnimatedZoomOperator zoomOperator = new AnimatedZoomOperator();

        // Listen to scroll events (similarly you could listen to a button click, slider, ...)
        zoomPane.setOnScroll(event -> {
            double zoomFactor = 1.5;
            if (event.getDeltaY() <= 0) {
                // zoom out
                zoomFactor = 1 / zoomFactor;
            }
            zoomOperator.zoom(zoomPane, zoomFactor, event.getSceneX(), event.getSceneY());
        });
        Scene scene = new Scene(zoomPane, 600,600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}