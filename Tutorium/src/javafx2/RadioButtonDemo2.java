package javafx2;/**
 * Created on 08.06.17.
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo2 extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Demonstrate Radio Buttons");
        FlowPane rootNode = new FlowPane(10, 10);

        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 240, 160);
        myStage.setScene(myScene);

        //create two labels
        Label choose = new Label("Select a Transport Type");
        response = new Label("No transport confirmed");

        Button btnConfirm = new Button("Confirm Transport Selection");


        RadioButton rbTrain = new RadioButton("Train");
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbPlane = new RadioButton("Airplane");

        ToggleGroup tg = new ToggleGroup();

        rbTrain.setToggleGroup(tg);
        rbCar.setToggleGroup(tg);
        rbPlane.setToggleGroup(tg);

        rbTrain.setSelected(true);

        btnConfirm.setOnAction(ae -> {
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            response.setText(rb.getText() + " is confirmed.");
        });

        // Use a separator to better organize the layout.
        Separator separator = new Separator();
        separator.setPrefWidth(180);


        rootNode.getChildren().addAll(choose, rbTrain, rbCar, rbPlane, separator, btnConfirm, response);

        myStage.show();


    }
}
