package com.test.aniket.testgsonget.dataobject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aniket on 23-Feb-16.
 */
public class City {
    @SerializedName("id")
    private long id;
    @SerializedName("population")
    private long population;
    @SerializedName("country")
    private String country;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private Coordinate coord;

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", population=" + population +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                '}';
    }
}
