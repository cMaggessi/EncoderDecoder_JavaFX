package com.cmaggessi.encoderdecoderb64;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class EncoderController implements Initializable {
    // Initializing X,Y coords in 0.
    private double x = 0;
    private double y = 0;
    private LANGUAGE language;

    /*
    Version control for my app.
    All rights reserved to Caio Maggessi.
    github.com/cMaggessi
     */
    String version = "cMaggessi v1.0";

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button clearAllBtn;

    @FXML
    private TextField cryptedText;

    @FXML
    private Label cryptedTextLabel;

    @FXML
    private Button decryptButton;

    @FXML
    private TextField decryptTextField;

    @FXML
    private TextField decryptedText;

    @FXML
    private Label decryptedTextLabel;

    @FXML
    private Button encryptButton;

    @FXML
    private TextField encryptTextField;

    @FXML
    private ImageView englishBtn;

    @FXML
    private ImageView exitButton;

    @FXML
    private Label label_choose_translation;

    @FXML
    private Text label_crypt_translation;

    @FXML
    private Text label_decrypt_translation;

    @FXML
    private ImageView portugueseBtn;

    @FXML
    private Text versionText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        language = LANGUAGE.ENGLISH;

        versionText.setText("Base64 Encrypt & Decrypt — "+version);

        // Exit application
        exitButton.setOnMouseClicked(mouseEvent -> System.exit(0));

        // Encrypt button action
        encryptButton.setOnAction(event -> {
            String text = encryptTextField.getText();
            encryptText(text);
            showClearBtn();
        });

        // Decrypt button action
        decryptButton.setOnAction(event -> {
            String text = decryptTextField.getText();
            decryptText(text);
            showClearBtn();
        });

        // Clear all - clear all input fields
        clearAllBtn.setOnAction(event -> clearFields());

        // Changing language
        portugueseBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, ev -> translatePortuguese());

        englishBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, ev -> translateEnglish());


    }

    public void encryptText(String text) {
        String encrypted = Base64.getEncoder().encodeToString(text.getBytes());
        cryptedText.setText(encrypted);
        cryptedTextLabel.setVisible(true);
        cryptedText.setVisible(true);

    }

    public void decryptText(String text) {
        String decrypted = new String(Base64.getDecoder().decode(text));
        decryptedText.setVisible(true);
        decryptedTextLabel.setVisible(true);
        decryptedText.setText(decrypted);
    }

    public void clearFields() {
        encryptTextField.setText("");
        decryptTextField.setText("");
        cryptedText.setText("");
        cryptedTextLabel.setVisible(false);
        cryptedText.setVisible(false);
        decryptedText.setVisible(false);
        decryptedTextLabel.setVisible(false);
        decryptedText.setText("");
        clearAllBtn.setVisible(false);
    }

    public void showClearBtn() {
        clearAllBtn.setVisible(true);
    }


    public void translatePortuguese() {
        if(language.equals(LANGUAGE.ENGLISH)) {
            language = LANGUAGE.PORTUGUESE;
            label_choose_translation.setText("Escolha a linguagem");
            label_crypt_translation.setText("Criptografar texto");
            label_decrypt_translation.setText("Descriptografar texto");
            cryptedTextLabel.setText("Seu texto criptografado");
            decryptedTextLabel.setText("Seu texto descriptografado");
            clearAllBtn.setText("Limpar tudo");
            encryptButton.setText("Criptografar");
            decryptButton.setText("Descriptografar");
        }
    }

    public void translateEnglish() {
        if(language.equals(LANGUAGE.PORTUGUESE)) {
            language = LANGUAGE.ENGLISH;
            label_choose_translation.setText("Choose your language");
            label_crypt_translation.setText("Encrypt text");
            label_decrypt_translation.setText("Decrypt text");
            cryptedTextLabel.setText("Your crypted text");
            decryptedTextLabel.setText("Your decrypted text");
            clearAllBtn.setText("Clear all");
            encryptButton.setText("Encrypt");
            decryptButton.setText("Decrypt");
        }
    }


    /*
        UNDECORATED application dragging, please for more information, check out resources.
        IE: JavaFX Scene Builder how to drag undecorated application.
     */
    @FXML
    private void borderpane_dragged(MouseEvent event) {
        Stage stage = (Stage) borderpane.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

    @FXML
    private void borderpane_pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }



}
