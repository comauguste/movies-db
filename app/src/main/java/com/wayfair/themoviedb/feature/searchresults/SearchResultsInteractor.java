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
    private SearchResultsContract.Router router;
    private String searchTerms = "";

    @Inject
    public SearchResultsInteractor(SearchResultsContract.Repository repository,
                                   SearchResultsContract.Router router) {
        this.repository = repository;
        this.repository.setInteractor(this);
        this.router = router;
    }

    @Override
    public void fetchData(String searchTerms) {
        this.searchTerms = searchTerms;
        repository.performMultiSearch(searchTerms);
    }

    @Override
    public void onFetchDataSuccess(List<SearchResultDataModel> searchResultDataModels) {
        presenter.renderSearchResults(searchResultDataModels, searchTerms);
    }

    @Override
    public void onFetchDataFailure(Throwable throwable) {
        Timber.e(throwable);
    }

    @Override
    public void setPresenter(SearchResultsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onSearchMovies(String searchTerm) {
        this.searchTerms = searchTerm;
        repository.performMultiSearch(searchTerm);
    }

    @Override
    public void onBackButtonClicked() {
        router.goBack();
    }
}
