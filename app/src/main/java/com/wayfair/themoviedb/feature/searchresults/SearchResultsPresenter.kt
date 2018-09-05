package com.wayfair.themoviedb.feature.searchresults

import android.content.res.Resources
import com.pubbix.base.BasePresenter
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel

import javax.inject.Inject

class SearchResultsPresenter @Inject
constructor(private val interactor: SearchResultsContract.Interactor,
            private val router: SearchResultsContract.Router,
            private val resources: Resources) : BasePresenter<SearchResultsContract.View,
        SearchResultsContract.Interactor>(), SearchResultsContract.Presenter {
    init {
        this.interactor.setPresenter(this)
    }

    override fun fetchData(searchTerms: String) {
        interactor.fetchData(searchTerms)
    }

    override fun renderSearchResults(searchResultDataModels: List<SearchResultDataModel>) {
        view?.let {
            it.hideProgressBar()
            searchResultDataModels.forEach { dataModel ->
                it.addSearchResultBrick(SearchResultViewModel(dataModel, resources))
            }
        }

    }
}
