package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class Forecast {
    @SerializedName("clouds")
    private int clouds;
    @SerializedName("dt")
    private long dt;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private int deg;
    @SerializedName("weather")
    private Weather[] weatherList;
    @SerializedName("temp")
    private Temperature temp;

    public Forecast() {
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Weather[] getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(Weather[] weatherList) {
        this.weatherList = weatherList;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "clouds=" + clouds +
                ", dt=" + dt +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", speed=" + speed +
                ", deg=" + deg +
                ", weatherList=" + Arrays.toString(weatherList) +
                ", temp=" + temp +
                '}';
    }
}
