package com.wayfair.themoviedb.feature.homepage

import com.pubbix.base.BasePresenter

import javax.inject.Inject

class HomepagePresenter @Inject
constructor(private val interactor: HomepageContract.Interactor,
            private val router: HomepageContract.Router) : BasePresenter<HomepageContract.View,
        HomepageContract.Interactor>(), HomepageContract.Presenter {

    init {
        this.interactor.setPresenter(this)
    }

    override fun search(searchTerms: String) {
        router.goToSearchPage(searchTerms)
    }
}
