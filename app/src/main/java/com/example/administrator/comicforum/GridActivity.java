package com.example.administrator.comicforum;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/7.
 */

public class GridActivity extends Activity implements View.OnClickListener {
    private ImageView imageView;
    private TextView textView;
    private Bundle bundle;
    private Button button;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.back_button);
        button.setOnClickListener(this);
        bundle=getIntent().getExtras();
        imageView.setImageResource(bundle.getInt("image"));
        textView.setText(bundle.getString("text"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_button:
                finish();
                break;
        }
    }

}
