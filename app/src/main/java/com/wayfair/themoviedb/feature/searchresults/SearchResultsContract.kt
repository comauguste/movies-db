package com.wayfair.themoviedb.feature.searchresults

import com.wayfair.themoviedb.base.BaseRouter
import com.wayfair.themoviedb.base.BaseView
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel

interface SearchResultsContract {
    interface View : BaseView {
        fun showSearchCardView()

        fun setSearchViewText(searchTerms: String)

        fun showSearchResultsHeader(searchTerms: String)

        fun setSearchResultsHeader(searchTerms: String)

        fun showProgressBar()

        fun hideProgressBar()

        fun hideSearchViewVisibility()

        fun addSearchResultBrick(searchResultViewModel: SearchResultViewModel)
    }

    interface Router : BaseRouter

    interface Presenter {
        fun fetchData(searchTerms: String)

        fun renderSearchResults(searchResultDataModels: List<SearchResultDataModel>)
    }

    interface Interactor {
        fun fetchData(searchTerms: String)

        fun onFetchDataSuccess(searchResultDataModels: List<SearchResultDataModel>)

        fun onFetchDataFailure(throwable: Throwable)

        fun setPresenter(presenter: Presenter)
    }

    interface Repository {
        fun performMultiSearch(searchTerms: String)

        fun setInteractor(interactor: Interactor)
    }
}
