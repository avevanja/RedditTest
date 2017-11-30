package com.example.ivan.testdevabit.model.interactor;


import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.repository.CommentsRepository;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

public class CommentsInteractor {

    @Inject
    CommentsRepository commentsRepository;

    public CommentsInteractor() {
        MyApplication.getAppComponent().inject(this);
    }

    public Single<List<RedditListing>> getComments(String url){

       return commentsRepository.getComments(url);

    }
}
