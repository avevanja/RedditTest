package com.example.ivan.testdevabit.dagger;


import com.example.ivan.testdevabit.model.interactor.CommentsInteractor;
import com.example.ivan.testdevabit.model.repository.CommentsRepository;

import javax.inject.Singleton;

import dagger.Provides;

public class CommentsModule {

    @Provides
    @Singleton
    public CommentsInteractor providesCommentsInteractor(){
        return new CommentsInteractor();
    }

    @Provides
    @Singleton
    public CommentsRepository providesCommentsRepository(){
        return new CommentsRepository();
    }
}
