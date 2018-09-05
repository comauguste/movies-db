package com.wayfair.themoviedb.feature.searchresults

import com.pubbix.base.BaseInteractor
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel
import timber.log.Timber
import javax.inject.Inject

class SearchResultsInteractor @Inject
constructor(private val repository: SearchResultsContract.Repository) : BaseInteractor<SearchResultsContract.Repository>(), SearchResultsContract.Interactor {
    private var presenter: SearchResultsContract.Presenter? = null

    init {
        this.repository.setInteractor(this)
    }

    override fun fetchData(searchTerms: String) {
        repository.performMultiSearch(searchTerms)
    }

    override fun onFetchDataSuccess(searchResultDataModels: List<SearchResultDataModel>) {
        presenter?.renderSearchResults(searchResultDataModels)
    }

    override fun onFetchDataFailure(throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun setPresenter(presenter: SearchResultsContract.Presenter) {
        this.presenter = presenter
    }
}
