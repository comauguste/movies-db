package com.wayfair.themoviedb.feature.homepage;

import com.pubbix.base.BasePresenter;

import javax.inject.Inject;

public class HomepagePresenter extends BasePresenter<HomepageFragment, HomepageContract.Interactor>
implements HomepageContract.Presenter{
    private HomepageFragment view;
    private HomepageContract.Interactor interactor;
    private HomepageContract.Router router;

    @Inject
    public HomepagePresenter(HomepageFragment view,
                             HomepageContract.Interactor interactor,
                             HomepageContract.Router router) {
        this.view = view;
        this.interactor = interactor;
        this.interactor.setPresenter(this);
        this.router = router;
    }

    @Override
    public void setUpViews() {
        view.setOnQueryTextListener();
    }

    @Override
    public void search(String searchTerms) {
        router.goToSearchPage(searchTerms);
    }

    @Override
    public void setInteractor(HomepageContract.Interactor interactor) {

    }
}
