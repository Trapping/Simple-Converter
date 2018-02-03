package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    public TableView tblFilesTable;
    @FXML
    public ImageView imgStart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnAddInTableClicked(ActionEvent actionEvent) {
    }

    public void btnRemoveFromTableClicked(ActionEvent actionEvent) {
    }

    public void imgStartClicked(MouseEvent mouseEvent) {
    }

    public void imgStartPressed(MouseEvent mouseEvent) {
    }


    /*TODO: Create properties loader for localization files
    * */


}
