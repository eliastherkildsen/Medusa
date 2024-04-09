package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class SettingsController implements Initializable {
    public static SettingsController instance;
    @FXML
    private Slider SoundEffectSlider, musicSlider;
    private MediaPlayer musicMediaPlayer, soundEffectPlayer;
    private final Media MAIN_MUSIC_TRACK = new Media(new File("src/main/resources/org/apollo/template/audio/TetrisSoundTrack.mp3").toURI().toString());
    private double musicSliderVolume = .5;
    private double SoundEffectSliderVolume = .5;


    private SettingsController(){

        // setting up the music
        musicMediaPlayer = new MediaPlayer(MAIN_MUSIC_TRACK);
        musicMediaPlayer.setVolume(musicSliderVolume);
        musicMediaPlayer.setAutoPlay(true);
        musicMediaPlayer.play();

        // setting up the sound effect




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        musicSlider.setValue(musicSliderVolume);

    }
    @FXML
    protected void onBtnMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }
    @FXML
    protected void onBtnApply(){
        musicSliderVolume = musicSlider.valueProperty().getValue();
        System.out.println(musicSliderVolume);
        musicMediaPlayer.setVolume(musicSliderVolume);

        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }
    @FXML
    protected void onBtnMusicMute(){
        musicSliderVolume = 0;
        musicSlider.setValue(0);
        musicMediaPlayer.setVolume(0);
    }

    public static SettingsController getInstance(){
        if (instance ==  null){
            instance = new SettingsController();
        }
        return instance;
    }

}
