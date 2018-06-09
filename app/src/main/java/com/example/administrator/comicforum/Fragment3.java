package com.example.administrator.comicforum;

import android.os.Bundle;
import android.support.annotation.Nullable;


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
    //直接插入排序
    public void insert1(int a[]){
        int i,j,temp;
        for(i=1;i<a.length;i++){
            temp=a[i];
            for(j=i-1;j>=0&&a[j]>temp;j--){
                a[j+1]=a[j];
            }
            a[j+1]=temp;
        }
    }
    //冒泡排序
    public void insert2(int a[]){
        int i,j,temp;
        boolean flag=true;
        for(i=0;i<a.length-1&&flag;i++){
            flag=false;
            for(j=a.length-1;j>i;j--){
                if(a[j]<a[j-1]){
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    flag=true;
                }
            }
        }
    }
    //简单选择排序
    public void insert3(int a[]){
        int i,j,min;
        for(i=0;i<a.length;i++){
            min=a[i];
            for(j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min=a[j];
                }
            }
            if(a[i]!=min){
                a[i]=min;
            }
        }
    }

}
