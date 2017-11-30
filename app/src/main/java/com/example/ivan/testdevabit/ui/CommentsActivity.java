package com.example.ivan.testdevabit.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.ivan.testdevabit.R;

public class CommentsActivity extends MvpAppCompatActivity{

    public static final String PERMALINK = "permalink";

    public static void start(Context context, String permalink) {
        Intent starter = new Intent(context, CommentsActivity.class);
        starter.putExtra(PERMALINK, permalink);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }
}
