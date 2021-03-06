package Core;

import GUI.TableData.FilesModel;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressBar;

import java.io.File;
import java.util.ArrayList;

public class ConventingThread implements Runnable{

    private ProgressBar prbAllFiles;
    private ObservableList<FilesModel> filesList;
    private Thread thread;
    private ProgressListener progressListener;
    private boolean finishedStatus = false;
    private ArrayList<FilesModel> successfulList, failedList;

    public ConventingThread(ObservableList<FilesModel> filesList, ProgressBar prbCurrentFile, ProgressBar prbAllFiles,
                            ArrayList<FilesModel> successfulList, ArrayList<FilesModel> failedList) {
        this.filesList = filesList;
        this.prbAllFiles = prbAllFiles;
        this.thread = new Thread(this);
        this.progressListener = new ProgressListener(prbCurrentFile);
        this.successfulList = successfulList;
        this.failedList = failedList;
    }

    public void startThread(){
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Поток стартовал");
        Encoder encoder = new Encoder();
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(128000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        EncodingAttributes attr = new EncodingAttributes();
        attr.setFormat("mp3");
        attr.setAudioAttributes(audio);
        prbAllFiles.setProgress(0.0);
        double progressStep = (double) 1 / filesList.size();

        for (FilesModel file: filesList
             ) {
                try {
                    System.out.println(file.getName().getValue());
                    encoder.encode(new File(file.getAbsolutePath().getValue()),
                            new File(file.getAbsolutePath().getValue().replace(file.getFileFormat().getValue(),".mp3")),
                            attr, progressListener);
                    System.out.println("Success!");
                    successfulList.add(file);
                    prbAllFiles.setProgress(prbAllFiles.getProgress() + progressStep);
                } catch (EncoderException e){
                    System.out.println("Converting error!");
                    failedList.add(file);
                    e.printStackTrace();
                }
        }
        prbAllFiles.setProgress(1);
        System.out.println("Process finished!");
        finishedStatus = true;
    }

    public boolean getFinishedStatus(){
        if (finishedStatus){
            finishedStatus = false;
            return true;
        } else {
            return false;
        }
    }
}
