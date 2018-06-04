package com.wayfair.themoviedb.feature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.wayfair.themoviedb.R;
import com.wayfair.themoviedb.base.BaseActivity;
import com.wayfair.themoviedb.feature.homepage.HomepageFragment;
import com.wayfair.themoviedb.ui.DefaultScreenNavigator;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    DefaultScreenNavigator navigator;

    LinearLayout searchViewLayout;
    SearchView searchView;
    ImageButton backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        searchViewLayout = findViewById(R.id.search_view_layout);
        searchView = findViewById(R.id.search_view);
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> navigator.pop());
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment initialScreen() {
        return HomepageFragment.newInstance();
    }

    public void setSearchViewVisibility(int visibility){
        searchViewLayout.setVisibility(visibility);
    }

    public void setSearchViewText(String searchTerms){
        searchView.setQuery(searchTerms, false);
    }

}
