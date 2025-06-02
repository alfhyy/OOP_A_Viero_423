import javafx.application.Application;
import javafx.stage.Stage;

public class MyJavaFXApps extends Application {
    @Override
    public void start(Stage primaryStage) {
        Layout layout = new Layout();

        primaryStage.setTitle("Game RNG tebak angka");
        primaryStage.setScene(layout.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
