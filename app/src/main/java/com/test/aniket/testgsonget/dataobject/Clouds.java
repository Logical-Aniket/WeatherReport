package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 3/3/2016.
 */
public class Clouds {
    @SerializedName("all")
    private int all;

    public Clouds() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
