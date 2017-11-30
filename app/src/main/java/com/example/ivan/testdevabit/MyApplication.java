package com.example.ivan.testdevabit;


import android.app.Application;

import com.example.ivan.testdevabit.dagger.AppComponent;
import com.example.ivan.testdevabit.dagger.DaggerAppComponent;
import com.example.ivan.testdevabit.dagger.ListingsModule;

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .listingsModule(new ListingsModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
