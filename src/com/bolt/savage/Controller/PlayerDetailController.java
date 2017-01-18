package com.bolt.savage.Controller;

import com.bolt.savage.Model.DatabaseHelper;
import com.bolt.savage.Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.sql.*;


public class PlayerDetailController {


    @FXML
    private ImageView playerImage;



    @FXML
    private Label role;
    @FXML
    private Label team;

    //XML links to Batting xml file
    @FXML
    private Pane battingPane;
    @FXML
    private Label fifty;
    @FXML
    private Label hundred;
    @FXML
    private Label caughttaking;
    @FXML
    private Label sixes;
    @FXML
    private Label fours;
    @FXML
    private Label average;
    @FXML
    private Label highestscore;
    @FXML
    private Label runs;
    @FXML
    private Label notouts;
    @FXML
    private Label innings;
    @FXML
    private Label matches;

    //XML links to Bawling xml file
    @FXML
    private Pane bowlingPane;
    @FXML
    private Label runsBow;
    @FXML
    private Label balls;
    @FXML
    private Label matchesBow;
    @FXML
    private Label inningsBow;
    @FXML
    private Label wickets;
    @FXML
    private Label bestInn;
    @FXML
    private Label bestMatch;
    @FXML
    private Label averageBow;
    @FXML
    private Label ecc;
    @FXML
    private Label fourW;
    @FXML
    private Label fiveW;
    @FXML
    private Label tenW;

    public void initialize() {

    }

    void setPlayer(Player player) {
        role.setText(player.role);
        team.setText(player.side);

        if (player.batting) {
            try {
                fetchBattingData(player.testBatting);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            battingPane.setVisible(false);
        }


        if (player.bowling) {
            try {
                fetchBattingData(player.testBowling);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            bowlingPane.setVisible(false);
        }
    }

    private void fetchBattingData(int batId) throws SQLException {
        Connection con = DatabaseHelper.getConnectionInstance();

        String batQuery = "SELECT * FROM savage.BATTING_STAT " +
                "WHERE id = " + batId;

        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(batQuery);

        while (set.next()) {
            fifty.setText(set.getInt("50s") + "");
            hundred.setText(set.getInt("100s") + "");
            caughttaking.setText(set.getInt("catches") + "");
            sixes.setText(set.getInt("6s") + "");
            fours.setText(set.getInt("4s") + "");
            average.setText(set.getInt("average") + "");
            highestscore.setText(set.getInt("high_score") + "");
            runs.setText(set.getInt("runs") + "");
            notouts.setText(set.getInt("not_outs") + "");
            innings.setText(set.getInt("innings") + "");
            matches.setText(set.getInt("matches") + "");
        }

    }

    private void fetchBowlingData(int bowId) throws SQLException {
        Connection con = DatabaseHelper.getConnectionInstance();

        String bowQuery = "SELECT * FROM savage.BATTING_STAT " +
                "WHERE id = " +bowId;

        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(bowQuery);

    }
}
