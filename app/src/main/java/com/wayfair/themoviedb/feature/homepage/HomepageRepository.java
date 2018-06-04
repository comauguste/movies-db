package com.wayfair.themoviedb.feature.homepage;

import com.pubbix.base.BaseRepository;

import javax.inject.Inject;

public class HomepageRepository extends BaseRepository<HomepageContract.Interactor>
implements HomepageContract.Repository{
    private HomepageContract.Interactor interactor;
    @Inject
    public HomepageRepository() {
    }

    @Override
    public void setInteractor(HomepageContract.Interactor interactor) {
        this.interactor = interactor;
    }
}
