package com.wayfair.themoviedb.feature.homepage;

import com.pubbix.base.BaseView;
import com.wayfair.themoviedb.base.BaseRouter;

public interface HomepageContract {
    interface View extends BaseView {
        void setOnQueryTextListener();
    }

    interface Router extends BaseRouter {
        void goToSearchPage(String searchTerms);
    }

    interface Presenter {
        void setUpViews();

        void search(String searchTerms);

        void setInteractor(Interactor interactor);
    }

    interface Interactor {
        void setPresenter(Presenter presenter);

    }

    interface Repository{
        void setInteractor(Interactor interactor);
    }
}
