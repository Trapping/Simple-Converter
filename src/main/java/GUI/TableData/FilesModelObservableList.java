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

    public void AddFile(String globalPath, String fileFormat, int lenth){
        filesModels.add(new FilesModel(globalPath, fileFormat, lenth));
    }
}
