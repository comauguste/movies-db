package com.wayfair.themoviedb.feature.homepage

import com.pubbix.base.BaseInteractor
import com.wayfair.themoviedb.di.ScreenScope

import javax.inject.Inject

@ScreenScope
class HomepageInteractor @Inject
constructor(private val repository: HomepageContract.Repository) : BaseInteractor<HomepageContract.Repository>(), HomepageContract.Interactor {
    private var presenter: HomepageContract.Presenter? = null

    init {
        this.repository.setInteractor(this)
    }

    override fun setPresenter(presenter: HomepageContract.Presenter) {
        this.presenter = presenter
    }
}
