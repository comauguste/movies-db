package com.wayfair.themoviedb.feature.homepage

import com.wayfair.themoviedb.base.BaseRouter
import com.wayfair.themoviedb.base.BaseView

interface HomepageContract {
    interface View : BaseView

    interface Router : BaseRouter {
        fun goToSearchPage(searchTerms: String)
    }

    interface Presenter {

        fun search(searchTerms: String)
    }

    interface Interactor {
        fun setPresenter(presenter: Presenter)

    }

    interface Repository {
        fun setInteractor(interactor: Interactor)
    }
}
