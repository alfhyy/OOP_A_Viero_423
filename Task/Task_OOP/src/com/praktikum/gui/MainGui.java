package com.praktikum.gui;

import com.praktikum.users.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.praktikum.users.Admin;
import com.praktikum.users.User;
import com.praktikum.storage.GlobalData;

public class MainGui extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        Admin admin = new Admin("Hapis", "202410370110423", "iniadmin", "passss");
        Student student = new Student("Hapis", "202410370110423");

        GlobalData.userList.add(admin);
        GlobalData.userList.add(student);

        primaryStage = stage;

        LoginPane loginPane = new LoginPane();
        Scene scene = loginPane.getScene(primaryStage);

        primaryStage.setTitle("Lost and Found System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeScene(Scene scene) {
        primaryStage.setScene(scene);
    }
}
