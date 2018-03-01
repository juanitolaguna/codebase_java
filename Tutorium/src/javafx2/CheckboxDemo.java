package javafx2;/**
 * Created on 08.06.17.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class CheckboxDemo extends Application {

    CheckBox cbWeb;
    CheckBox cbDesktop;
    CheckBox cbMobile;

    Label response;
    Label allTargets;

    String targets = "";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Demaonstrate Checkboxes");

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 230, 140);
        primaryStage.setScene(myScene);

        Label heading = new Label("Select Deployment Options");

        response = new Label("No Deploymetn Selected");

        // Create a label that will report all targets selected.
        allTargets = new Label("Target List: <none>");

        cbWeb = new CheckBox("Web");
        cbDesktop = new CheckBox("Desktop");
        cbMobile = new CheckBox("Mobile");


        cbWeb.setAllowIndeterminate(true);
        cbDesktop.setAllowIndeterminate(true);
        cbMobile.setAllowIndeterminate(true);

        cbWeb.setOnAction(ae -> {
            if (cbWeb.isIndeterminate()) {
                response.setText("Web deployment Indeterminate");
            } else if (cbWeb.isSelected()) {
                response.setText("Web deployment selected.");
            } else {
                response.setText("Web deployment cleared.");
            }
            showAll();
        });

        cbDesktop.setOnAction(ae -> {
            if (cbDesktop.isIndeterminate()) {
                response.setText("Desktop deployment Indeterminate");
            } else if (cbDesktop.isSelected()) {
                response.setText("Desktop deployment selected.");
            } else {
                response.setText("Desktop deployment cleared.");
            }
            showAll();
        });

        cbMobile.setOnAction(ae -> {
            if (cbMobile.isIndeterminate()) {
                response.setText("Mobile deployment Indeterminate");
            } else if (cbMobile.isSelected()) {
                response.setText("Mobile deployment selected.");
            } else {
                response.setText("Mobile deployment cleared.");
            }
            showAll();
        });

        Separator separator = new Separator();
        separator.setPrefWidth(200);

        rootNode.getChildren().addAll(heading, separator, cbWeb, cbDesktop, cbMobile, response, allTargets);
        primaryStage.show();
    }

    void showAll() {
        targets = "";
        if (cbWeb.isSelected()) targets = "Web ";
        if (cbDesktop.isSelected()) targets += "Desktop ";
        if (cbMobile.isSelected()) targets += "Mobile ";
        if (targets.equals("")) targets = "<none>";
        allTargets.setText("Target List: " + targets);
    }

}
