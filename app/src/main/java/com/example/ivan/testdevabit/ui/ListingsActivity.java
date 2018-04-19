package com.example.ivan.testdevabit.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ivan.testdevabit.AppConstants;
import com.example.ivan.testdevabit.R;
import com.example.ivan.testdevabit.entity.Child;
import com.example.ivan.testdevabit.presentation.ListingsPresenter;
import com.example.ivan.testdevabit.presentation.ListingsView;

import java.util.List;

public class ListingsActivity extends MvpAppCompatActivity implements ListingsView, RecyclerViewAdapterListings.ListenerClickItem {

    @InjectPresenter public ListingsPresenter mPresenter;
    private RecyclerView mRecyclerViewListings;
    private LinearLayoutManager mManager;
    private RecyclerViewAdapterListings mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);
        initRecyclerView();
        initViews();
        mPresenter.getListings(AppConstants.EMPTY_NAME);
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.pb_progress_listings);
    }

    private void initRecyclerView() {
        mRecyclerViewListings = findViewById(R.id.rv_listings);
        mManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerViewAdapterListings(this, this);
        mRecyclerViewListings.setAdapter(mAdapter);
        mRecyclerViewListings.setLayoutManager(mManager);
        mRecyclerViewListings.addOnScrollListener(new EndlessRecyclerOnScrollListener(mManager) {
            @Override
            public void onLoadMore(int current_page) {
                mPresenter.getListings(mAdapter.getLastName());
            }
        });
    }

    @Override
    public void successGetListings(List<Child> redditListings) {
        mAdapter.addNewListings(redditListings);
        onClickListing(redditListings.get(0).getData().getPermalink());
    }

    @Override
    public void errorGetListings() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
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
    public void onClickListing(String permalink) {
        CommentsActivity.start(this, permalink);
        Log.d("HUAIWEI TEST", "click on card");
    }
}
