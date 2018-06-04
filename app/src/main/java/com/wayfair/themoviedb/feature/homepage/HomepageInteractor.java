package com.wayfair.themoviedb.feature.homepage;

import com.pubbix.base.BaseInteractor;
import com.wayfair.themoviedb.di.ScreenScope;

import javax.inject.Inject;

@ScreenScope
public class HomepageInteractor extends BaseInteractor<HomepageContract.Repository>
implements HomepageContract.Interactor{
    private HomepageContract.Presenter presenter;
    private HomepageContract.Repository repository;
    @Inject
    public HomepageInteractor(HomepageContract.Repository repository) {
        this.repository = repository;
        this.repository.setInteractor(this);
    }

    @Override
    public void setPresenter(HomepageContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
