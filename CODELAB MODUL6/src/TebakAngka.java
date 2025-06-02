import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngka extends Application {

    private int angkaRahasia;
    private int jumlahTebakan;
    private final Random random = new Random();

    // Komponen GUI
    private Label labelFeedback;
    private Label labelJumlahTebakan;
    private TextField inputTebakan;
    private Button tombolTebak;

    @Override
    public void start(Stage stage) {
        generateAngkaRahasia();

        // Label judul
        Label labelJudul = new Label("Tebak Angka 1 - 100");
        labelJudul.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Input dan tombol dalam satu baris (HBox)
        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka");
        inputTebakan.setMaxWidth(120);

        tombolTebak = new Button("Coba Tebak!");
        tombolTebak.setOnAction(e -> prosesTebakan());

        HBox inputArea = new HBox(10, inputTebakan, tombolTebak);
        inputArea.setAlignment(Pos.CENTER);

        // Label feedback dan jumlah tebakan
        labelFeedback = new Label("Silakan masukkan tebakan.");
        labelJumlahTebakan = new Label("Jumlah percobaan: 0");

        // Layout utama
        VBox layout = new VBox(15, labelJudul, inputArea, labelFeedback, labelJumlahTebakan);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 350, 200);
        stage.setScene(scene);
        stage.setTitle("Tebak Angka");
        stage.show();
    }

    private void prosesTebakan() {
        if (tombolTebak.getText().equals("Main Lagi")) {
            generateAngkaRahasia();
            inputTebakan.clear();
            tombolTebak.setText("Coba Tebak!");
            labelFeedback.setText("Silakan masukkan tebakan.");
            labelJumlahTebakan.setText("Jumlah percobaan: 0");
            return;
        }

        try {
            int tebakan = Integer.parseInt(inputTebakan.getText());
            jumlahTebakan++;

            if (tebakan < angkaRahasia) {
                labelFeedback.setText("Terlalu kecil!");
            } else if (tebakan > angkaRahasia) {
                labelFeedback.setText("Terlalu besar!");
            } else {
                labelFeedback.setText("Tebakan benar!");
                tombolTebak.setText("Main Lagi");
            }

            labelJumlahTebakan.setText("Jumlah percobaan: " + jumlahTebakan);
        } catch (NumberFormatException e) {
            labelFeedback.setText("Masukkan angka yang valid!");
        }
    }

    private void generateAngkaRahasia() {
        angkaRahasia = random.nextInt(100) + 1;
        jumlahTebakan = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}