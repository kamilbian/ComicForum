package com.example.administrator.comicforum;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/7.
 */

public class GridActivity extends Activity {
    private ImageView imageView;
    private TextView textView;
    private Bundle bundle;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        bundle=getIntent().getExtras();
        imageView.setImageResource(bundle.getInt("image"));
        textView.setText(bundle.getString("text"));
    }
}
