package com.example.ivan.testdevabit.dagger;


import com.example.ivan.testdevabit.model.interactor.ListingsInteractor;
import com.example.ivan.testdevabit.model.repository.ListingsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ListingsModule {

    @Provides
    @Singleton
    public ListingsInteractor providesListingInteractor(){
        return new ListingsInteractor();
    }

    @Provides
    @Singleton
    public ListingsRepository providesListingRepository(){
        return new ListingsRepository();
    }

}
