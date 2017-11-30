package com.example.ivan.testdevabit.model.repository;


import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.data.server.RetrofitBuilder;

import java.util.List;
import java.util.Map;


import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ListingsRepository {

    public Single<RedditListing> getListing(Map<String, String> params){
        return RetrofitBuilder.getRedditApiWithRx().getRedditListing(params)
                .subscribeOn(Schedulers.io());
    }
}
