package com.wayfair.themoviedb.feature.searchresults.datamodel

import com.wayfair.brickkit.brick.DataModel
import com.wayfair.themoviedb.data.model.response.Result
import com.wayfair.themoviedb.util.Enums

class SearchResultDataModel(result: Result) : DataModel() {
    val id: Long?
    var name: String? = null
        private set
    val mediaType: String?
    val imagePath: String?
    val voteCount: Long?
    val averageVote: Float?

    init {
        this.id = result.id
        if (result.mediaType == Enums.MediaType.movie.toString()) {
            this.name = result.title
        } else {
            this.name = result.name
        }
        this.mediaType = result.mediaType
        this.imagePath = if (result.mediaType == Enums.MediaType.person.toString())
            getPeoplePicturePath(result)
        else
            result.posterPath
        this.voteCount = result.voteCount
        this.averageVote = result.voteAverage
    }

    open fun getAverageVote(): Float {
        return if (averageVote != null) averageVote / 2 else 0.0f
    }

    private fun getPeoplePicturePath(result: Result): String? {
        if (result.profilePath != null) {
            return result.profilePath
        }

        for (knownFor in result.knownFor!!) {
            if (knownFor.posterPath != null) {
                return knownFor.posterPath
            }
        }
        return null
    }
}
