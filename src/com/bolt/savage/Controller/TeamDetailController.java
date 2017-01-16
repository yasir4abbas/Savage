package com.bolt.savage.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import com.bolt.savage.Model.Team;
import com.bolt.savage.View.UI.Main;

/**
 * Created by Hussein Muzafar on 25/12/2016.
 */
public class TeamDetailController {

    @FXML
    private Label teamName;

    @FXML
    private ImageView teamFlag;

    @FXML
    private Text description;
    @FXML
    private Label captain;
    @FXML
    private Label coach;
    @FXML
    private Label loc;
    @FXML
    private Label stadium;

    @FXML
    private ListView players;

    public void initialize() {
    }

    @FXML
    public void backAction() {
        Main.theStage.show();
    }



    void setTeam(Team team) {
        teamName.setText(team.name);

        Image image = new Image("resource/" + team.flag);
        teamFlag.setImage(image);

        description.setText("The Australian national team represents the country" +
                "of australia in international cricket.");

        captain.setText("Steve Smith");
        coach.setText(team.coach);
        loc.setText("Australia");
        stadium.setText(team.stadiums);

        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Steven Smith");

        players.setItems(list);

    }
}
