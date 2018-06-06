package com.wayfair.themoviedb.feature.searchresults.datamodel;

import com.wayfair.brickkit.brick.DataModel;
import com.wayfair.themoviedb.data.model.response.KnownFor;
import com.wayfair.themoviedb.data.model.response.Result;
import com.wayfair.themoviedb.util.Enums;

public class SearchResultDataModel extends DataModel {
    private Long id;
    private String name;
    private String mediaType;
    private String imagePath;
    private Long voteCount;
    private Double averageVote;

    public SearchResultDataModel(Result result) {
        this.id = result.id;
        if (result.mediaType.equals(Enums.MediaType.movie.toString())) {
            this.name = result.title;
        } else {
            this.name = result.name;
        }
        this.mediaType = result.mediaType;
        this.imagePath = result.mediaType.equals(Enums.MediaType.person.toString()) ?
                getPeoplePicturePath(result) : result.posterPath;
        this.voteCount = result.voteCount;
        this.averageVote = result.voteAverage;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public Double getAverageVote() {
        return averageVote / 2;
    }

    private String getPeoplePicturePath(Result result) {
        if (result.profilePath != null) {
            return result.profilePath;
        }

        for (KnownFor knownFor : result.knownFor) {
            if (knownFor.posterPath != null) {
                return knownFor.posterPath;
            }
        }
        return null;
    }
}
