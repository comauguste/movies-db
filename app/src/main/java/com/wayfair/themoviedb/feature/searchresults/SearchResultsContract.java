package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BaseView;
import com.wayfair.themoviedb.base.BaseRouter;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchBarViewModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel;

import java.util.List;

public interface SearchResultsContract {
    interface View extends BaseView {
        void addSearchBarViewModel(SearchBarViewModel viewModel);

        void addSearchResultsHeader(String searchTerms);

        void showProgressBar();

        void hideProgressBar();

        void addSearchResultBrick(SearchResultViewModel searchResultViewModel);

        void clear();
    }

    interface Router extends BaseRouter {
        void goBack();
    }

    interface Presenter {
        void setUpViews(String searchTerms);

        void fetchData(String searchTerms);

        void renderSearchResults(List<SearchResultDataModel> searchResultDataModels, String searchTerms);
    }

    interface Interactor  extends SearchBarViewModel.Interactions{
        void fetchData(String searchTerms);

        void onFetchDataSuccess(List<SearchResultDataModel> searchResultDataModels);

        void onFetchDataFailure(Throwable throwable);

        void setPresenter(Presenter presenter);
    }

    interface Repository {
        void performMultiSearch(String searchTerms);

        void setInteractor(Interactor interactor);
    }
}
