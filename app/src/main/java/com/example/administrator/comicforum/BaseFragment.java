package com.example.administrator.comicforum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ViewFlipper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/4.
 */

public abstract class BaseFragment extends Fragment implements View.OnTouchListener,GestureDetector.OnGestureListener{
    private ViewFlipper viewFlipper;//定义viewFlipper
    protected ImageView iv1,iv2,iv3;
    private GestureDetector gestureDetector;//定义手势识别处理器
    private GridView gridView;//定义网格视图
    private List<Map<String,Object>> data_list;
    private SimpleAdapter simpleAdapter;
    protected int[]icon;
    protected String[]iconName;

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.basefragment,null);
        viewFlipper=view.findViewById(R.id.fragmentVf1);//实例化ViewFlipper对象
        iv1=view.findViewById(R.id.vf1_iv1);
        iv2=view.findViewById(R.id.vf1_iv2);
        iv3=view.findViewById(R.id.vf1_iv3);
        gridView=view.findViewById(R.id.gridview);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewFlipper();
        initGridView();
    }

    protected void initViewFlipper(){
        viewFlipper.setInAnimation(getActivity(),R.anim.left_in);//设置广告进入动画
        viewFlipper.setOutAnimation(getActivity(),R.anim.right_out);//设置广告退场动画
        viewFlipper.startFlipping();//开始自动播放
        viewFlipper.setOnTouchListener(this);//给viewflipper设置触屏监听器
        gestureDetector=new GestureDetector(getActivity(),this);//实例化手势识别处理器
    }

    private void initGridView( ) {
        data_list=new ArrayList<>();
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        String [] from ={"image","text"};
        int [] to = {R.id.grid_image,R.id.grid_text};
        simpleAdapter = new SimpleAdapter(getActivity(), data_list, R.layout.grid_item_view, from, to);
        //配置适配器
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> map= (Map<String, Object>) adapterView.getItemAtPosition(i);
                Bundle bundle=new Bundle();
                bundle.putInt("image", (Integer) map.get("image"));
                bundle.putString("text", (String) map.get("text" ));
                Intent intent=new Intent(getActivity(),GridActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        if(e2.getX()-e1.getX()>0){//从左向右滑动时的处理
            viewFlipper.stopFlipping();
            viewFlipper.setInAnimation(getActivity(),R.anim.left_in);
            viewFlipper.setOutAnimation(getActivity(),R.anim.right_out);
            viewFlipper.showNext();
            viewFlipper.startFlipping();
        }
        else if(e2.getX()-e1.getX()<0){//从右向左滑动的处理
            viewFlipper.stopFlipping();
            viewFlipper.setInAnimation(getActivity(),R.anim.right_in);
            viewFlipper.setOutAnimation(getActivity(),R.anim.left_out);
            viewFlipper.showPrevious();
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);//将触摸事件交给手势识别处理器处理
        return true;
    }

}
