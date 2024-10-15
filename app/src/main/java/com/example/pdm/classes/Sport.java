package com.example.pdm.classes;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

import com.example.pdm.java.activities.listas.DetailActivity;

public class Sport {


    //Member variables representing the title, image and information about the sport
    private final String title;
    private final String info;
    private final int imageResource;

    public static final String TITLE_KEY = "Title";
    public static final String IMAGE_KEY = "Image Resource";

    /**
     * Constructor for the Sport class data model
     * @param title The name if the sport.
     * @param info Information about the sport.
     * @param imageResource The resource for the sport image
     */
    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    public String getInfo() {
        return info;
    }

    /**
     * Gets the resource for the image
     * @return The resource for the image
     */
    public int getImageResource() {
        return imageResource;
    }


    /**
     * Method for creating  the Detail Intent
     * @param context Application context, used for launching the Intent
     * @param title The title of the current Sport
     * @param imageResId The image resource associated with the current sport
     * @return The Intent containing the extras about the sport, launches Detail activity
     */
    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
