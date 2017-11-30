package com.example.ivan.testdevabit.presentation;


import com.example.ivan.testdevabit.entity.Child;

import java.util.List;

public interface CommentsView extends BaseView {

    void successGetComments(List<Child> redditListings);

    void errorGetComments();
}
