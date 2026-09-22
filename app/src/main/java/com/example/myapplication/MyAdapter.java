package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private List<Article> articleList;
    private LayoutInflater mInflater;

    public MyAdapter(Context context, List<Article> list) {
        this.mInflater = LayoutInflater.from(context);
        this.articleList = list;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = mInflater.inflate(
                R.layout.country_layout,
                parent,
                false
        );

        return new CountryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CountryViewHolder holder,
            int position) {

        Article article = articleList.get(position);

        holder.tvTitle.setText(article.getTitle());

        holder.tvContentSummary.setText(
                article.getContent()
        );

        holder.tvViewCount.setText(
                "Views: " + article.getView()
        );

        holder.imgCover.setImageResource(
                article.getImg_cover()
        );
    }

    @Override
    public int getItemCount() {
        return articleList != null
                ? articleList.size()
                : 0;
    }
}