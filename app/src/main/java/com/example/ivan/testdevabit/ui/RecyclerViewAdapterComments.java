package com.example.ivan.testdevabit.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ivan.testdevabit.R;
import com.example.ivan.testdevabit.entity.Child;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterComments extends RecyclerView.Adapter<RecyclerViewAdapterComments.ViewHolder> {

    private List<Child> mComments = new ArrayList<>();

    public void addNewListings(List<Child> newListings) {
        int positionStart = mComments.size() - 1;
        for (Child child : newListings) {
            if (child.getData().getBodyComment() != null) {
                mComments.add(child);
            }
        }
        notifyItemRangeChanged(positionStart, mComments.size());
    }

    public String getLastName() {
        return mComments.get(mComments.size() - 1).getData().getId();
    }

    @Override
    public RecyclerViewAdapterComments.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterComments.ViewHolder holder, int position) {
        holder.setComment(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewComment;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewComment = itemView.findViewById(R.id.tv_comment);
        }

        public void setComment(Child redditListing) {
            textViewComment.setText(redditListing.getData().getBodyComment());
        }
    }

}
