package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder
        extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    private MyAdapter madapter;

    public TextView tvTitle;
    public TextView tvContentSummary;
    public TextView tvViewCount;
    public ImageView imgCover;

    public CountryViewHolder(
            View item,
            MyAdapter adapter) {

        super(item);

        this.madapter = adapter;

        this.tvTitle =
                item.findViewById(R.id.tvTitle);

        this.tvContentSummary =
                item.findViewById(R.id.tvContentSummary);

        this.tvViewCount =
                item.findViewById(R.id.tvViewCount);

        this.imgCover =
                item.findViewById(R.id.imgCover);

        item.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int position = getAdapterPosition();

        if (position != RecyclerView.NO_POSITION) {

            Context context = v.getContext();

            Intent intent =
                    new Intent(
                            context,
                            DetailActivity.class
                    );

            intent.putExtra(
                    "ARTICLE_INDEX",
                    position
            );

            context.startActivity(intent);
        }
    }
}