package JuliaSet;
/**
 * Created on 22.06.17.
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private double winWidth;
    private double winHeight;
    private Position position;
    private WritableImage wiOffscreen;
    private WritableImage wiSnapshot;
    private Canvas canvas;
    private JuliaSetTask task;
    private Complex fConstant = new Complex(-0.4, 0.6);
    private final SnapshotParameters snapshotParameters = new SnapshotParameters();

    private double gestureX = 0;
    private double gestureY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        double minR = -1.5;
        double maxR = 1.5;
        double minI = -1.5;
        double maxI = 1.5;
        winWidth = 800.0;
        winHeight = 600.0;
        setPosition(minR, minI, maxR, maxI);

        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private void setPosition(double minR, double minI, double maxR, double maxI) {
        position = new Position(minR, minI, maxR, maxI);
    }

    private Parent createControlPane() {
        ObservableList<Complex> listOfConstants = FXCollections.observableArrayList(
                new Complex(-0.4, 0.6),
                new Complex(0.285, 0),
                new Complex(0.285, 0.01),
                new Complex(0.45, 0.1428),
                new Complex(-0.70176, -0.3842),
                new Complex(-0.835, -0.2321),
                new Complex(-0.8, 0.156),
                new Complex(-0.7269, 0.1889),
                new Complex(0, -0.8)
        );


        ComboBox<Complex> comboBox = new ComboBox(listOfConstants);
        comboBox.setPromptText("Choose a Constant:");

        comboBox.setOnAction(ae -> {
            fConstant = comboBox.getValue();
            render(fConstant);
            handleFrame();

        });

        Label label1 = new Label("Re:");
        label1.setTextFill(Color.WHITE);

        TextField textFieldRe = new TextField();
        textFieldRe.setPrefWidth(50);
        textFieldRe.textProperty().addListener((observable, oldvalue, newvalue) ->
                fConstant.setRe(Double.valueOf(newvalue)));

        Label label2 = new Label("Im:");
        label2.setTextFill(Color.WHITE);


        TextField textFieldIm = new TextField();
        textFieldIm.setPrefWidth(50);

        Button button = new Button();
        button.setText("Set new constant");

        button.setOnAction(ae -> {
            double re = Double.valueOf(textFieldRe.getText());
            double im = Double.valueOf(textFieldIm.getText());
            if (re != 0 && im != 0) {
                fConstant.setRe(re);
                fConstant.setIm(im);
                render(fConstant);
            }
        });


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        int rowIndex = 0;
        int colIndex = 0;
        grid.add(comboBox, colIndex++, rowIndex, 1, 2);
        grid.add(label1, colIndex++, rowIndex, 1, 2);
        grid.add(textFieldRe, colIndex++, rowIndex, 1, 2);
        grid.add(label2, colIndex++, rowIndex, 1, 2);
        grid.add(textFieldIm, colIndex++, rowIndex, 1, 2);
        grid.add(button, colIndex++, rowIndex, 1, 2);
        return grid;
    }

    private Parent createContent() {
        Parent controlPane = createControlPane();

        wiOffscreen = new WritableImage((int) winWidth, (int) winHeight);
        wiSnapshot = new WritableImage((int) winWidth, (int) winHeight);
        canvas = new Canvas(winWidth, winHeight);
        render(fConstant);


        canvas.setOnScroll(ae -> {
            double x = ae.getX();
            double y = ae.getY();
            double scaleBase = ae.isControlDown() ? 1.1 : 1.5;
            double byScale = (ae.getDeltaY() > 0) ? 1 / scaleBase : scaleBase;
            handleContentZoomed(x, y, byScale);
            ae.consume();
        });

        // Fetch position when Mouse pressed
        canvas.setOnMousePressed(ae -> {
            gestureX = ae.getSceneX();
            gestureY = ae.getSceneY();
        });

        canvas.setOnMouseDragged(ae -> {
            canvas.setTranslateX(ae.getSceneX() - gestureX);
            canvas.setTranslateY(ae.getSceneY() - gestureY);
        });

        // Fetch position when Mouse released
        canvas.setOnMouseReleased(ae -> {
            double moveX = Math.min(Math.max(ae.getSceneX() - gestureX, -winWidth), winWidth * 2);
            double moveY = Math.min(Math.max(ae.getSceneY() - gestureY, -winHeight), winHeight * 2);
            // Only redraw when there is a movement
            if (moveX != 0 || moveY != 0) {
                handleContentMoved(moveX, moveY);
            }
            ae.consume();
        });


        BorderPane border = new BorderPane();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(controlPane);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(canvas);

        border.setCenter(vBox);
        border.setTop(hBox);
        border.setStyle("-fx-background: Black;");

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                handleFrame();
            }

        }.start();
        return border;
    }

    private void render(Complex constant) {
        task = new JuliaSetTask(wiOffscreen.getPixelWriter(), (int) winWidth, (int) winHeight,
                position.getMinReal(), position.getMinImg(), position.getMaxReal(), position.getMaxImg(), constant);

        new Thread(task, "Task to render JuliaSet").start();
    }

    private void handleFrame() {
        if (task != null) {
            if (!task.isCancelled() && task.hasUpdates()) {
                task.clearHasUpdates();
                canvas.getGraphicsContext2D().drawImage(wiOffscreen, 0, 0, wiOffscreen.getWidth(),
                        wiOffscreen.getHeight(), 0, 0, winWidth, winHeight);
            }
//
            if (task.isDone()) {
                task = null;
            }
        }

    }

    private void handleContentZoomed(final double x, final double y, final double byScale) {
        //x = ae.gerX, y = ae.getY

        stopTask();

        // relative position (real,img) +- scale * (winWidth/height)/2
        // scale is the midpoint?
        double oldMinR = position.getMinReal();
        double oldMinI = position.getMinImg();
        double oldMaxR = position.getMaxReal();
        double oldMaxI = position.getMaxImg();
        double oldScale = position.scale;


        //get the zoom center
        double zoomCenterReal = position.real + (x - winWidth / 2) * position.scale;
        double zoomCenterImg = position.img + (y - winHeight / 2) * position.scale;


        double newScale = oldScale * byScale;
        double newMinR = zoomCenterReal - x * newScale;
        double newMinI = zoomCenterImg - y * newScale;
        double newMaxR = newMinR + newScale * winWidth;
        double newMaxI = newMinI + newScale * winHeight;
        setPosition(newMinR, newMinI, newMaxR, newMaxI);

        canvas.snapshot(snapshotParameters, wiSnapshot);

        double minR = Math.max(position.getMinReal(), oldMinR);
        double minI = Math.max(position.getMinImg(), oldMinI);
        double maxR = Math.min(position.getMaxReal(), oldMaxR);
        double maxI = Math.min(position.getMaxImg(), oldMaxI);

        // x = (re - minR) / scale
        double sx = Math.max(0, (minR - oldMinR) / oldScale);
        double sy = Math.max(0, (minI - oldMinI) / oldScale);
        double sw = Math.min(winWidth, (maxR - oldMinR) / oldScale) - sx;
        double sh = Math.min(winHeight, (maxI - oldMinI) / oldScale) - sy;
        double dx = Math.max(0, (minR - newMinR) / newScale);
        double dy = Math.max(0, (minI - newMinI) / newScale);
        double dw = Math.min(winWidth, (maxR - newMinR) / newScale) - dx;
        double dh = Math.min(winHeight, (maxI - newMinI) / newScale) - dy;

        canvas.getGraphicsContext2D().clearRect(0, 0, winWidth, winHeight);
        canvas.getGraphicsContext2D().drawImage(wiSnapshot, sx, sy, sw, sh, dx, dy, dw, dh);
        render(fConstant);
    }

    private void handleContentMoved(double moveX, double moveY) {
        stopTask();

        double realMove = position.scale * moveX;
        double imgMove = position.scale * moveY;
        position.real -= realMove;
        position.img -= imgMove;
        double sx = Math.max(0, -moveX);
        double sy = Math.max(0, -moveY);
        double sw = Math.min(winWidth, -moveX + winWidth) - sx;
        double sh = Math.min(winHeight, -moveY + winHeight) - sy;
        double dx = Math.max(0, moveX);
        double dy = Math.max(0, moveY);
        canvas.snapshot(snapshotParameters, wiSnapshot);
        canvas.getGraphicsContext2D().clearRect(0, 0, winWidth, winHeight);
        canvas.getGraphicsContext2D().drawImage(wiSnapshot, sx, sy, sw, sh, dx, dy, sw, sh);
        canvas.setTranslateX(0);
        canvas.setTranslateY(0);
        render(fConstant);
    }


    private boolean stopTask() {
        if (task != null) {
            task.cancel();
            boolean cancelled = task.isCancelled() || task.getState() == Worker.State.READY;
            task = null;
            return cancelled;
        }
        return false;
    }


    private class Position {
        double real, img;
        double scale;

        public Position(double minR, double minI, double maxR, double maxI) {
            real = (minR + maxR) / 2;
            img = (minI + maxI) / 2;
            double scaleR = (maxR - minR) / winWidth;
            double scaleI = (maxI - minI) / winHeight;
            scale = Math.max(scaleR, scaleI);
        }

        private double getMinReal() {
            return real - scale * winWidth / 2;
        }

        private double getMaxReal() {
            return real + scale * winWidth / 2;
        }

        private double getMinImg() {
            return img - scale * winHeight / 2;
        }

        private double getMaxImg() {
            return img + scale * winHeight / 2;
        }


        @Override
        public int hashCode() {
            int hash = 5;
            hash = 59 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
            hash = 59 * hash + (int) (Double.doubleToLongBits(this.img) ^ (Double.doubleToLongBits(this.img) >>> 32));
            hash = 59 * hash
                    + (int) (Double.doubleToLongBits(this.scale) ^ (Double.doubleToLongBits(this.scale) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Position other = (Position) obj;
            if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
                return false;
            }
            if (Double.doubleToLongBits(this.img) != Double.doubleToLongBits(other.img)) {
                return false;
            }
            if (Double.doubleToLongBits(this.scale) != Double.doubleToLongBits(other.scale)) {
                return false;
            }
            return true;
        }
    }
}
