package pmp5;/**
 * Created on 11.06.17.
 */

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.awt.*;
import java.util.stream.IntStream;

public class DrawFractal extends Application {
    HBox hbox_control;
    VBox vbox_content;

    StringProperty stageTitle;
    double winWidth;
    double winHeight;
    Scene scene1, scene2;
    private WritableImage wiOffScreen;
    private WritableImage wiSnapshot;

    //canvas to show fractal
    private Canvas canvas;

    // snapshot of the whole fractalö
    private WritableImage wiGlobalSnapshot;
    private ImageView ivGlobalSnapshot;
//    private MandelBrotSetTask task;
    private boolean parallel;
    private double minR;
    private double maxR;
    private double minI;
    private double maxI;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        stageTitle = primaryStage.titleProperty();

        minR = -2.2;
        maxR = 1;
        minI = -1.4;
        maxI = 1.4;

        winWidth = 800.0;
        winHeight = 600.0;


//        scene1 = new Scene(createContent(minR, minI, maxR, maxI));


        //layout 1

        BorderPane border = new BorderPane();
        hbox_control = new HBox();
        hbox_control.setAlignment(Pos.CENTER);
        vbox_content = new VBox();
        border.setTop(hbox_control);
        border.setCenter(vbox_content);
//        vbox_content.getChildren().addAll(createContent(minR, minI, maxR, maxI));

        createContent(minR, minI, maxR, maxI);

        //Layout 1 Controls
        primaryStage.setScene(scene1);
        primaryStage.show();

        primaryStage.setTitle("Mandelbrot Set");
    }

    private void createContent(double minR, double minI, double maxR, double maxI) {
        wiOffScreen = new WritableImage((int) winWidth, (int) winHeight);
//        wiSnapshot = new WritableImage((int) winWidth, (int) winHeight);
        canvas = new Canvas(winWidth, winHeight);

//            wiGlobalSnapshot = new WritableImage(wiOffScreen.getPixelReader(), (int) winWidth, (int) winHeight);
//            ivGlobalSnapshot.setImage(wiGlobalSnapshot);
//
////            flyToPosition(minR, minI, maxR, maxI);

        PixelWriter pixelWriter = wiOffScreen.getPixelWriter();
        synchronized (pixelWriter) {
            // Prepares an image
            for (int x = 0; x < winWidth; x++) {
                for (int y = 0; y < winHeight; y++) {
                    pixelWriter.setColor(x, y, javafx.scene.paint.Color.BLUE);
                }
            }
        }


        parallel = true;

        IntStream yStream = IntStream.range(0, (int) winHeight);
        if (parallel) {
            yStream = yStream.parallel();
        } else {
            yStream = yStream.sequential();
        }

        yStream.forEach((int y) -> {
            // We do pixels in horizontal lines always sequentially
            for (int x = 0; x < winWidth; x++) {
                // Skip excluded rectangular area
//                if (!(x >= maxX || x < minX || y >= maxY || y < minY)) {
//                    continue;
//                }
                Color c;
                c = calcPixel(x, y);

                synchronized (pixelWriter) {
                    pixelWriter.setColor(x, y, c);
                }
            }
        });




        //Control
//        canvas.setOnScroll(t -> {
//            double x = t.getX();
//            double y = t.getY();
//            double scaleBase = t.isControlDown() ? 1.1 : t.isShiftDown() ? 10 : 2;
//            double byScale = (t.getDeltaY() > 0) ? 1 / scaleBase : scaleBase;
//            t.consume();
//        });
//        return  new Pane(canvas);
    }

    private Color calcPixel(int x, int y) {
        double re = (minR * (winWidth - x) + x * maxR) / winWidth;
        double im = (minI * (winHeight - y) + y * maxI) / winHeight;
        Complex calculatePixel = new Complex(re, im);
        return getColor(calc(calculatePixel));
    }

    static final Color[] colors = new Color[256];

    private Color getColor(int count) {
        if (count >= colors.length) {
            return Color.BLUE;
        }
        return colors[count];
    }

    private static int calc(Complex comp) {
        int count = 0;
        Complex c = new Complex(0, 0);
        do {
            c.times(c).plus(comp);
        } while (count < 256 && c.lengthSQ() < 6d);
        // track...
        System.out.println("count in calc() = " + count);
        return count;
    }

    private void render() {
        //TODO

    }


    private void createControlPane() {
        Label dummy = new Label("This is a dummy");
        ObservableList<String> sets = FXCollections.observableArrayList("Mandelbrot Set", "Julia Set");
        ComboBox<String> cb_changeSet = new ComboBox(sets);
        cb_changeSet.setOnAction(ae -> dummy.setText("Display" + cb_changeSet.getValue()));
        hbox_control.getChildren().addAll(dummy, cb_changeSet);

    }


}
