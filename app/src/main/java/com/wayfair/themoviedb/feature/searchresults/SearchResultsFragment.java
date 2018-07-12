package com.wayfair.themoviedb.feature.searchresults;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pubbix.base.BaseFragment;
import com.wayfair.brickkit.brick.ViewModelBrick;
import com.wayfair.brickkit.padding.InnerOuterBrickPadding;
import com.wayfair.themoviedb.BR;
import com.wayfair.themoviedb.R;
import com.wayfair.themoviedb.databinding.FragmentSearchResultsBinding;
import com.wayfair.themoviedb.feature.searchresults.datamodel.ProgressBarDataModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.ProgressBarViewModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchBarViewModel;
import com.wayfair.themoviedb.feature.searchresults.viewmodel.SearchResultViewModel;
import com.wayfair.themoviedb.util.brick.FullWidthBrickSize;
import com.wayfair.themoviedb.util.brick.common.ParagraphBrick;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SearchResultsFragment extends BaseFragment<SearchResultsPresenter> implements SearchResultsContract.View {

    private String searchTerms;
    private ViewModelBrick progressBarBrick;
    private FragmentSearchResultsBinding binding;

    public static SearchResultsFragment newInstance(String searchTerms) {
        Bundle bundle = new Bundle();
        bundle.putString("instance_id", UUID.randomUUID().toString());
        SearchResultsFragment fragment = new SearchResultsFragment();
        fragment.searchTerms = searchTerms;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_results, container, false);
        dataManager.setRecyclerView(getContext(), binding.getRoot().findViewById(R.id.recycler_view),
                OrientationHelper.VERTICAL, false, binding.getRoot());

        return binding.getRoot();
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
    public void addSearchBarViewModel(SearchBarViewModel viewModel) {
        binding.setViewModel(viewModel);
    }

    @Override
    public void addSearchResultsHeader(String searchTerms) {
        dataManager.addLast(new ParagraphBrick(formatHeaderText(searchTerms)));
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

    @Override
    public void clear() {
        dataManager.clear();
    }

    private String formatHeaderText(String searchTerms) {
        return String.format("Search Results for \"%s\"", searchTerms);
    }
}
