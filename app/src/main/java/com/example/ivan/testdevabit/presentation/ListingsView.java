package com.example.ivan.testdevabit.presentation;

import com.example.ivan.testdevabit.entity.Child;

import java.util.List;

public interface ListingsView extends BaseView {

    void successGetListings(List<Child> redditListings);

    void errorGetListings();
}
