package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class Coordinate {
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;

    public Coordinate() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
