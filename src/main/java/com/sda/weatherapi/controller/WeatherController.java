package com.sda.weatherapi.controller;

import com.sda.weatherapi.model.WeatherModel;
import com.sda.weatherapi.properties.AppProperties;
import com.sda.weatherapi.properties.Configuration;
import com.sda.weatherapi.view.WeatherView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherController {

    private WeatherView weatherView;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private ImageView imageIcon;

    @FXML
    private TextField cityText;

    @FXML
    private Label temperatureInFLabel;

    @FXML
    private Label latLabel;

    @FXML
    private Label lonLabel;

    private String finalUrl;

    public void prepareURL(String url, String key) {
        finalUrl = url + "?key=" + key;
    }

    public void showInfo(ActionEvent actionEvent) {

        AppProperties appProperties = Configuration.loadProperties();
        prepareURL(appProperties.getUrl(), appProperties.getKey());

        WeatherModel weather = new WeatherModel();
        String url = finalUrl + "&q=" + cityText.getText();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
        } catch (IOException e) {
            return;
        }
        if (weather != null) {
            weather.setCity(jsonObject.getJSONObject("location").get("name").toString());
            weather.setTemperature(jsonObject.getJSONObject("current").get("temp_c").toString());
            weather.setDescription(jsonObject.getJSONObject("current").getJSONObject("condition").get("text").toString());
            weather.setLat(jsonObject.getJSONObject("location").get("lat").toString());
            weather.setLon(jsonObject.getJSONObject("location").get("lon").toString());
            weather.setTemperatureInF(jsonObject.getJSONObject("current").get("temp_f").toString());
            weather.setIconUrl(jsonObject.getJSONObject("current").getJSONObject("condition").get("icon").toString());

            temperatureLabel.setText(weather.getTemperature());
            descriptionLabel.setText(weather.getDescription());
            latLabel.setText(weather.getLat());
            lonLabel.setText(weather.getLon());
            temperatureInFLabel.setText(weather.getTemperatureInF());

            Image image = new Image("http:" + weather.getIconUrl(), true);
            imageIcon.setImage(image);
        }
    }

    public void setWeatherView(WeatherView weatherView) {
        this.weatherView = weatherView;
    }
}
