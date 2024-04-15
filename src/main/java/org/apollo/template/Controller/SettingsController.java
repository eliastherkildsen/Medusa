package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apollo.template.Service.Alert.Alert;
import org.apollo.template.Service.Alert.AlertComp;
import org.apollo.template.Service.Alert.AlertType;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class SettingsController implements Initializable {
    public static SettingsController instance;
    @FXML
    private Slider soundEffectSlider, musicSlider;
    private MediaPlayer musicMediaPlayer, soundEffectPlayer;
    private final Media MAIN_MUSIC_TRACK = new Media(new File("src/main/resources/org/apollo/template/audio/TetrisSoundTrack.mp3").toURI().toString());
    private Media eatingSound = new Media((new File("src/main/resources/org/apollo/template/audio/carrotnom-92106.mp3").toURI().toString()));
    private double musicSliderVolume = .5;
    private double soundEffectSliderVolume = .5;


    private SettingsController(){

        // setting up the music
        musicMediaPlayer = new MediaPlayer(MAIN_MUSIC_TRACK);
        musicMediaPlayer.setVolume(musicSliderVolume);
        musicMediaPlayer.setAutoPlay(true);
        musicMediaPlayer.play();

        // setting up the sound effects
        soundEffectPlayer = new MediaPlayer(eatingSound);
        soundEffectPlayer.setVolume(soundEffectSliderVolume);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // updates the volume of musicMediaPlayer based on the value of music slider
        musicMediaPlayer.volumeProperty().bind(musicSlider.valueProperty());

        // updates the volume of sound effect based on the value of sound effect slider
        soundEffectPlayer.volumeProperty().bind(soundEffectSlider.valueProperty());
    }

    @FXML
    protected void onBtnMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    @FXML
    protected void onBtnApply(){

        MainController.getInstance().addAlert(new AlertComp(AlertType.SUCCESS, "Settings has been updated!"));

        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    @FXML
    protected void onBtnMusicMute(){
        musicSliderVolume = 0;
        musicSlider.setValue(0);
        musicMediaPlayer.setVolume(0);
    }

    @FXML
    protected void onButtonSoundEffectMute(){
        soundEffectSliderVolume = 0;
        soundEffectSlider.setValue(0);
        soundEffectPlayer.setVolume(0);
    }


    public static SettingsController getInstance(){
        if (instance ==  null){
            instance = new SettingsController();
        }
        return instance;
    }

}
