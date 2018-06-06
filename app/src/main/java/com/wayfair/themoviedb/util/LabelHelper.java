package com.wayfair.themoviedb.util;

import android.content.res.Resources;

import com.wayfair.themoviedb.R;

public class LabelHelper {
    public static String getLabel(Resources resources, String label) {
        Enums.MediaType mediaType = Enums.MediaType.valueOf(label);
        String textLabel;
        switch (mediaType) {
            case movie:
                textLabel = resources.getString(R.string.movie);
                break;
            case tv:
                textLabel = resources.getString(R.string.tv_show);
                break;
            case person:
                textLabel = resources.getString(R.string.people);
                break;
            default:
                textLabel = "Unknown type";

        }
        return textLabel;
    }

    public static int getLabelColor(String label) {
        Enums.MediaType mediaType = Enums.MediaType.valueOf(label);
        int labelColor;
        switch (mediaType) {
            case movie:
                labelColor = R.color.red_900;
                break;
            case tv:
                labelColor = R.color.green_900;
                break;
            case person:
                labelColor = R.color.light_blue_900;
                break;
            default:
                labelColor = R.color.red_300;

        }
        return labelColor;
    }
}
