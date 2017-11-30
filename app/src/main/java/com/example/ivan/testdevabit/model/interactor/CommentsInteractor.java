package com.example.ivan.testdevabit.model.interactor;


import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.repository.CommentsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;

public class CommentsInteractor {

    @Inject CommentsRepository commentsRepository;

    public CommentsInteractor() {
        MyApplication.getAppComponent().inject(this);
    }

    public Single<List<RedditListing>> getComments(String url) {
        url = url.substring(0, url.length() - 1) + ".json";
        return commentsRepository.getComments(url);
    }
}
