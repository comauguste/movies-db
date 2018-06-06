package com.wayfair.themoviedb.feature.searchresults;

import com.pubbix.base.BaseView;
import com.wayfair.themoviedb.base.BaseRouter;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel;

import java.util.List;

public interface SearchResultsContract {
    interface View extends BaseView {
        void showSearchCardView();

        void setSearchViewText(String searchTerms);

        void showSearchResultsHeader(String searchTerms);

        void setSearchResultsHeader(String searchTerms);

        void showProgressBar();

        void hideProgressBar();

        void hideSearchViewVisibility();

        void addSearchResultBrick(SearchResultViewModel searchResultViewModel);
    }

    interface Router extends BaseRouter {

    }

    interface Presenter {
        void setUpViews(String searchTerms);

        void fetchData(String searchTerms);

        void renderSearchResults(List<SearchResultDataModel> searchResultDataModels);
    }

    interface Interactor {
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
