package GUI.TableData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * Observable class model for files what will be loaded in TableView.
 */

public class FilesModelObservableList{

    private ObservableList<FilesModel> filesModels = FXCollections.observableArrayList();

    public ObservableList<FilesModel> getFilesModels() {
        return filesModels;
    }

    public void addFile(String globalPath, String name, String fileFormat, int length){
        filesModels.add(new FilesModel(globalPath, name, fileFormat, length));
    }
}
