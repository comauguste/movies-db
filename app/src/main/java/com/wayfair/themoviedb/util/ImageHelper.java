package com.wayfair.themoviedb.util;

public class ImageHelper {
    public static final String WIDTH_45 = "w45";
    public static final String WIDTH_92 = "w92";
    public static final String WIDTH_154 = "w154";
    public static final String WIDTH_185 = "w185";
    public static final String WIDTH_342 = "w342";
    public static final String WIDTH_500 = "w500";
    public static final String WIDTH_780 = "w780";
    public static final String HEIGHT_632 = "h632";
    public static final String ORIGINAL = "original";
    private static final String baseUrl = "https://image.tmdb.org/t/p/";

    public static String generateImageUrl(String size, String path) {
        return baseUrl + size + path;
    }
}
