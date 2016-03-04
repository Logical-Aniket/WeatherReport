package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 3/3/2016.
 */
public class Wind {
    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private double deg;

    public Wind() {
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}