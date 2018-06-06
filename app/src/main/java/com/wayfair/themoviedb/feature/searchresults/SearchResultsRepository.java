package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BaseRepository;
import com.wayfair.themoviedb.data.model.response.Result;
import com.wayfair.themoviedb.data.remote.MovieDbApi;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SearchResultsRepository extends BaseRepository<SearchResultsContract.Interactor>
        implements SearchResultsContract.Repository {
    private SearchResultsContract.Interactor interactor;

    @Inject
    public SearchResultsRepository() {
    }

    @Override
    public void performMultiSearch(String searchTerms) {
        movieDbApi.search(MovieDbApi.API_KEY, searchTerms)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .map(response -> response.results)
                .subscribe(results -> {
                    List<SearchResultDataModel> searchResultDataModels = new ArrayList<>();
                    for (Result result : results) {
                        searchResultDataModels.add(new SearchResultDataModel(result));
                    }
                    if (!searchResultDataModels.isEmpty()) {
                        interactor.onFetchDataSuccess(searchResultDataModels);
                    } else {
                        //TODO handle empty result
                    }
                }, interactor::onFetchDataFailure);

    }

    @Override
    public void setInteractor(SearchResultsContract.Interactor interactor) {
        this.interactor = interactor;
    }
}
