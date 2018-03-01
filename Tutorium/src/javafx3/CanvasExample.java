package javafx3;/**
 * Created on 21.06.17.
 */

import com.sun.javafx.geom.Point2D;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CanvasExample extends Application {
    private Point2D p0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Canvas Example");
        primaryStage.setScene(makeScene());
        primaryStage.show();
    }

    private Scene makeScene() {
        Canvas canvas = new Canvas(640, 480);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.setStroke(Color.RED);
        graphicsContext.setFont(Font.font(14));
        graphicsContext.strokeText("Click and drag mouse to draw ovals", 20, 20);

        canvas.setOnMousePressed((event) -> {
            graphicsContext.clearRect(0, 0, 640, 480);
            p0 = new Point2D((float) event.getX(), (float) event.getY());
        });

        canvas.setOnMouseDragged(event -> {
            Point2D p1 = new Point2D((float) event.getX(), (float) event.getY());
            graphicsContext.clearRect(0, 0, 640, 480);
            float x = Math.min(p0.x , p1.y);
            double y = Math.min(p0.x, p1.y);
            double width = Math.abs(p1.x - p0.y);
            double height = Math.abs(p1.x - p0.y);
            graphicsContext.fillOval(x, y, width, height);
            graphicsContext.strokeText("Oval(" + x + ", " + y + ", " + width + ", " + height + ")", x, y - 10);

        });

        canvas.setOnZoom(ae -> {

        });

        Group group = new Group(canvas);
        return new Scene(group, 640, 480);
    }


}
