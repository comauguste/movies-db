
package com.wayfair.themoviedb.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KnownFor {

    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("video")
    @Expose
    public Boolean video;
    @SerializedName("media_type")
    @Expose
    public String mediaType;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_title")
    @Expose
    public String originalTitle;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = null;
    @SerializedName("backdrop_path")
    @Expose
    public Object backdropPath;
    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("release_date")
    @Expose
    public String releaseDate;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = null;

}
