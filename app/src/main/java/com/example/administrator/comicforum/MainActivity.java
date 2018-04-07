package com.example.administrator.comicforum;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;//定义一个FragmentTabHost
    private LayoutInflater layoutInflater;//定义一个布局
    private Class fragmentArray[]={Fragment1.class,Fragment2.class,Fragment3.class};//定义碎片数组
    private int tabImage[]={R.drawable.icon_first,R.drawable.icon_second,R.drawable.icon_third,};//定义一个标签图片数组
    private String tabText[]={"动画","小说","游戏"};//定义标签文本数组
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//实现底部导航栏切换碎片功能
    }
    public void initView(){
        layoutInflater=LayoutInflater.from(this);//实例化布局
        mTabHost=findViewById(android.R.id.tabhost);//实例化FragmentTabHost
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realTabContent);//将碎片布局的占位符传入
        int count=fragmentArray.length;//取得碎片数组的长度
        for(int i=0;i<count;i++){//循环加载每个标签按钮文本和布局
            TabHost.TabSpec tabSpec=mTabHost.newTabSpec(tabText[i]).setIndicator(getTabItemView(i));//
            mTabHost.addTab(tabSpec,fragmentArray[i],null);//添加标签到FragmentTabHost
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_background);
        }
    }
    private View getTabItemView(int index){
        View view=layoutInflater.inflate(R.layout.tab_item_view,null);//实例化标签按钮视图
        ImageView imageView=view.findViewById(R.id.tab_iv);//实例化标签按钮视图的图片控件
        imageView.setImageResource(tabImage[index]);//设置图片控件的图片
        TextView textView=view.findViewById(R.id.tab_tv);//实例化标签按钮视图的文本控件
        textView.setText(tabText[index]);// 设置标签按钮视图的文本控件内的文本
        return view;//返回标签按钮视图
    }
}
