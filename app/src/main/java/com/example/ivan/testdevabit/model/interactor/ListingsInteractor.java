package com.example.ivan.testdevabit.model.interactor;


import com.example.ivan.testdevabit.MyApplication;
import com.example.ivan.testdevabit.entity.RedditListing;
import com.example.ivan.testdevabit.model.repository.ListingsRepository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import io.reactivex.Single;

public class ListingsInteractor {

    @Inject
    public ListingsRepository listingsRepository;

    public ListingsInteractor() {
        MyApplication.getAppComponent().inject(this);
    }

    public Single<RedditListing> getListings(String name){
        Map<String, String> params = new HashMap<>();
        params.put("after", name);
        return  listingsRepository.getListing(params);
    }
}
