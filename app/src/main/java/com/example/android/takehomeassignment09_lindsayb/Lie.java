package com.example.android.takehomeassignment09_lindsayb;

/**
 * Created by lindsaybaer on 4/3/17.
 */

import java.io.Serializable;

public class Lie implements Serializable {
    private String lie;
    private int scale;
    private boolean russian;

    public Lie(String lie, int scale, boolean russian) {
        this.lie = lie;
        this.scale = scale;
        this.russian = russian;
    }

    public Lie()
    {
    }

    public String getLie() {
        return lie;
    }

    public void setLie(String lie) {
        this.lie = lie;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isRussian() {
        return russian;
    }

    public void setRussian(boolean russian) {
        this.russian = russian;
    }

    @Override
    public String toString() {
        return "Tracker: " + "\n" +
                "Lie: " + lie + "\n" +
                "Outrageous Scale: " + scale + "\n" +
                "Russian: " + russian + "\n" + "\n";
    }
}
