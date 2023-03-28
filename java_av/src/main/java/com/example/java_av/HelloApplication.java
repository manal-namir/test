package com.example.java_av;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Matieres");
        BorderPane borderPaneRoot = new BorderPane();
        Scene scene = new Scene(borderPaneRoot, 800, 600);
        stage.setScene(scene);
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        Label LabelName = new Label("Nom de la matiere");
        LabelName.setPadding(new Insets(5));
        TextField textFieldName = new TextField();
        Button bouttonAdd = new Button("Ajouter");
        hBox.getChildren().addAll(LabelName, textFieldName, bouttonAdd);
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        ObservableList<String> observableList1 = FXCollections.observableArrayList();
        ListView<String> ListView = new ListView<>(observableList1);
        observableList1.addAll("java", "c++");
        vBox.getChildren().add(ListView);
        borderPaneRoot.setCenter(vBox);
        borderPaneRoot.setTop(hBox);
        stage.show();
        bouttonAdd.setOnAction((event) -> {
            String name = textFieldName.getText();
            observableList1.add(name);
        });
        Button bouttonDel = new Button("Supprimer");
        bouttonDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int indice = ListView.getSelectionModel().getSelectedIndex();
                if (indice >= 0) {
                    ListView.getItems().remove(indice);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("selectionner un element");
                    alert.show();
                }
            }

            public static void main(String[] args) {
                launch(args);
            }

        });
    }
}