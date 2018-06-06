package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BasePresenter;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel;

import java.util.List;

import javax.inject.Inject;

public class SearchResultsPresenter extends BasePresenter<SearchResultsFragment, SearchResultsContract.Interactor>
        implements SearchResultsContract.Presenter {
    private SearchResultsFragment view;
    private SearchResultsContract.Interactor interactor;
    private SearchResultsContract.Router router;
    @Inject
    public SearchResultsPresenter(SearchResultsFragment view,
                                  SearchResultsContract.Interactor interactor,
                                  SearchResultsContract.Router router) {
        this.view = view;
        this.interactor = interactor;
        this.interactor.setPresenter(this);
        this.router = router;
    }

    @Override
    public void setUpViews(String searchTerms) {
        view.showSearchCardView();
        view.setSearchViewText(searchTerms);
        view.showSearchResultsHeader(searchTerms);
        view.showProgressBar();
    }

    @Override
    public void fetchData(String searchTerms) {
        interactor.fetchData(searchTerms);
    }

    @Override
    public void renderSearchResults(List<SearchResultDataModel> searchResultDataModels) {
        view.hideProgressBar();
        for (SearchResultDataModel searchResultDataModel : searchResultDataModels){
            //TODO inject resources
            view.addSearchResultBrick(new SearchResultViewModel(searchResultDataModel, view.getResources()));
        }
    }
}
