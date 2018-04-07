package com.example.administrator.comicforum;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/3/29.
 */

public class Fragment3 extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        icon=new int[]{R.drawable.g3_1,R.drawable.g3_2,R.drawable.g3_3,R.drawable.g3_4,R.drawable.g3_5,
                R.drawable.g3_6,R.drawable.g3_7,R.drawable.g3_8,R.drawable.g3_9};
        iconName=new String[]{"魔兽世界","恋游记","剑之街的异邦人","刺客信条3","三国志12","龙世纪","黑暗边缘者",
                "星际狐狸", "看门狗2"};
    }

    @Override
    protected void initViewFlipper() {
        iv1.setImageResource(R.drawable.f3_1);
        iv2.setImageResource(R.drawable.f3_2);
        iv3.setImageResource(R.drawable.f3_3);
        super.initViewFlipper();
    }
}
