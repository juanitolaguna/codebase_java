package mandelbrot_hm;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created on 12.06.17.
 */
public class JavaFXMandelbrotSet extends Application {
    private static int canvasWidth = 800;
    private static int canvasHeight = 600;
    private static final int X_Offset = 100;
    private static final int Y_Offset = 50;

    private static double MANDELBROT_RE_MIN = -2;
    private static double MANDELBROT_RE_MAX = 1;
    private static double MANDELBROT_IM_MIN = -1;
    private static double MANDELBROT_IM_MAX = 1;

    @Override
    public void start(Stage primaryStage) {
        BorderPane fractalRootPane = new BorderPane();
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);

        // Move Canvas to Correct Position
        canvas.setLayoutX(X_Offset);
        canvas.setLayoutY(Y_Offset);

        fractalRootPane.getChildren().add(canvas);


    }

    private void paintSet(GraphicsContext ctx, double reMin, double reMax, double imMin, double imMax) {

        double precision = Math.max((reMax - reMin) / canvasWidth, (imMax - imMin) / canvasHeight);
        int convergenceStept = 50;
        for (double c = reMin, xR = 0; xR < canvasWidth; c = c+precision, xR++) {


        }

    }




}
