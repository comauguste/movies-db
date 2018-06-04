package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BaseRepository;
import com.wayfair.themoviedb.data.remote.MovieDbApi;

import javax.inject.Inject;

public class SearchResultsRepository extends BaseRepository<SearchResultsContract.Interactor>
implements SearchResultsContract.Repository{
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
                .subscribe(interactor::onFetchDataSuccess, interactor::onFetchDataFailure);

    }

    @Override
    public void setInteractor(SearchResultsContract.Interactor interactor) {
        this.interactor = interactor;
    }
}
