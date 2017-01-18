package com.bolt.savage.View.Item;

import com.bolt.savage.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by yasir on 18/01/2017.
 */
public class PlayerCellAdapter extends ListCell<Player> {

    @Override
    protected void updateItem(Player item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            PlayerCell cell = new PlayerCell();
            cell.setCell(item.name);

            setGraphic(cell.getBox());
        }
    }

    protected class PlayerCell {
        @FXML
        private HBox playerCell;
        @FXML
        private Label playerName;


        public PlayerCell() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/bolt/savage/View/FXML/PlayerItem.fxml"));
            fxmlLoader.setController(this);
            try
            {
                fxmlLoader.load();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

        public void setCell(String name) {
            playerName.setText(name);
        }

        public HBox getBox() {
            return playerCell;
        }
    }
}
