package com.wayfair.themoviedb.feature.searchresults;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SearchResultsScreenModule {
    @Binds
    abstract SearchResultsContract.Presenter providesSearchResultsPresenter(SearchResultsPresenter presenter);

    @Binds
    abstract SearchResultsContract.Interactor providesSearchResultsInteractor(SearchResultsInteractor interactor);

    @Binds
    abstract SearchResultsContract.Repository providesSearchResultsRepository(SearchResultsRepository repository);

    @Binds
    abstract SearchResultsContract.Router providesSearchResultsRouter(SearchResultsRouter router);
}
