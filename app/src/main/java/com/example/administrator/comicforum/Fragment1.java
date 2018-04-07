package com.example.administrator.comicforum;


import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Fragment1 extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        icon=new int[]{R.drawable.g1_1,R.drawable.g1_2,R.drawable.g1_3,R.drawable.g1_4,R.drawable.g1_5,
                R.drawable.g1_6,R.drawable.g1_7,R.drawable.g1_8,R.drawable.g1_9};
        iconName=new String[]{"家教","银魂","网球王子","七龙珠","AIR","东京食尸鬼","刀剑神域","齐木楠雄的灾难",
                "妖精的尾巴"};
    }

    @Override
    protected void initViewFlipper() {
        iv1.setImageResource(R.drawable.f1_1);
        iv2.setImageResource(R.drawable.f1_2);
        iv3.setImageResource(R.drawable.f1_3);
        super.initViewFlipper();
    }
}
