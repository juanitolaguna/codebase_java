package JuliaSet;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    final int width = 500;
    final int height = 500;

    double startScale = 200;
    double scale = 200;

    int dragIterations = 50;
    int maxIterations = 256;

    double gestureX, gestureY;

    double offsetX = 0;
    double offsetY = 0;

    PixelWriter pixelWriter;
    WritableImage writableImage;
    ImageView imageView;

    Complex c = new Complex(0.3, 0.5);

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        writableImage = new WritableImage(width, height);
        imageView = new ImageView();
        render(maxIterations);

        Group root = new Group();
        root.getChildren().add(imageView);

        root.setOnScroll(t -> {
            scale += (t.getDeltaY() / 40) * (scale * 0.1f);
            render(maxIterations);
            t.consume();
        });

        root.setOnMousePressed(e -> {
            gestureX = e.getSceneX();
            gestureY = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            offsetX += ((e.getSceneX() - gestureX) / scale) * 100;
            offsetY += ((e.getSceneY() - gestureY) / scale) * 100;
            gestureX = e.getSceneX();
            gestureY = e.getSceneY();
            render(dragIterations);
        });

        root.setOnMouseReleased(e -> {
            render(maxIterations);
        });

        Label label1 = new Label("Re:");
        label1.setTextFill(Color.WHITE);
        TextField textField = new TextField();
        textField.setPrefWidth(40);
        textField.setText(String.valueOf(c.a));
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            c.a = Double.valueOf(newValue);
            render(maxIterations);
        });

        Label label2 = new Label("Im:");
        label2.setTextFill(Color.WHITE);
        TextField textField2 = new TextField();
        textField2.setPrefWidth(40);
        textField2.setText(String.valueOf(c.b));
        textField2.textProperty().addListener((observable, oldValue, newValue) -> {
            c.b = Float.valueOf(newValue);
            render(maxIterations);
        });

        Label label3 = new Label("MaxIterations:");
        label3.setTextFill(Color.WHITE);
        TextField textField3 = new TextField();
        textField3.setPrefWidth(40);
        textField3.setText(String.valueOf(maxIterations));
        textField3.textProperty().addListener((observable, oldValue, newValue) -> {
            maxIterations = Integer.valueOf(newValue);
            render(maxIterations);
        });

        Label label4 = new Label("DragIterations:");
        label4.setTextFill(Color.WHITE);
        TextField textField4 = new TextField();
        textField4.setPrefWidth(40);
        textField4.setText(String.valueOf(dragIterations));
        textField4.textProperty().addListener((observable, oldValue, newValue) -> {
            dragIterations = Integer.valueOf(newValue);
            render(dragIterations);
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, label2, textField2, label3, textField3, label4, textField4);
        hb.setSpacing(10);
        root.getChildren().add(hb);

        Scene scene = new Scene(root, width, height, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void render(int iterations) {
        pixelWriter = writableImage.getPixelWriter();

        double h = height / 2;
        double w = width / 2;

        JuliaSet.c = c;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double my = (double) (((y - h) - offsetY * scale / startScale) / scale);
                double mx = (double) (((x - w) - offsetX * scale / startScale) / scale);
                double result = JuliaSet.calc(mx, my, iterations);
                if (result == -1) pixelWriter.setColor(x, y, Color.BLACK);
                else {
                    double hue = (result * 10) % 360;
                    pixelWriter.setColor(x, y, Color.hsb(hue, 0.8, 0.5, 1));
                }
            }
        }

        imageView.setImage(writableImage);
    }

}
