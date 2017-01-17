package com.bolt.savage.Controller;

import com.bolt.savage.Model.DatabaseHelper;
import com.bolt.savage.Model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import com.bolt.savage.Model.Team;
import com.bolt.savage.View.UI.Main;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Hussein Muzafar on 25/12/2016.
 */
public class TeamDetailController implements EventHandler<MouseEvent> {

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

    private ObservableList<Player> playerList;

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

        players.setOnMouseClicked(this);
        playerList = FXCollections.observableArrayList();

        try {
            testConnection(team.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        players.setItems(playerList);

    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().
                        getResource("/com/bolt/savage/View/FXML/PlayerDetailView.fxml"));
                root = loader.load();

                PlayerDetailController controller = loader.getController();
                controller.setPlayer((Player) players.getSelectionModel().getSelectedItem());

                Stage stage = new Stage();
                stage.setTitle(((Player) players.getSelectionModel().getSelectedItem()).name);
                stage.setScene(new Scene(root, 500, 700));
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void testConnection(int id) throws SQLException {
        Connection con = DatabaseHelper.getConnectionInstance();

        String query = "SELECT * FROM savage.PLAYER " +
                "WHERE TEAM_id = " + id;

        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(query);

        while (set.next()) {
            Player player = new Player();
            player.name = set.getString("name");
            playerList.add(player);
        }

        statement.close();
    }
}
