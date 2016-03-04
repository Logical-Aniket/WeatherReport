package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Aniket on 3/3/2016.
 */
public class LocationForecast {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private Coordinate coord;
    @SerializedName("main")
    private Main main;
    @SerializedName("dt")
    private long dt;
    @SerializedName("wind")
    private Wind wind;
    //    @SerializedName("rain")
//    private Rain rain;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("weather")
    private Weather[] weatherList;

    public LocationForecast() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Weather[] getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(Weather[] weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public String toString() {
        return "LocationForecast{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", main=" + main +
                ", dt=" + dt +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", weatherList=" + Arrays.toString(weatherList) +
                '}';
    }
}
