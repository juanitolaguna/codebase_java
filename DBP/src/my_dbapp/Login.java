package my_dbapp;/**
 * Created on 22.05.17.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Login extends Application {
    String path = "jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14";
    Connection connection;
    Statement stmt;
    ResultSet rset;

    TableView table;
    ComboBox<String> tabellen;
    ObservableList<ObservableList> data;

    Scene scene1, scene2;
    private boolean loggedIn;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws SQLException {


        //Login Window
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        scene1 = new Scene(grid, 300, 275);

        Text scene1title = new Text("JavaFX loginForm");
        scene1title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Label userName = new Label("User Name: ");
        TextField userTextfield = new TextField();
        Label pw = new Label("Password: ");
        PasswordField pwBox = new PasswordField();

        grid.add(scene1title, 0, 0, 2, 1);
        grid.add(userName, 0, 1);
        grid.add(userTextfield, 1, 1);
        grid.add(pw, 0, 2);
        grid.add(pwBox, 1, 2);

        grid.setGridLinesVisible(false);

        Button btn = new Button("Sign in");
        HBox hbbtn = new HBox(10);
        hbbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbbtn.getChildren().add(btn);
        grid.add(hbbtn, 1, 4);

        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        // Login Button

        btn.setOnAction(event -> {
            changeScene(primaryStage, userTextfield, pwBox, actiontarget);
        });


        // Layout 2
        BorderPane border = new BorderPane();

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        border.setTop(hbox);
        border.setCenter(vbox);
        table = new TableView<>();
        tabellen = new ComboBox<>();
        hbox.getChildren().add(tabellen);
        vbox.getChildren().add(table);

        //Dropdown
        tabellen.setOnAction(ae -> {

            try {
                getTable(tabellen.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        //table set....

        scene2 = new Scene(border, 800, 400);


        scene1.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.setTitle("JavaFX Login Form");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void getTable(String value) throws SQLException {
        ResultSet rset = stmt.executeQuery("SELECT * FROM " + value);
        printTable(rset);


    }

    private void printTable(ResultSet rset) throws SQLException {
        table.getColumns().clear();
        ResultSetMetaData rsetMeta = rset.getMetaData();
        int numberOfColumns = rsetMeta.getColumnCount();
        List<TableColumn> columnList = new ArrayList<>();
        for (int i = 1; i <= numberOfColumns; i++) {
            final int j = i;
            TableColumn col = new TableColumn(rsetMeta.getColumnName(i));
            col.setMinWidth(100);
            col.setCellValueFactory(cell -> new SimpleStringProperty());
            columnList.add(col);
        }

        for (TableColumn tc : columnList) {
            table.getColumns().add(tc);
        }


        //unklar!

        data = FXCollections.observableArrayList();
//        List<TableRow> rows = new ArrayList<>();
        while (rset.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= numberOfColumns; i++) {
//                TableCell tableCell = new TableCell();
//                tableCell.setText(rset.getString(i));
//                row.add(tableCell);
                row.add(rset.getString(i));
//                row.add(rset.getString(i));
               System.out.println(rset.getString(i));

            }
            data.add(row);
//            table.getItems().add();
//           data.add(tableRows);
//           table.setItems(data);

        }
            table.setItems(data);




    }


    public void getTableDropDown() throws SQLException {
        stmt = connection.createStatement();
        rset = stmt.executeQuery("SELECT TABLE_NAME FROM user_tables");
        ResultSetMetaData rsetMeta = rset.getMetaData();
        int numberOfColumns = rsetMeta.getColumnCount();

        while (rset.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                tabellen.getItems().add(rset.getString(i));
            }

        }
    }


    private void changeScene(Stage primaryStage, TextField userTextfield, PasswordField pwBox, Text actiontarget) {
        loggedIn = login(path, userTextfield.getText(), pwBox.getText());
        if (loggedIn) {
            primaryStage.setScene(scene2);
        } else actiontarget.setText("Versuchen sie es nochmal!");

        try {
            getTableDropDown();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean login(String path, String user, String password) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(path, user, password);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }


}
