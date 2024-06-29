package com.cmaggessi.encoderdecoderb64;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;

public class EncoderApp extends Application {
    String appTitle = "Sistema de Criptografia - cMaggessi";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EncoderApp.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // here im loading images with iconStream so that if for some reason the image is not present the app won't crash and it will load normally
        InputStream iconStream = EncoderApp.class.getResourceAsStream("images/icons/locked_lock.png");
        if (iconStream != null) {
            Image icon = new Image(iconStream);
            stage.getIcons().add(icon);
        } else {
            System.err.println("Failed to load image: image-lock.png");
        }
        stage.setTitle(appTitle);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}