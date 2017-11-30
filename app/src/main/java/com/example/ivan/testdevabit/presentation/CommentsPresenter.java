package com.example.ivan.testdevabit.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.model.interactor.CommentsInteractor;

import javax.inject.Inject;

@InjectViewState
public class CommentsPresenter extends MvpPresenter<CommentsView>{

    @Inject
    CommentsInteractor commentsInteractor;

    public CommentsPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    public void getComments(){

    }
}
