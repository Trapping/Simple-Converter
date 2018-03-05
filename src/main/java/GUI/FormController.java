package GUI;

import Core.ConventingThread;
import GUI.TableData.FilesModel;
import GUI.TableData.FilesModelObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    public TableView<FilesModel> tblFilesTable;
    @FXML
    public ImageView imgStart;
    @FXML
    public TableColumn<FilesModel, String> clmName;
    @FXML
    public TableColumn<FilesModel, String> clmFormat;
    @FXML
    public TableColumn<FilesModel, Integer> clmLength;
    @FXML
    public ProgressBar prbCurrentFile;
    @FXML
    public ProgressBar prbAllFiles;

    private FilesModelObservableList filesModelObservableList = new FilesModelObservableList();

    private static FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmName.setCellValueFactory(cellData -> cellData.getValue().getName());
        clmFormat.setCellValueFactory(cellData -> cellData.getValue().getFileFormat());
        clmLength.setCellValueFactory(cellData -> cellData.getValue().getLength().asObject());
        tblFilesTable.setItems(filesModelObservableList.getFilesModels());
        tblFilesTable.setEditable(false);
        tblFilesTable.setSortPolicy(param -> false);

    }

    public void btnAddInTableClicked(ActionEvent actionEvent) {
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Media files", "*.*"));
        fileChooser.setTitle("Choose media files for converting.");
        List<File> files = fileChooser.showOpenMultipleDialog(this.tblFilesTable.getScene().getWindow());

        for (File file: files
             ) {
            filesModelObservableList.addFile(file.getAbsolutePath(), file.getName(),".mp4", (int) file.length());
        }
    }

    public void btnRemoveFromTableClicked(ActionEvent actionEvent) {
        System.out.println(tblFilesTable.getSelectionModel().getSelectedIndex());
        tblFilesTable.getSelectionModel().select(2);
    }

    public void imgStartClicked(MouseEvent mouseEvent) {
        ConventingThread conventingThread = new ConventingThread(filesModelObservableList.getFilesModels(), prbCurrentFile, prbAllFiles);
        conventingThread.startThread();
        System.out.println("Нажато старт");
    }

    public void imgStartPressed(MouseEvent mouseEvent) {
    }


    /*TODO: Create properties loader for localization files
    * */


}
