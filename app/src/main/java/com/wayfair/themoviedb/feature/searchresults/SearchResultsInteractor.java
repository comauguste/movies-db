package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BaseInteractor;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

public class SearchResultsInteractor extends BaseInteractor<SearchResultsContract.Repository>
        implements SearchResultsContract.Interactor {
    private SearchResultsContract.Presenter presenter;
    private SearchResultsContract.Repository repository;

    @Inject
    public SearchResultsInteractor(SearchResultsContract.Repository repository) {
        this.repository = repository;
        this.repository.setInteractor(this);
    }

    @Override
    public void fetchData(String searchTerms) {
        repository.performMultiSearch(searchTerms);
    }

    @Override
    public void onFetchDataSuccess(List<SearchResultDataModel> searchResultDataModels) {
        presenter.renderSearchResults(searchResultDataModels);
    }

    @Override
    public void onFetchDataFailure(Throwable throwable) {
        Timber.e(throwable);
    }

    @Override
    public void setPresenter(SearchResultsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
