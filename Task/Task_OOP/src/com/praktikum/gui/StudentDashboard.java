package com.praktikum.gui;

import com.praktikum.models.Item;
import com.praktikum.models.ItemStatus;
import com.praktikum.storage.GlobalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentDashboard {
    private static TextField itemName;
    private static TextField itemDesc;
    private static TextField itemLoc;
    private static TableView<Item> table;

    public static Scene getScene(Stage stage, String studentName) {
        Text profile = new Text("Welcome " + studentName + "\nReport Lost and Found");
        profile.setStyle("-fx-font-family: 'Roboto Light';" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14;" +
                "-fx-label-padding-left: 5px; ");

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
        topBar.setStyle("-fx-alignment: center-left;"); // Optional styling

        itemName = new TextField();
        itemName.setPromptText("Item Name");

        itemDesc = new TextField();
        itemDesc.setPromptText("Item Description");

        itemLoc = new TextField();
        itemLoc.setPromptText("Location");

        Button submit = new Button("Report");
        submit.setStyle("-fx-background-color: #00ab06; " +
                "-fx-border-radius: 5; " +
                "-fx-text-fill: white;" +
                "-fx-font-family: Arial");
        submit.setOnAction(e -> submitHandle());

        Region inputSpacer = new Region();
        HBox.setHgrow(inputSpacer, Priority.ALWAYS);

        HBox hBox1 = new HBox(5, itemName, itemDesc, itemLoc, submit);
        HBox hBox = new HBox(10, hBox1, inputSpacer);

        table = new TableView<>();

        TableColumn<Item, String> nameCol = new TableColumn<>("Item Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Item, String> descCol = new TableColumn<>("Description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> locCol = new TableColumn<>("Location");
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.getColumns().addAll(nameCol, descCol, locCol, statusCol);

        ObservableList<Item> data = FXCollections.observableArrayList(GlobalData.reportedItem);

        table.setItems(data);

        VBox layout = new VBox(10, topBar, hBox, table);
        layout.setStyle("-fx-padding: 20px;");
        return new Scene(layout, 600, 400);
    }

    public static void submitHandle() {
        String inputName = itemName.getText().trim();
        String inputDesc = itemDesc.getText().trim();
        String inputLoc = itemLoc.getText().trim();

        if (inputName.isEmpty() || inputDesc.isEmpty() || inputLoc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled!");
            alert.showAndWait();
            return;
        }

        Item newItem = new Item(inputName, inputDesc, inputLoc, ItemStatus.reported);
        table.getItems().add(newItem);

        GlobalData.reportedItem.add(newItem);

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Item reported successfully!");
        successAlert.showAndWait();

        itemName.clear();
        itemDesc.clear();
        itemLoc.clear();
    }
}
