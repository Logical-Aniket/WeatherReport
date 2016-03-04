package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class Temperature {
    @SerializedName("morn")
    private double morn;
    @SerializedName("min")
    private double min;
    @SerializedName("night")
    private double night;
    @SerializedName("eve")
    private double eve;
    @SerializedName("max")
    private double max;
    @SerializedName("day")
    private double day;

    public Temperature() {
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "morn=" + morn +
                ", min=" + min +
                ", night=" + night +
                ", eve=" + eve +
                ", max=" + max +
                ", day=" + day +
                '}';
    }
}
