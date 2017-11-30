package com.example.ivan.testdevabit.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ivan.testdevabit.AppConstants;
import com.example.ivan.testdevabit.R;
import com.example.ivan.testdevabit.entity.Child;
import com.example.ivan.testdevabit.presentation.CommentsPresenter;
import com.example.ivan.testdevabit.presentation.CommentsView;

import java.util.List;

public class CommentsActivity extends MvpAppCompatActivity implements CommentsView {

    @InjectPresenter CommentsPresenter mCommentsPresenter;
    public static final String PERMALINK = "permalink";
    private String mPermalink;
    private RecyclerView mRecyclerViewComments;
    private RecyclerViewAdapterComments mAdapter;
    private LinearLayoutManager mManager;
    private ProgressBar mProgressBar;


    public static void start(Context context, String permalink) {
        Intent starter = new Intent(context, CommentsActivity.class);
        starter.putExtra(PERMALINK, permalink);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initView();
        initRecyclerView();
        getIntentData();
        mCommentsPresenter.getComments(mPermalink, AppConstants.EMPTY_NAME);
    }

    private void initView() {
        mProgressBar = findViewById(R.id.pb_progress_comments);
    }

    private void initRecyclerView() {
        mRecyclerViewComments = findViewById(R.id.rv_comments);
        mAdapter = new RecyclerViewAdapterComments();
        mManager = new LinearLayoutManager(this);
        mRecyclerViewComments.setAdapter(mAdapter);
        mRecyclerViewComments.setLayoutManager(mManager);
        mRecyclerViewComments.addOnScrollListener(new EndlessRecyclerOnScrollListener(mManager) {
            @Override
            public void onLoadMore(int current_page) {
                mCommentsPresenter.getComments(mPermalink, mAdapter.getLastName());
            }
        });
    }


    private void getIntentData() {
        if (getIntent().getExtras() != null)
            mPermalink = getIntent().getExtras().getString(PERMALINK);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void successGetComments(List<Child> redditListings) {
        mAdapter.addNewListings(redditListings);
    }

    @Override
    public void errorGetComments() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
    }
}
