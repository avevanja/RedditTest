package com.example.ivan.testdevabit.dagger;


import com.example.ivan.testdevabit.model.interactor.CommentsInteractor;
import com.example.ivan.testdevabit.model.interactor.ListingsInteractor;
import com.example.ivan.testdevabit.model.repository.CommentsRepository;
import com.example.ivan.testdevabit.presentation.CommentsPresenter;
import com.example.ivan.testdevabit.presentation.ListingsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ListingsModule.class})
public interface AppComponent {

    void inject(ListingsInteractor listingsInteractor);

    void inject(ListingsPresenter listingsPresenter);

    void inject(CommentsInteractor commentsInteractor);

    void inject(CommentsPresenter commentsPresenter);

}
