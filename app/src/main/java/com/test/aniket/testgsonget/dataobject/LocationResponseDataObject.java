package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Aniket on 3/3/2016.
 */
public class LocationResponseDataObject {
    @SerializedName("message")
    private String message;
    @SerializedName("cnt")
    private int cnt;
    @SerializedName("cod")
    private int cod;
    @SerializedName("list")
    private LocationForecast[] locationForecastList;

    public LocationResponseDataObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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

    public LocationForecast[] getLocationForecastList() {
        return locationForecastList;
    }

    public void setLocationForecastList(LocationForecast[] locationForecastList) {
        this.locationForecastList = locationForecastList;
    }

    @Override
    public String toString() {
        return "LocationResponseDataObject{" +
                "message=" + message +
                ", cnt=" + cnt +
                ", cod=" + cod +
                ", locationForecastList=" + Arrays.toString(locationForecastList) +
                '}';
    }
}
