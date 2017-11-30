package com.example.ivan.testdevabit.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ivan.testdevabit.AppConstants;
import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.interactor.CommentsInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;

@InjectViewState
public class CommentsPresenter extends MvpPresenter<CommentsView> {

    @Inject
    CommentsInteractor commentsInteractor;
    private int positionCommentsList = 1;

    public CommentsPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    public void getComments(String url, String name) {
        getViewState().showProgress();
        commentsInteractor.getComments(url, name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<RedditListing>>() {
                    @Override
                    public void onSuccess(List<RedditListing> redditListings) {
                        getViewState().hideProgress();
                        getViewState().successGetComments(redditListings.get(positionCommentsList).getData().getChildren());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().errorGetComments();
                        getViewState().hideProgress();
                    }
                });
    }
}
