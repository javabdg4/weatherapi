package com.sda.weatherapi;

import com.sda.weatherapi.view.WeatherView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private Stage stage;
    private WeatherView weatherView;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        weatherView = new WeatherView(stage);
        weatherView.loadView();
    }
}
