package com.example.ivan.testdevabit.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ivan.testdevabit.AppConstants;
import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.interactor.ListingsInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;

@InjectViewState
public class ListingsPresenter extends MvpPresenter<ListingsView> {

    @Inject ListingsInteractor listingsInteractor;

    public ListingsPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    public void getListings(String nameListing) {
        if (nameListing.equals(AppConstants.EMPTY_NAME)) {
            getViewState().showProgress();
        }
        listingsInteractor.getListings(nameListing)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RedditListing>() {
                    @Override
                    public void onSuccess(RedditListing redditListings) {
                        getViewState().successGetListings(redditListings.getData().getChildren());
                        getViewState().hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().errorGetListings();
                        getViewState().hideProgress();
                    }
                });
    }
}
