package com.bolt.savage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage theStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/bolt/savage/View/FXML/MainView.fxml"));
        theStage = primaryStage;
        primaryStage.setTitle("Savage");
        primaryStage.setScene(new Scene(root, 500, 700));
        primaryStage.show();
    }


    public static void main(String[] cheese) throws ClassNotFoundException {
        launch(cheese);
        Class.forName("com.mysql.jdbc.Driver");
    }
}
