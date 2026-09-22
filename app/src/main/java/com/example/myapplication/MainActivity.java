package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btLoad;
    MyAdapter myAdapter;

    public static List<Article> articleList =
            new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // BÀI 1
        articleList.add(
                new Article(
                        "Việt Nam đẩy mạnh chuyển đổi số",

                        "Chuyển đổi số đang trở thành một xu hướng "
                                + "quan trọng trong sự phát triển kinh tế và xã hội.\n\n"
                                + "Nhiều doanh nghiệp đang ứng dụng công nghệ "
                                + "vào hoạt động kinh doanh nhằm nâng cao hiệu quả "
                                + "quản lý và cải thiện trải nghiệm khách hàng.",

                        R.drawable.vietnam
                )
        );

// BÀI 2
        articleList.add(
                new Article(
                        "Hà Nội phát triển đô thị hiện đại",

                        "Hà Nội đang từng bước phát triển hệ thống đô thị "
                                + "theo hướng hiện đại và đồng bộ.\n\n"
                                + "Nhiều dự án giao thông và cơ sở hạ tầng được "
                                + "triển khai nhằm đáp ứng nhu cầu phát triển "
                                + "của thành phố.",

                        R.drawable.hanoi
                )
        );

// BÀI 3
        articleList.add(
                new Article(
                        "Đà Nẵng thu hút du khách",

                        "Đà Nẵng tiếp tục là một trong những điểm đến "
                                + "được nhiều du khách quan tâm.\n\n"
                                + "Thành phố có nhiều địa điểm du lịch nổi tiếng "
                                + "cùng với hệ thống dịch vụ ngày càng phát triển.",

                        R.drawable.danang
                )
        );

        // ÁNH XẠ
        recyclerView =
                findViewById(R.id.recyclerView);

        btLoad =
                findViewById(R.id.btLoad);

        // TẠO ADAPTER
        myAdapter =
                new MyAdapter(
                        this,
                        articleList
                );

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(myAdapter);

        // NÚT THÊM BÀI VIẾT
        btLoad.setOnClickListener(v -> {

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(
                            MainActivity.this
                    );

            builder.setTitle("Thêm bài viết");

            LinearLayout layout =
                    new LinearLayout(
                            MainActivity.this
                    );

            layout.setOrientation(
                    LinearLayout.VERTICAL
            );

            layout.setPadding(
                    50,
                    40,
                    50,
                    10
            );

            final EditText titleBox =
                    new EditText(
                            MainActivity.this
                    );

            titleBox.setHint(
                    "Tiêu đề bài viết"
            );

            layout.addView(titleBox);

            final EditText contentBox =
                    new EditText(
                            MainActivity.this
                    );

            contentBox.setHint(
                    "Nội dung bài viết"
            );

            layout.addView(contentBox);

            builder.setView(layout);

            builder.setPositiveButton(
                    "Thêm",
                    (dialog, which) -> {

                        String title =
                                titleBox
                                        .getText()
                                        .toString();

                        String content =
                                contentBox
                                        .getText()
                                        .toString();

                        if (!title.isEmpty()) {

                            articleList.add(
                                    new Article(
                                            title,
                                            content,
                                            R.mipmap.ic_launcher
                                    )
                            );

                            myAdapter.notifyItemInserted(
                                    articleList.size() - 1
                            );

                            recyclerView.scrollToPosition(
                                    articleList.size() - 1
                            );
                        }
                    }
            );

            builder.setNegativeButton(
                    "Hủy",
                    (dialog, which) ->
                            dialog.cancel()
            );

            builder.show();
        });
    }

    @Override
    protected void onResume() {

        super.onResume();

        if (myAdapter != null) {

            myAdapter.notifyDataSetChanged();
        }
    }
}