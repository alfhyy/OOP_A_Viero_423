package com.praktikum.gui;

import com.praktikum.models.Item;
import com.praktikum.models.ItemStatus;
import com.praktikum.storage.GlobalData;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.models.ItemStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboard {
    public static TableView<Item> itemTable = new TableView<>();
    public static TableView<Student> studentTable = new TableView<>();
    public static TextField studentInput;
    public static TextField studentIdInput;

    public static final List<Item> itemList = new ArrayList<>();

    public static Scene getScene(Stage stage, String adminName) {
        Text profile = new Text("Halo, Administrator " + adminName);
        profile.setStyle("-fx-font-family: 'Roboto Light';" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14;");

        Button logout = new Button("Logout");
        logout.setStyle("-fx-background-color: #aa0000; " +
                "-fx-border-radius: 5; " +
                "-fx-text-fill: white;" +
                "-fx-font-family: Arial");
        logout.setOnAction(e -> {
            LoginPane loginPane = new LoginPane();
            MainGui.changeScene(loginPane.getScene(stage));
        });

        Region topSpacer = new Region();
        HBox.setHgrow(topSpacer, Priority.ALWAYS);

        HBox topBar = new HBox(profile, topSpacer, logout);
        topBar.setSpacing(10);
        topBar.setAlignment(Pos.CENTER_LEFT);

        // Left Table - Items
        itemTable = new TableView<>();
        TableColumn<Item, String> nameCol = new TableColumn<>("Item Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Item, String> locCol = new TableColumn<>("Item Location");
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        itemList.clear();
        itemList.add(new Item("Dompet Hitam", "Gaada isinya", "Tas orang", ItemStatus.reported));
        itemList.add(new Item("Jaket Merah", "Pernah dipake Ryan Gosling", "Angsa Ict", ItemStatus.found));
        itemList.add(new Item("Kunci Motor", "Motor beat", "Kantek", ItemStatus.reported));
        itemList.add(new Item("Flashdisk", "Buat flash doang", "LabKom", ItemStatus.claimed));

        itemList.addAll(GlobalData.reportedItem);

        updateItemTable();

        Button btnFound = new Button("Found");
        btnFound.setOnAction(e -> {
            Item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus(ItemStatus.found);
                itemTable.refresh();
            } else {
                showAlert("No item selected.");
            }
        });

        Button btnClaimed = new Button("Claimed");
        btnClaimed.setOnAction(e -> {
            Item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus(ItemStatus.claimed);
                itemTable.refresh();
            } else {
                showAlert("No item selected.");
            }
        });

        HBox statusButtons = new HBox(10, btnFound, btnClaimed);
        statusButtons.setAlignment(Pos.CENTER_LEFT);

        itemTable.getColumns().addAll(nameCol, locCol, statusCol);
//        itemTable.getItems().addAll(
//                new Item("Dompet Hitam", "Gaada isinya","Tas orang", ItemStatus.reported),
//                new Item("Jaket Merah", "Pernah dipake Ryan Gosling","Angsa Ict", ItemStatus.found),
//                new Item("Kunci Motor", "Motor beat","Kantek", ItemStatus.reported),
//                new Item("Flashdisk", "Buat flash doang","LabKom", ItemStatus.claimed)
//        );

        VBox itemSection = new VBox(10, new Label("Laporan Barang"), itemTable, statusButtons);
        VBox.setVgrow(itemTable, Priority.ALWAYS);

        // Right Table - Students
        studentTable = new TableView<>();
        TableColumn<Student, String> studentName = new TableColumn<>("Student Name");
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> studentId = new TableColumn<>("Student ID");
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        TableColumn<Student, Void> deleteCol = new TableColumn<>("Delete");

        Callback<TableColumn<Student, Void>, TableCell<Student, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Student, Void> call(final TableColumn<Student, Void> param) {
                return new TableCell<>() {

                    private final Button deleteBtn = new Button("Delete");

                    {
                        deleteBtn.setOnAction(event -> {
                            Student student = getTableView().getItems().get(getIndex());

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                    "Are you sure you want to delete " + student.getName() + "?",
                                    ButtonType.YES, ButtonType.NO);
                            alert.showAndWait();

                            if (alert.getResult() == ButtonType.YES) {
                                // Remove from TableView
                                studentTable.getItems().remove(student);

                                // Also remove from global list if needed
                                GlobalData.userList.removeIf(user ->
                                        user instanceof Student &&
                                                user.getName().equals(student.getName()) &&
                                                ((Student) user).getStudentID().equals(student.getStudentID())
                                );

                                System.out.println("Deleted student: " + student.getName());
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteBtn);
                        }
                    }
                };
            }
        };

        deleteCol.setCellFactory(cellFactory);
        studentTable.getColumns().addAll(studentName, studentId, deleteCol);

        studentInput = new TextField();
        studentInput.setPromptText("Nama Mahasiswa");

        studentIdInput = new TextField();
        studentIdInput.setPromptText("NIM");

        Button addStudent = new Button("Add");
        addStudent.setOnAction(e -> handleAdd());

        HBox inputFields = new HBox(10, studentInput, studentIdInput, addStudent);
        inputFields.setAlignment(Pos.CENTER_LEFT);

        VBox studentSection = new VBox(10, new Label("Data Mahasiswa"), studentTable, inputFields);
        VBox.setVgrow(studentTable, Priority.ALWAYS);

        // Tables side by side
        HBox tables = new HBox(20, itemSection, studentSection);
        HBox.setHgrow(itemSection, Priority.ALWAYS);
        HBox.setHgrow(studentSection, Priority.ALWAYS);

        // Overall layout
        VBox layout = new VBox(10, topBar, tables);
        layout.setStyle("-fx-padding: 20px");

        return new Scene(layout, 750, 500);
    }

    public static void handleAdd() {
        String name = studentInput.getText();
        String id = studentIdInput.getText();

        if (name.isEmpty() || id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();
            return;
        }

        Student newStudent = new Student(name, id);
        studentTable.getItems().add(newStudent);

        GlobalData.userList.add(newStudent);

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Students added successfully!");
        successAlert.showAndWait();

        studentInput.clear();
        studentIdInput.clear();
    }

    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static void updateItemTable() {
        ObservableList<Item> observableItems = FXCollections.observableArrayList(itemList);
        itemTable.setItems(observableItems);
    }
}
