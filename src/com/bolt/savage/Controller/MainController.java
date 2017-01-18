package com.bolt.savage.Controller;

import com.bolt.savage.Model.DatabaseHelper;
import com.bolt.savage.Model.Team;
import com.bolt.savage.View.Item.TeamCellAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.*;

public class MainController implements EventHandler<MouseEvent> {

    @FXML
    private Label menuItem;
    @FXML
    private ListView listView;

    private ObservableList<Team> list;

    public void initialize() {

        menuItem.setText("TEAMS");

        list = FXCollections.observableArrayList();

        try {
            fetchTeams();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listView.setOnMouseClicked(this);
        listView.setItems(list);


        listView.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView param) {
                return new TeamCellAdapter();
            }
        });

    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getClickCount() == 2) {
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().
                        getResource("/com/bolt/savage/View/FXML/TeamDetailView.fxml"));
                root = loader.load();

                TeamDetailController controller = loader.getController();
                controller.setTeam((Team) listView.getSelectionModel().getSelectedItem());

                Stage stage = new Stage();
                stage.setTitle(((Team) listView.getSelectionModel().getSelectedItem()).name);
                stage.setScene(new Scene(root, 500, 700));
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void fetchTeams() throws SQLException {
        Connection con = DatabaseHelper.getConnectionInstance();

        String query = "select * from savage.TEAM";

        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(query);

        while (set.next()) {
            Team team = new Team();
            team.id = set.getInt("id");
            team.name = set.getString("name");
            team.flag = set.getString("flag");
            team.coach = set.getString("coach");
            team.stadiums = set.getString("stadium");
            list.add(team);
        }

        statement.close();

    }
}
