package GUI.TableData;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Class model for files what will be loaded in TableView.
 */
public class FilesModel {

    private StringProperty absolutePath;
    private StringProperty name;
    private StringProperty fileFormat;
    private IntegerProperty length;

    public FilesModel(String absolutePath, String name, String fileFormat, int length) {
        this.setAbsolutePath(new SimpleStringProperty(absolutePath));
        this.setName(new SimpleStringProperty(name));
        this.setFileFormat(new SimpleStringProperty(fileFormat));
        this.setLength(new SimpleIntegerProperty(length));
    }

    public StringProperty getAbsolutePath() {
        return absolutePath;
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getFileFormat() {
        return fileFormat;
    }

    public IntegerProperty getLength() {
        return length;
    }

    public void setAbsolutePath(StringProperty absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setFileFormat(StringProperty fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void setLength(IntegerProperty length) {
        this.length = length;
    }
}
