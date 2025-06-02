import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;

public class Layout {
    private TextField inputNumber;
    private Label feedbackLabel, subHeader;
    private Text countAttempt;
    private Button submitButton;

    private int attempCount = 0;
    private int targetNumber;
    private boolean gameEnded = false;

    public Layout() {
        generateNewTarget();
    }

    public Scene getScene() {
        Text header = new Text("Tebak Angka 1–100");
        header.setFill(Color.BLUEVIOLET);
        header.setStyle("-fx-font-family: 'Helvetica Rounded'; -fx-font-weight: bold; -fx-font-size: 30");

        subHeader = new Label("Masukkan tebakanmu!");
        subHeader.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 16;");
        subHeader.setTextFill(Color.BLACK);

        inputNumber = new TextField();
        inputNumber.setPromptText("Masukkan angka di sini");
        inputNumber.setPrefWidth(200);
        inputNumber.setStyle("-fx-text-fill: black; -fx-prompt-text-fill: gray;");

        submitButton = new Button("Coba Tebak!");
        submitButton.setStyle(
                "-fx-background-color: #28a745; " +
                        "-fx-border-radius: 5; " +
                        "-fx-text-fill: white;" +
                        "-fx-font-family: Arial"
        );
        submitButton.setOnAction(e -> handleSubmit());

        feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14");

        countAttempt = new Text("Jumlah percobaan: 0");
        countAttempt.setStyle("-fx-font-size: 14; -fx-font-family: Arial;");

        HBox hBox = new HBox(5, inputNumber, submitButton);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, header, subHeader, hBox, feedbackLabel, countAttempt);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setStyle("-fx-padding: 30;");
        vBox.setAlignment(Pos.CENTER);

        return new Scene(vBox, 500, 250);
    }

    public void handleSubmit() {
        if (gameEnded) {
            // Reset game
            generateNewTarget();
            attempCount = 0;
            countAttempt.setText("Jumlah percobaan: 0");
            feedbackLabel.setText("");
            subHeader.setText("Masukkan tebakanmu!");
            subHeader.setTextFill(Color.BLACK);
            submitButton.setText("Coba Tebak!");
            inputNumber.setDisable(false);
            gameEnded = false;
            return;
        }

        String input = inputNumber.getText();
        try {
            int guess = Integer.parseInt(input);
            attempCount++;
            countAttempt.setText("Jumlah percobaan: " + attempCount);

            if (guess < 1 || guess > 100) {
                subHeader.setText("Masukkan angka antara 1 dan 100!");
                subHeader.setTextFill(Color.ORANGE);
                feedbackLabel.setText("");
            } else if (guess < targetNumber) {
                subHeader.setText("️️Terlalu kecil!");
                subHeader.setTextFill(Color.DARKORANGE);
                feedbackLabel.setText("");
            } else if (guess > targetNumber) {
                subHeader.setText("Terlalu besar!");
                subHeader.setTextFill(Color.DARKORANGE);
                feedbackLabel.setText("");
            } else {
                subHeader.setText("✅ Tebakan benar!");
                subHeader.setTextFill(Color.GREEN);
                feedbackLabel.setText("Angka baru telah diacak. Tekan Main Lagi untuk mencoba lagi.");
                submitButton.setText("Main Lagi");
                inputNumber.setDisable(true);
                gameEnded = true;
            }

        } catch (NumberFormatException e) {
            subHeader.setText("Input tidak valid, masukkan angka!");
            subHeader.setTextFill(Color.RED);
            feedbackLabel.setText("");
        }

        inputNumber.clear();
    }

    public void generateNewTarget() {
        Random rand = new Random();
        targetNumber = rand.nextInt(100) + 1;
    }
}
