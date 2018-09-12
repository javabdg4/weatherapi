package com.sda.weatherapi.view;

import com.sda.weatherapi.App;
import com.sda.weatherapi.controller.WeatherController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class WeatherView {

    private VBox vBox;
    private Stage stage;

    public WeatherView(Stage stage) {
        this.stage = stage;
    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/rootview.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.setTitle("Weather application");
            stage.getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));
            stage.show();

            WeatherController weatherController;

            weatherController = loader.getController();
            weatherController.setWeatherView(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
