package com.wayfair.themoviedb.feature.searchresults

import com.wayfair.themoviedb.ui.DefaultScreenNavigator

import javax.inject.Inject

class SearchResultsRouter @Inject
internal constructor(private val navigator: DefaultScreenNavigator) : SearchResultsContract.Router
