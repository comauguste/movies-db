package com.wayfair.themoviedb.feature.searchresults.datamodel;

import com.wayfair.brickkit.brick.DataModel;

public class SearchBarDataModel extends DataModel {
    public String searchText;

    public SearchBarDataModel(String searchText) {
        this.searchText = searchText;
    }
}
