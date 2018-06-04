package com.wayfair.themoviedb.feature.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pubbix.base.BaseFragment;
import com.wayfair.themoviedb.R;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class HomepageFragment extends BaseFragment<HomepagePresenter> implements HomepageContract.View {

    private SearchView searchView;

    public static Fragment newInstance() {
        Bundle bundle = new Bundle();
        bundle.putString("instance_id", UUID.randomUUID().toString());
        Fragment fragment = new HomepageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        searchView = view.findViewById(R.id.search_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.setUpViews();
    }

    @Override
    public void showMessage(@NotNull String message) {

    }

    @Override
    public void setOnQueryTextListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //TODO Needs to add check here
                presenter.search(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}
