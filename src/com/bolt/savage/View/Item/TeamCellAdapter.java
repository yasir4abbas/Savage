package com.bolt.savage.View.Item;

import com.bolt.savage.Model.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Created by yasir on 22/12/2016.
 */
public class TeamCellAdapter extends ListCell<Team> {

    @Override
    protected void updateItem(Team item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            TeamCell cell = new TeamCell();


            cell.setCell(item.flag,item.name);
            setGraphic(cell.getBox());
        }
    }

    protected class TeamCell {
        @FXML
        HBox teamCell;
        @FXML
        ImageView teamFlag;
        @FXML
        Label teamName;

        public TeamCell() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/bolt/savage/View/FXML/TeamItem.fxml"));
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

        public void setCell(String img, String name) {
            Image image = new Image("/resource/" + img);

            teamFlag.setImage(image);
            teamName.setText(name);
        }

        public HBox getBox() {
            return teamCell;
        }

    }
}
