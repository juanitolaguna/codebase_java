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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Demonstrate Radio Buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 220, 120);
        myStage.setScene(myScene);
        response = new Label("");


        RadioButton rbTrain = new RadioButton("Train");
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbPlane = new RadioButton("Airplane");

        ToggleGroup tg = new ToggleGroup();

        rbTrain.setToggleGroup(tg);
        rbCar.setToggleGroup(tg);
        rbPlane.setToggleGroup(tg);

        // Handle action events for the radio buttons.
//        rbTrain.setOnAction(ae -> response.setText("Transport selected is train."));
//        rbCar.setOnAction(ae -> response.setText("Transport selected is car."));
//        rbPlane.setOnAction(ae -> response.setText("Transport selected is airplane."));


//        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal) {
//                RadioButton rb = (RadioButton) newVal;
//                response.setText("Transport selected is " + rb.getText());
//            }
//        });

        //to lambda

        tg.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            RadioButton rb = (RadioButton) newVal;
            response.setText("Transport selected is " + rb.getText());
        });


        rbTrain.fire();

        rootNode.getChildren().addAll(rbTrain, rbCar, rbPlane, response);

        myStage.show();


    }
}
