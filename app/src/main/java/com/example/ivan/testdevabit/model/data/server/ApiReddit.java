package com.example.ivan.testdevabit.model.data.server;


import com.example.ivan.testdevabit.entity.RedditListing;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiReddit {

    @GET("/r/all/top.json")
    Single<RedditListing> getRedditListing(@QueryMap Map<String, String> params);

    @GET("{permalink}")
    Single<List<RedditListing>> getComments(@Path("permalink") String url);
}
