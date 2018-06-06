package com.wayfair.themoviedb.feature.searchresults.viewmodel;

import android.content.res.Resources;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.widget.RatingBar;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wayfair.brickkit.brick.ViewModel;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;
import com.wayfair.themoviedb.util.ImageHelper;

import org.jetbrains.annotations.NotNull;

import static com.wayfair.themoviedb.util.ImageHelper.WIDTH_342;
import static com.wayfair.themoviedb.util.LabelHelper.getLabel;
import static com.wayfair.themoviedb.util.LabelHelper.getLabelColor;

public class SearchResultViewModel extends ViewModel<SearchResultDataModel> {
    private Resources resources;

    public SearchResultViewModel(@Nullable SearchResultDataModel dataModel,
                                 @NotNull Resources resources) {
        super(dataModel);
        this.resources = resources;
    }

    public String getName() {
        return dataModel.getName();
    }

    public String posterUrl() {
        return ImageHelper.generateImageUrl(WIDTH_342, dataModel.getImagePath());
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(SimpleDraweeView view, String imageUrl) {
        view.setImageURI(imageUrl);
    }

    @Bindable
    public float getAverageVote() {
        return dataModel.getAverageVote() != null ? dataModel.getAverageVote().floatValue() : 0f;
    }

    @BindingAdapter("android:rating")
    public static void setRating(RatingBar view, float rating) {
        if (view.getRating() != rating) {
            view.setRating(rating);
        }
    }

    public String getMediaTypeLabel() {
        return getLabel(resources, dataModel.getMediaType());
    }

    @ColorRes
    @Bindable
    public int getMediaTypeLabelColor() {
        return getLabelColor(dataModel.getMediaType());
    }

}
