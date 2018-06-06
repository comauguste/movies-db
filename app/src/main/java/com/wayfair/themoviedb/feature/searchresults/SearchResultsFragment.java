package com.wayfair.themoviedb.feature.searchresults;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.pubbix.base.BaseFragment;
import com.wayfair.brickkit.brick.ViewModelBrick;
import com.wayfair.brickkit.padding.InnerOuterBrickPadding;
import com.wayfair.themoviedb.BR;
import com.wayfair.themoviedb.R;
import com.wayfair.themoviedb.feature.MainActivity;
import com.wayfair.themoviedb.feature.searchresults.datamodel.ProgressBarDataModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.ProgressBarViewModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel;
import com.wayfair.themoviedb.util.brick.FullWidthBrickSize;
import com.wayfair.themoviedb.util.brick.common.ParagraphBrick;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SearchResultsFragment extends BaseFragment<SearchResultsPresenter> implements SearchResultsContract.View {

    private String searchTerms;
    private ParagraphBrick searchResultsHeader;
    private ViewModelBrick progressBarBrick;

    public static Fragment newInstance() {
        Bundle bundle = new Bundle();
        bundle.putString("instance_id", UUID.randomUUID().toString());
        Fragment fragment = new SearchResultsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static SearchResultsFragment newInstance(String searchTerms) {
        Bundle bundle = new Bundle();
        bundle.putString("instance_id", UUID.randomUUID().toString());
        SearchResultsFragment fragment = new SearchResultsFragment();
        fragment.searchTerms = searchTerms;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.setUpViews(searchTerms);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.fetchData(searchTerms);
    }

    @Override
    public void showMessage(@NotNull String message) {

    }

    @Override
    public void showSearchCardView() {
        ((MainActivity) getActivity()).setSearchViewVisibility(View.VISIBLE);
    }

    @Override
    public void setSearchViewText(String searchTerms) {
        ((MainActivity) getActivity()).setSearchViewText(searchTerms);
    }

    @Override
    public void showSearchResultsHeader(String searchTerms) {
        searchResultsHeader = new ParagraphBrick(formatHeaderText(searchTerms));
        dataManager.addLast(searchResultsHeader);
    }

    @Override
    public void setSearchResultsHeader(String searchTerms) {
        searchResultsHeader.setParagraph(formatHeaderText(searchTerms));
        dataManager.refreshItem(searchResultsHeader);
    }

    @Override
    public void showProgressBar() {
        //TODO to be removed
        progressBarBrick = new ViewModelBrick.Builder(R.layout.progress_bar)
                .setSpanSize(new FullWidthBrickSize())
                .addViewModel(BR.viewModel, new ProgressBarViewModel(new ProgressBarDataModel()))
                .build();
        dataManager.addLast(progressBarBrick);
    }

    @Override
    public void hideProgressBar() {
        dataManager.hideItem(progressBarBrick);
    }

    @Override
    public void addSearchResultBrick(SearchResultViewModel searchResultViewModel) {
        dataManager.addLast(new ViewModelBrick.Builder(R.layout.brick_result_card)
                .setPadding(new InnerOuterBrickPadding(8, 8))
                .addViewModel(BR.viewModel, searchResultViewModel)
                .build());
    }

    private String formatHeaderText(String searchTerms) {
        return String.format("Search Results for \"%s\"", searchTerms);
    }
}
