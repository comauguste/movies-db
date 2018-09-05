package com.wayfair.themoviedb.feature.searchresults.viewmodel

import android.content.res.Resources
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.RatingBar
import com.facebook.drawee.view.SimpleDraweeView
import com.wayfair.brickkit.brick.ViewModel
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel
import com.wayfair.themoviedb.util.Enums
import com.wayfair.themoviedb.util.ImageHelper
import com.wayfair.themoviedb.util.ImageHelper.WIDTH_342
import com.wayfair.themoviedb.util.LabelHelper.getLabel
import com.wayfair.themoviedb.util.LabelHelper.getLabelColor

class SearchResultViewModel(dataModel: SearchResultDataModel?,
                            private val resources: Resources) : ViewModel<SearchResultDataModel>(dataModel) {

    val name: String?
        get() = dataModel.name

    val averageVote: Float
        @Bindable
        get() = dataModel.averageVote ?: 0f


    val ratingBarVisibility: Int
        get() = if (dataModel.mediaType == Enums.MediaType.person.toString()) View.GONE else View.VISIBLE

    val mediaTypeLabel: String
        get() = getLabel(resources, dataModel.mediaType)

    val mediaTypeLabelColor: Int
        @Bindable
        get() = resources.getColor(getLabelColor(dataModel.mediaType))

    fun posterUrl(): String {
        return ImageHelper.generateImageUrl(WIDTH_342, dataModel.imagePath)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(view: SimpleDraweeView, imageUrl: String) {
            view.setImageURI(imageUrl)
        }

        @JvmStatic
        @BindingAdapter("android:rating")
        fun setRating(view: RatingBar, rating: Float) {
            if (view.rating != rating) {
                view.rating = rating
            }
        }
    }

}
