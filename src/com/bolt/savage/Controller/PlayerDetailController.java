package com.bolt.savage.Controller;

import com.sun.org.omg.CORBA.Initializer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.omg.CORBA.INITIALIZE;

/**
 * Created by HUSSAIN on 16-Jan-17.
 */
public class PlayerDetailController {
    @FXML
    private Label playerName;
    @FXML
    private Label playerSide;
    @FXML
    private Label playerRole;

    void setInfo() {
        playerName.setText("Full Name: ");
        playerSide.setText("National Side: ");
        playerRole.setText("Role: ");
    }

}
