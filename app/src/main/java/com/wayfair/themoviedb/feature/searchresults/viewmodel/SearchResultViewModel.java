package com.wayfair.themoviedb.feature.searchresults.viewmodel;

import android.support.annotation.Nullable;

import com.wayfair.brickkit.brick.ViewModel;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;

public class SearchResultViewModel extends ViewModel<SearchResultDataModel> {
    public SearchResultViewModel(@Nullable SearchResultDataModel dataModel) {
        super(dataModel);
    }


}
