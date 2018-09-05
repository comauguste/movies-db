package com.wayfair.themoviedb.feature.searchresults

import com.pubbix.base.BaseRepository
import com.wayfair.themoviedb.data.model.response.Result
import com.wayfair.themoviedb.data.remote.MovieDbApi
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchResultDataModel
import javax.inject.Inject

class SearchResultsRepository @Inject
constructor() : BaseRepository<SearchResultsContract.Interactor>(), SearchResultsContract.Repository {
    private var interactor: SearchResultsContract.Interactor? = null

    override fun performMultiSearch(searchTerms: String) {
        movieDbApi.search(MovieDbApi.API_KEY, searchTerms)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .map<List<Result>> { response -> response.results }
                .subscribe {
                    val searchResultDataModels = ArrayList<SearchResultDataModel>()
                    for (result in it) {
                        searchResultDataModels.add(SearchResultDataModel(result))
                    }
                    if (!searchResultDataModels.isEmpty()) {
                        interactor!!.onFetchDataSuccess(searchResultDataModels)
                    } else {
                        //TODO handle empty result
                    }
                }
    }

    override fun setInteractor(interactor: SearchResultsContract.Interactor) {
        this.interactor = interactor
    }
}
