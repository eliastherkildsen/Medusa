package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apollo.template.Service.Alert.Alert;
import org.apollo.template.Service.Alert.AlertComp;
import org.apollo.template.Service.Alert.AlertType;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;
import org.apollo.template.model.Food.SoundEffect;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class SettingsController implements Initializable {
    public static SettingsController instance;
    @FXML
    private Slider soundEffectSlider, musicSlider;
    @FXML
    private Button btnMusic, btnSound;
    @FXML
    private ImageView btnMusicImage, btnSoundImage;

    private final String volumeImageURL = "file:src/main/resources/org/apollo/template/images/volume-2.png";
    private final String muteImageURL = "file:src/main/resources/org/apollo/template/images/volume-x.png";

    private MediaPlayer musicMediaPlayer, soundEffectPlayer;
    private final Media MAIN_MUSIC_TRACK = new Media(new File("src/main/resources/org/apollo/template/audio/TetrisSoundTrack.mp3").toURI().toString());
    private Media eatingSound = new Media((new File("src/main/resources/org/apollo/template/audio/carrotnom-92106.mp3").toURI().toString()));
    private double musicSliderVolume = .5;
    private double soundEffectSliderVolume = .5;
    private boolean setMusicMute = true;
    private boolean setSoundMute = true;
    private double lastMusicVal;
    private double lastSoundVal;



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
    protected void onBtnMusicMute(){

        if (setMusicMute){
            lastMusicVal = musicSlider.getValue();
            musicSlider.setValue(0);

            updateMusicMuteImage(muteImageURL);
        }
        else {
            musicSlider.setValue(lastMusicVal);
            updateMusicMuteImage(volumeImageURL);
        }

        toggleMusicMuteState();
    }



    private void updateMusicMuteImage(String imageURL) {
        Image image = new Image(imageURL);
        btnMusicImage.setImage(image);
    }


    private void toggleMusicMuteState() {
        setMusicMute = !setMusicMute;
    }

    @FXML
    protected void onButtonSoundEffectMute(){
        if (setSoundMute){
            lastSoundVal = soundEffectSlider.getValue();
            soundEffectSlider.setValue(0);

            updateSoundMuteImage(muteImageURL);
        }
        else {
            soundEffectSlider.setValue(lastSoundVal);
            updateSoundMuteImage(volumeImageURL);
        }

        toggleSoundMuteState();

    }

    private void toggleSoundMuteState() {
        setSoundMute = !setSoundMute;
    }

    private void updateSoundMuteImage(String imageURL) {
        Image image = new Image(imageURL);
        btnSoundImage.setImage(image);
    }

    public void useSoundEffect(SoundEffect soundEffect){

        String filepath = String.format("file:%s",soundEffect);
        Media media = new Media(new File(filepath).toURI().toString());

        soundEffectPlayer = new MediaPlayer(media);
        soundEffectPlayer.play();
    }

    public void setMusicRate(Double rate){
        musicMediaPlayer.setRate(rate);
    }


    public static SettingsController getInstance(){
        if (instance ==  null){
            instance = new SettingsController();
        }
        return instance;
    }

}
