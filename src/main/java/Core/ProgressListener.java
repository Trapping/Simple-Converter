package Core;

import it.sauronsoftware.jave.EncoderProgressListener;
import it.sauronsoftware.jave.MultimediaInfo;
import javafx.scene.control.ProgressBar;

public class ProgressListener implements EncoderProgressListener {

    private ProgressBar progressBar;

    ProgressListener(ProgressBar progressBar){
        this.progressBar = progressBar;
    }

    @Override
    public void sourceInfo(MultimediaInfo multimediaInfo) {

    }

    @Override
    public void progress(int i) {
        progressBar.setProgress((double) i/1000);
    }

    @Override
    public void message(String s) {

    }
}
