package com.wayfair.themoviedb.feature.homepage

import com.wayfair.themoviedb.di.ScreenScope
import com.wayfair.themoviedb.feature.searchresults.SearchResultsFragment
import com.wayfair.themoviedb.ui.DefaultScreenNavigator

import javax.inject.Inject

@ScreenScope
class HomepageRouter @Inject
internal constructor(private val navigator: DefaultScreenNavigator) : HomepageContract.Router {

    override fun goToSearchPage(searchTerms: String) {
        navigator.changeScreen(SearchResultsFragment.newInstance(searchTerms))
    }
}
