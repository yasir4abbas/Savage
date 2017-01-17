package com.bolt.savage.Controller;

import com.bolt.savage.Model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class PlayerDetailController {


    @FXML
    private ImageView playerImage;

    @FXML
    private ListView battingDetails;

    @FXML
    private Label name;

    ObservableList<String> battingStats;

    public void initialize() {
        name.setText("Hisham");

        battingStats = FXCollections.observableArrayList();
        battingStats.add("Ali");
        battingStats.add("Salman");
        battingStats.add("Taimoor");
        battingStats.add("Inzemam");

        battingDetails.setItems(battingStats);

    }

    public void setPlayer(Player player) {

    }
}
