package com.wayfair.themoviedb.feature.searchresults.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.wayfair.brickkit.brick.ViewModel;
import com.wayfair.themoviedb.BR;
import com.wayfair.themoviedb.feature.searchresults.datamodel.SearchBarDataModel;

import org.jetbrains.annotations.NotNull;

public class SearchBarViewModel extends ViewModel<SearchBarDataModel> {

    private String query;
    private Interactions interactions;

    public SearchBarViewModel(@NotNull SearchBarDataModel dataModel, Interactions interactions) {
        super(dataModel);
        this.interactions = interactions;
        query = dataModel.searchText;
    }

    @Bindable
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
        notifyPropertyChanged(BR.query);
    }

    @BindingAdapter("query")
    public static void setQuery(SearchView searchView, String queryText) {
        searchView.setQuery(queryText, false);
    }

    @BindingAdapter("queryTextListener")
    public static void setOnQueryTextListener(SearchView searchView, SearchView.OnQueryTextListener listener) {
        searchView.setOnQueryTextListener(listener);
    }

    public final SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            interactions.onSearchMovies(query);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Bindable
    public View.OnClickListener getOnButtonClicked() {
        return view -> interactions.onBackButtonClicked();
    }

    public interface Interactions {
        void onSearchMovies(String searchTerm);

        void onBackButtonClicked();
    }
}
