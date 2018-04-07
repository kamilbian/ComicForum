package com.example.administrator.comicforum;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Fragment2 extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       icon=new int[]{R.drawable.g2_1,R.drawable.g2_2,R.drawable.g2_3,R.drawable.g2_4,R.drawable.g2_5,
                R.drawable.g2_6,R.drawable.g2_7,R.drawable.g2_8,R.drawable.g2_9};
       iconName=new String[]{"奇诺之旅","RE:从零开始的异世界生活","女装国王","星刻的龙骑士","辉夜魔王式",
               "超绝极危计划","魔法禁书目录","伯爵与妖精", "便当"};
    }

    @Override
    protected void initViewFlipper() {
        super.initViewFlipper();
        iv1.setImageResource(R.drawable.f2_1);
        iv2.setImageResource(R.drawable.f2_2);
        iv3.setImageResource(R.drawable.f2_3);
    }
}
