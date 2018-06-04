package com.wayfair.themoviedb.data.remote;

import com.wayfair.themoviedb.data.model.response.MultiSearch;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbApi {
    //TODO Extract API key to interceptor.
    String API_KEY = "71ab1b19293efe581c569c1c79d0f004";

    String MULTI_SEARCH_PATH = "search/multi";

    @GET(MULTI_SEARCH_PATH)
    Observable<MultiSearch> search(@Query("api_key") String key, @Query("query") String searchTerms);
}
