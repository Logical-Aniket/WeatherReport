package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class Weather {
    @SerializedName("id")
    private int id;
    @SerializedName("icon")
    private String icon;
    @SerializedName("description")
    private String description;
    @SerializedName("main")
    private String main;

    public Weather() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", main='" + main + '\'' +
                '}';
    }
}

