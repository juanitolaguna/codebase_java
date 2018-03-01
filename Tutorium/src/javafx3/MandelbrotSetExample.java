package javafx3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created on 21.06.17.
 */
public class MandelbrotSetExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mandelbrot iSet Example");
        primaryStage.setScene(makeScene());
        primaryStage.show();

    }

    private Scene makeScene() {
        WritableImage mandelbrotSet = new WritableImage(840, 480);
        populateMandelbrotSet(mandelbrotSet);
        Canvas canvas = new Canvas(840, 480);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(mandelbrotSet, 0, 0);
        BorderPane border = new BorderPane();
        border.getChildren().add(canvas);
        // Create operator
        AnimatedZoomOperator zoomOperator = new AnimatedZoomOperator();

        // Listen to scroll events (similarly you could listen to a button click, slider, ...)
        border.setOnScroll(event -> {
            double zoomFactor = 2.0;
            if (event.getDeltaY() <= 0) {
                // zoom out
                zoomFactor = 1 / zoomFactor;
            }
            zoomOperator.zoom(border, zoomFactor, event.getSceneX(), event.getSceneY());
        });


        Scene scene = new Scene(border, 1000, 600);
        return scene;


    }

    private void populateMandelbrotSet(WritableImage mandelbrotSet) {
        final PixelWriter pixelWriter = mandelbrotSet.getPixelWriter();
        for (int i = 0; i < 840; i++) {
            for (int j = 0; j < 480; j++) {
                double x = (i - 600) / 240.0d;
                double y = (240 - j) / 240.0d;
//                System.out.println("x = " + x);
//                System.out.println("y = " + y);
                Color color = calc(x, y);
//                System.out.println("argb = " + color);
                pixelWriter.setColor(i, j, color);
            }

        }
    }

//    private Color calculateColor(double x0, double y0) {
//        double x = 0.0;
//        double y = 0.0;
//        int iteration = 0;
//        int max_iteration = 100;
//
//        while (x * x + y * y < 2 * 2 && iteration < max_iteration) {
//            double xtemp = x * x - y * y + x0;
//            y = 2 * x * y + y0;
//            x = xtemp;
//            iteration++;
//        }
//        double r = (iteration % 10) / 10.0d;
//        double g = ((iteration / 10) % 10) / 10.0d;
//        double b = ((iteration / 100) % 10) / 10.0d;
//        return Color.color(r, g, b);
//
//    }

    private Color calc(double x, double y) {
        int max_iteration = 256;
        Complex comp = new Complex(x, y);
        Complex c = new Complex(-0.70176, -0.3842);

        int count = 0;

        do {
            comp.times(comp).plus(c);
            count++;
        } while (comp.lengthSQ() < 6d && count < max_iteration);
        Color color = getColor(count);
        return color;

//        double r = (count % 10) / 10.0d;
//        double g = ((count / 10) % 10) / 10.0d;
//        double b = ((count / 100) % 10) / 10.0d;
//        return Color.color(r, g, b);
    }


    //TODO analyze coloring system

    private Color getColor(int count) {
        if (count >= colors.length) {
            return Color.BLACK;
        }
        return colors[count];
    }

    private static final Color[] colors = new Color[256];

    static {

        /**
         * Color stops for colors table: color values
         */
        Color[] cc = {
                Color.rgb(40, 0, 0),
                Color.RED,
                Color.WHITE,
                Color.RED,
                Color.rgb(100, 0, 0),
                Color.RED,
                Color.rgb(50, 0, 0)
        };

        /**
         * Color stops for colors table: relative position in the table
         */
        double[] cp = {
                0, 0.17, 0.25, 0.30, 0.5, 0.75, 1,};

        /**
         * Color table population
         */
        int j = 0;
        for (int i = 0; i < colors.length; i++) {
            double p = (double) i / (colors.length - 1);
            if (p > cp[j + 1]) {
                j++;
            }
            double val = (p - cp[j]) / (cp[j + 1] - cp[j]);
            colors[i] = cc[j].interpolate(cc[j + 1], val);
        }
    }


}
