package GUI.TableData;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Class model for files what will be loaded in TableView.
 */
public class FilesModel {

    private StringProperty globalPath;
    private StringProperty fileFormat;
    private IntegerProperty length;

    public FilesModel(String globalPath, String fileFormat, int length) {
        this.setGlobalPath(new SimpleStringProperty(globalPath));
        this.setFileFormat(new SimpleStringProperty(fileFormat));
        this.setLength(new SimpleIntegerProperty(length));
    }

    public StringProperty getGlobalPath() {
        return globalPath;
    }

    public StringProperty getFileFormat() {
        return fileFormat;
    }

    public IntegerProperty getLength() {
        return length;
    }

    public void setGlobalPath(StringProperty globalPath) {
        this.globalPath = globalPath;
    }

    public void setFileFormat(StringProperty fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setLength(IntegerProperty length) {
        this.length = length;
    }
}
