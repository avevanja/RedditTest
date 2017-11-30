package com.example.ivan.testdevabit.model.repository;


import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.data.server.RetrofitBuilder;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class CommentsRepository {

    public Single<List<RedditListing>> getComments(String url){
        return RetrofitBuilder.getRedditApiWithRx()
                .getComments(url)
                .subscribeOn(Schedulers.io());
    }
}
