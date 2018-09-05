package com.wayfair.themoviedb.feature.homepage

import com.pubbix.base.BaseRepository

import javax.inject.Inject

class HomepageRepository @Inject
constructor() : BaseRepository<HomepageContract.Interactor>(), HomepageContract.Repository {
    private var interactor: HomepageContract.Interactor? = null

    override fun setInteractor(interactor: HomepageContract.Interactor) {
        this.interactor = interactor
    }
}
