package javafx2;/**
 * Created on 07.06.17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXScel extends Application {

    public static void main(String[] args) {
        System.out.println("Launching JavaFx Application");
        launch(args);
    }

    //Override the init method
    public void init() {
        System.out.println("inside the init() method");

    }


    @Override
    public void start(Stage primaryStage) {
        System.out.println("Inside the start() method");

        //give the stage a title
        primaryStage.setTitle("JavaFX Sceleton");

        // Create a root node. In this case, a flow layout pane
        // is used, but several alternatives exist.

        FlowPane rootNode = new FlowPane();

        //create a scene
        Scene myScene = new Scene(rootNode, 300, 200);

        //set the scene on the stage
        primaryStage.setScene(myScene);

        //show the stage and its scene
        primaryStage.show();
    }

    //override the stop() method
    public void stop() {
        System.out.println("Inside the stop() method");
    }

    //you will need to override the init( ) and stop( ) methods only
    // if your application must perform special startup or shutdown actions.

}
