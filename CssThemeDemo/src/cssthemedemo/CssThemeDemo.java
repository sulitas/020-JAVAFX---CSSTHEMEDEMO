/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssthemedemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 *
 * @author sulitas
 */
public class CssThemeDemo extends Application {

    private final String theme1Url = getClass().getResource("theme1.css").toExternalForm();
    private final String theme2Url = getClass().getResource("theme2.css").toExternalForm();

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        final Scene scene = new Scene(root, 300, 250);
        System.out.println("scene stylesheets: " + scene.getStylesheets());
        scene.getStylesheets().add(theme1Url);
        System.out.println("scene stylesheets: " + scene.getStylesheets());

        final Button btn = new Button("Incarca Stilul 1");
        btn.getStyleClass().add("buttonStyle");
        btn.setOnAction((ActionEvent event) -> {
            scene.getStylesheets().remove(theme2Url);
            System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());
            if(!scene.getStylesheets().contains(theme1Url)) 
                scene.getStylesheets().add(theme1Url);
            System.out.println("scene stylesheets on button 1 click: " + scene.getStylesheets());
        });

        final Button btn2 = new Button("Incarca Stilul 2");
        btn2.getStyleClass().add("buttonStyle");
        btn2.setOnAction((ActionEvent event) -> {
            scene.getStylesheets().remove(theme1Url);
            System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
            if(!scene.getStylesheets().contains(theme2Url)) 
                scene.getStylesheets().add(theme2Url);
            System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        });

        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList("un", "alt", "control"));
        root.getChildren().add(VBoxBuilder.create().spacing(10).children(btn, btn2, comboBox).build());

        primaryStage.setTitle("Silviu Sulita - JavaFX - Schimbarea temelor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
