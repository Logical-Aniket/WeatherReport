package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class ResponseDataObject {
    @SerializedName("message")
    private double message;
    @SerializedName("cnt")
    private int cnt;
    @SerializedName("cod")
    private int cod;
    @SerializedName("city")
    private City city;
    @SerializedName("list")
    private Forecast[] forecastList;

    public ResponseDataObject() {
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Forecast[] getForecastList() {
        return forecastList;
    }

    public void setForecastList(Forecast[] forecastList) {
        this.forecastList = forecastList;
    }

    @Override
    public String toString() {
        return "ResponseDataObject{" +
                "message=" + message +
                ", cnt=" + cnt +
                ", cod=" + cod +
                ", city=" + city +
                ", forecastList=" + Arrays.toString(forecastList) +
                '}';
    }
}
