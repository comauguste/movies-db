package com.wayfair.themoviedb.feature.searchresults;

import com.wayfair.themoviedb.ui.DefaultScreenNavigator;

import javax.inject.Inject;

public class SearchResultsRouter implements SearchResultsContract.Router {
    private DefaultScreenNavigator navigator;

    @Inject
    SearchResultsRouter(DefaultScreenNavigator navigator) {
        this.navigator = navigator;
    }
}
