package com.example.ivan.testdevabit.ui;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ivan.testdevabit.R;
import com.example.ivan.testdevabit.entity.Child;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterListings extends RecyclerView.Adapter<RecyclerViewAdapterListings.ViewHolder> {

    private List<Child> mListings = new ArrayList<>();
    private Context mContext;
    private ListenerClickItem mListenerClickItem;

    public RecyclerViewAdapterListings(Context mContext, ListenerClickItem mListenerClickItem) {
        this.mContext = mContext;
        this.mListenerClickItem = mListenerClickItem;
    }

    public void addNewListings(List<Child> newListings) {
        int positionStart = mListings.size() - 1;
        mListings.addAll(newListings);
        notifyItemRangeChanged(positionStart, mListings.size());
    }

    public String getLastName() {
        return mListings.get(mListings.size() - 1).getData().getName();
    }

    @Override
    public RecyclerViewAdapterListings.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listing, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterListings.ViewHolder holder, int position) {
        holder.setListing(mListings.get(position));
    }

    @Override
    public int getItemCount() {
        return mListings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewThumbnail;
        private TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewThumbnail = itemView.findViewById(R.id.iv_listing);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(view -> mListenerClickItem.onClickListing(mListings.get(getAdapterPosition())
                    .getData().getPermalink()));
        }

        public void setListing(Child redditListing) {
            textViewTitle.setText(redditListing.getData().getTitle());
            if (redditListing.getData().getThumbnail() != null) {
                Glide
                        .with(mContext)
                        .load(redditListing.getData().getThumbnail())
                        .error(R.drawable.icon_error)
                        .into(imageViewThumbnail);
            }
        }
    }

    interface ListenerClickItem {

        void onClickListing(String permalink);

    }
}
