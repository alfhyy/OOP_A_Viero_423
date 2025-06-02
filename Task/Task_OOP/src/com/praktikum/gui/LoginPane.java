package com.praktikum.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import com.praktikum.storage.GlobalData;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import javafx.stage.Stage;


public class LoginPane {
    private TextField username;
    private PasswordField password;
    private Button login;
    private ComboBox loginOption;

    public Scene getScene(Stage stage) {
        Text header = new Text("Login Page");
        header.setStyle("-fx-text-fill: Black;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Helvetica Neue';" +
                "-fx-font-size: 30;");

        loginOption = new ComboBox();
        loginOption.getItems().addAll("Admin", "Student");
        loginOption.setPromptText("Login as");
        loginOption.setPrefWidth(100);
        loginOption.setStyle("-fx-border-radius: 5");

        username = new TextField();
        username.setPromptText("Username");
        username.setPrefWidth(200);
        username.setMaxWidth(200);

        password = new PasswordField();
        password.setPromptText("Password");
        password.setPrefWidth(200);
        password.setMaxWidth(200);

        login = new Button("Login");
        login.setStyle("-fx-background-color: #1b6ec7; " +
                "-fx-border-radius: 5; " +
                "-fx-text-fill: white;" +
                "-fx-font-family: Arial");
        login.setOnAction(e -> handleLogin(stage));

//        Button click = new Button("Click");
//        click.setOnAction(e -> {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sucess", ButtonType.OK);
//            alert.showAndWait();
//            alert.setTitle("Success");
//        });


        VBox vBox = new VBox(10, header, loginOption, username, password, login, click);
        vBox.setAlignment(Pos.CENTER);

        return new Scene(vBox, 600, 400);
    }

    private void handleLogin(Stage stage) {
        String inputUsername = username.getText();
        String inputPassword = password.getText();
        String selectedRole = (String) loginOption.getValue();

        if (selectedRole == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select login role (Admin or Student).", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        boolean found = false;

        for (User user : GlobalData.userList) {
            if (user instanceof Admin admin) {
                if (inputUsername.equals(admin.username) && inputPassword.equals(admin.password)) {
                    found = true;
                    stage.setScene(AdminDashboard.getScene(stage, admin.username));
                    break;
                }
            } else if (user instanceof Student student) {
                if (inputUsername.equals(student.getName()) && inputPassword.equals(student.getStudentID())) {
                    found = true;
                    stage.setScene(StudentDashboard.getScene(stage, student.getName()));
                    break;
                }
            }
        }

        if (!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login failed! Username or password incorrect.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
