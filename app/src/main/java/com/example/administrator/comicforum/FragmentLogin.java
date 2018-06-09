package com.example.administrator.comicforum;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/6/8.
 */

public class FragmentLogin extends Fragment{
   public TextView tv_register;
   public EditText et_user;
   public EditText et_password;
   String st_register;
   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_login,null);
      tv_register=view.findViewById(R.id.tv_register);
      et_user=view.findViewById(R.id.et_username);
      et_password=view.findViewById(R.id.et_password);
      st_register=(String)tv_register.getText();
      return view;
   }

   @Override
   public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      SpannableString sp=new SpannableString(st_register);
      sp.setSpan(new ClickableSpan() {
         @Override
         public void onClick(View view) {
            Intent intent=new Intent(getActivity(),RegisterActivity.class);
            startActivity(intent);

         }
      },0,st_register.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      tv_register.setText(sp);
      tv_register.setMovementMethod(LinkMovementMethod.getInstance());
   }
}
