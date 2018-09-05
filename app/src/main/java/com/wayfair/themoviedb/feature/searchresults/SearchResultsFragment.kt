package com.wayfair.themoviedb.feature.searchresults

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.pubbix.base.BaseFragment
import com.wayfair.brickkit.brick.ViewModelBrick
import com.wayfair.brickkit.padding.InnerOuterBrickPadding
import com.wayfair.themoviedb.BR
import com.wayfair.themoviedb.R
import com.wayfair.themoviedb.feature.searchresults.datamodel.ProgressBarDataModel
import com.wayfair.themoviedb.feature.searchresults.viewmodel.ProgressBarViewModel
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel
import com.wayfair.themoviedb.util.brick.FullWidthBrickSize
import com.wayfair.themoviedb.util.brick.common.ParagraphBrick
import java.util.*

class SearchResultsFragment : BaseFragment<SearchResultsPresenter>(), SearchResultsContract.View {

    private lateinit var searchTerms: String
    private var searchResultsHeader: ParagraphBrick? = null
    private var progressBarBrick: ViewModelBrick? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_search_page, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        dataManager.setRecyclerView(context, recyclerView, OrientationHelper.VERTICAL, false, view)
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val backButton = view.findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener { fragmentManager?.popBackStackImmediate() }
        val searchView = view.findViewById<SearchView>(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (!query.isEmpty()) {
                    presenter.fetchData(query)
                }
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })

        setUpViews(searchTerms)

    }

    override fun onStart() {
        super.onStart()
        presenter.fetchData(searchTerms)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }

    private fun setUpViews(searchTerms: String) {
        showSearchCardView()
        setSearchViewText(searchTerms)
        showSearchResultsHeader(searchTerms)
        showProgressBar()
    }

    override fun showMessage(message: String) {

    }

    override fun showSearchCardView() {
    }

    override fun setSearchViewText(searchTerms: String) {
    }

    override fun showSearchResultsHeader(searchTerms: String) {
        searchResultsHeader = ParagraphBrick(formatHeaderText(searchTerms))
        dataManager.addLast(searchResultsHeader!!)
    }

    override fun setSearchResultsHeader(searchTerms: String) {
        searchResultsHeader!!.setParagraph(formatHeaderText(searchTerms))
        dataManager.refreshItem(searchResultsHeader)
    }

    override fun showProgressBar() {
        //TODO to be removed
        progressBarBrick = ViewModelBrick.Builder(R.layout.progress_bar)
                .setSpanSize(FullWidthBrickSize())
                .addViewModel(BR.viewModel, ProgressBarViewModel(ProgressBarDataModel()))
                .build()
        dataManager.addLast(progressBarBrick!!)
    }

    override fun hideProgressBar() {
        dataManager.hideItem(progressBarBrick!!)
    }

    override fun hideSearchViewVisibility() {
    }

    override fun addSearchResultBrick(searchResultViewModel: SearchResultViewModel) {
        dataManager.addLast(ViewModelBrick.Builder(R.layout.brick_result_card)
                .setPadding(InnerOuterBrickPadding(8, 8))
                .addViewModel(BR.viewModel, searchResultViewModel)
                .build())
    }

    private fun formatHeaderText(searchTerms: String): String {
        return String.format("Search Results for \"%s\"", searchTerms)
    }

    companion object {

        fun newInstance(): Fragment {
            val bundle = Bundle()
            bundle.putString("instance_id", UUID.randomUUID().toString())
            val fragment = SearchResultsFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newInstance(searchTerms: String): SearchResultsFragment {
            val bundle = Bundle()
            bundle.putString("instance_id", UUID.randomUUID().toString())
            val fragment = SearchResultsFragment()
            fragment.searchTerms = searchTerms
            fragment.arguments = bundle
            return fragment
        }
    }
}
