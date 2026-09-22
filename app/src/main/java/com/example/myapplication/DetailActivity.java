package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_detail);

        // Lấy vị trí bài báo được click
        int index =
                getIntent().getIntExtra(
                        "ARTICLE_INDEX",
                        -1
                );

        if (index != -1) {

            Article article =
                    MainActivity.articleList.get(index);

            // ÁNH XẠ CÁC VIEW
            Button btnBack =
                    findViewById(R.id.btnBack);

            ImageView imgCoverDetail =
                    findViewById(R.id.imgCoverDetail);

            TextView tvTitleDetail =
                    findViewById(R.id.tvTitleDetail);

            TextView tvContentDetail =
                    findViewById(R.id.tvContentDetail);

            TextView tvViewCountDetail =
                    findViewById(R.id.tvViewCountDetail);

            // NÚT QUAY LẠI
            btnBack.setOnClickListener(v -> {
                finish();
            });

            // Tăng lượt xem
            article.incrementView();

            // Hiển thị ảnh
            imgCoverDetail.setImageResource(
                    article.getImg_cover()
            );

            // Hiển thị tiêu đề
            tvTitleDetail.setText(
                    article.getTitle()
            );

            // Hiển thị nội dung bài báo thực
            tvContentDetail.setText(
                    article.getContent()
            );

            // Hiển thị lượt xem
            tvViewCountDetail.setText(
                    "Views: " + article.getView()
            );
        }
    }
}