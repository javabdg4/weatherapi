package com.sda.weatherapi.model;

public class WeatherModel {

    private String city;
    private String temperature;
    private String description;
    private String lat;
    private String lon;
    private String temperatureInF;
    private String iconUrl;

    public WeatherModel() {
    }

    public WeatherModel(String city, String temperature, String description, String lat, String lon, String temperatureInF, String iconUrl) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.temperatureInF = temperatureInF;
        this.iconUrl = iconUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTemperatureInF() {
        return temperatureInF;
    }

    public void setTemperatureInF(String temperatureInF) {
        this.temperatureInF = temperatureInF;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
