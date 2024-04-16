package org.apollo.template.View;

import org.apollo.template.Controller.*;
import org.apollo.template.model.Character;

/**
 * Enum representing different views in the application.
 * Each enum value corresponds to an FXML file name and its associated controller.
 */
public enum ViewList {

    /**
     * Main view.
     */
    MAIN("MainView.fxml", MainController.getInstance()),

    /**
     * Menu view.
     */
    MENU("MenuView.fxml", new MenuController()),
    GAME("GameView.fxml", new GameController()),

    SETTINGS("SettingsView.fxml", SettingsController.getInstance()),

    REGISTRATION("RegistrationView.fxml", new RegistrationController()),

    SCOREBOARD("ScoreView.fxml", ScoreController.getInstance()),

    GAMEOVER("GameOverView.fxml", new GameOverController());

    private final String FXML_FILE_NAME; // FXML file name of the view
    private final Object CONTROLLER; // Controller associated with the view

    /**
     * Constructs a ViewList enum value with the specified FXML file name and controller.
     *
     * @param fxmlFileName The name of the FXML file representing the view
     * @param controller   The controller associated with the view
     */
    ViewList(String fxmlFileName, Object controller) {
        this.FXML_FILE_NAME = fxmlFileName;
        this.CONTROLLER = controller;
    }

    /**
     * Returns the FXML file name of the view.
     *
     * @return The FXML file name
     */
    public String getFxmlFileName() {
        return this.FXML_FILE_NAME;
    }

    /**
     * Returns the controller associated with the view.
     *
     * @return The controller instance
     */
    public Object getController() {
        return this.CONTROLLER;
    }

    /**
     * Common loader location for all FXML files in the application.
     */
    public static final String LOADER_LOCATION = "/org/apollo/template/";

}
