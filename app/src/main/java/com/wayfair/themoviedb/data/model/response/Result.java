
package com.wayfair.themoviedb.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("media_type")
    @Expose
    public String mediaType;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = null;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("backdrop_path")
    @Expose
    public Object backdropPath;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = null;
    @SerializedName("video")
    @Expose
    public Boolean video;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("original_title")
    @Expose
    public String originalTitle;
    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("release_date")
    @Expose
    public String releaseDate;
    @SerializedName("profile_path")
    @Expose
    public Object profilePath;
    @SerializedName("known_for")
    @Expose
    public List<KnownFor> knownFor = null;

}
