module com.cmaggessi.encoderdecoderb64 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cmaggessi.encoderdecoderb64 to javafx.fxml;
    exports com.cmaggessi.encoderdecoderb64;
}