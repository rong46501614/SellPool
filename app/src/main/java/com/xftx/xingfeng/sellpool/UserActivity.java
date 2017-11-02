package com.xftx.xingfeng.sellpool;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xftx.xingfeng.permission.Permission;

import org.json.JSONArray;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final UserActivity companyActivity = this;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.background_gray));

        Intent intent = getIntent();
        String item = intent.getStringExtra("com.xingfeng.usersActivity.item");
        String titlelist = intent.getStringExtra("com.xingfeng.usersActivity.titlelist");
        try {
            JSONArray items = new JSONArray(item);
            JSONArray titlelists = new JSONArray(titlelist);

            LinearLayout layout_top = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams_top = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,1.0f);
            layout_top.setLayoutParams(layoutParams_top);
            layout_top.setBackgroundColor(getResources().getColor(R.color.top_back));
            layout_top.setOrientation(LinearLayout.HORIZONTAL);


            LinearLayout linearLayout1 = new LinearLayout(this);
            LinearLayout.LayoutParams layout_topRecParams1 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
            linearLayout1.setLayoutParams(layout_topRecParams1);
            ImageView imageViewBack = new ImageView(this);
            imageViewBack.setBackgroundResource(R.drawable.back);
            LinearLayout.LayoutParams layout_topRecParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            layout_topRecParams.setMargins(30,30,20,30);
            imageViewBack.setLayoutParams(layout_topRecParams);
            linearLayout1.addView(imageViewBack);
            layout_top.addView(linearLayout1);


            LinearLayout layout_top_split = new LinearLayout(this);
            LinearLayout.LayoutParams layout_splitRecParams = new LinearLayout.LayoutParams(0,100,0.05f);
            layout_splitRecParams.setMargins(0,25,0,0);
            layout_top_split.setLayoutParams(layout_splitRecParams);
            layout_top_split.setBackgroundColor(getResources().getColor(R.color.black));
            layout_top.addView(layout_top_split);

            LinearLayout linearLayout2 = new LinearLayout(this);
            LinearLayout.LayoutParams layout_topRecParams2 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,6.0f);
            linearLayout2.setLayoutParams(layout_topRecParams2);
            TextView textView = new TextView(this);
            textView.setPadding(30,40,30,30);
            textView.setTextSize(16);
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setText("员工");
            linearLayout2.addView(textView);
            layout_top.addView(linearLayout2);


            LinearLayout linearLayout3 = new LinearLayout(this);
            LinearLayout.LayoutParams layout_topRecParams3 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
            linearLayout3.setLayoutParams(layout_topRecParams3);
            TextView textView2 = new TextView(this);
            textView2.setPadding(0,40,30,30);
            textView2.setTextSize(16);
            textView2.setTextColor(getResources().getColor(R.color.white));
            textView2.setText("编辑");
            linearLayout3.addView(textView2);
            layout_top.addView(linearLayout3);


            LinearLayout layout_center = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams_center = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,10.0f);
            layout_center.setOrientation(LinearLayout.VERTICAL);
            layout_center.setScrollY(LinearLayout.VERTICAL);
            ScrollView scrollView = new ScrollView(this);
            scrollView.setLayoutParams(layoutParams_center);

            Permission.verifyStoragePermissions(this);

            for (int i=0;i<titlelists.length();i++){

                LinearLayout layouts = new LinearLayout(this);
                layouts.setOrientation(LinearLayout.VERTICAL);
                layouts.setBackgroundResource(R.drawable.customer_selector);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
                layoutParams.setMargins(30, 10, 30, 10);
                layouts.setLayoutParams(layoutParams);



                TextView tv = new TextView(this);
                LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 90);
                tv.setTextSize(12);
                tv.setLayoutParams(tvParams);
                tv.setText(titlelists.getString(i)+":");
                tv.setPadding(30, 20, 0, 0);
                TextView tvi = new TextView(this);
                LinearLayout.LayoutParams tvPar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60);
                tvi.setTextSize(14);
                tvi.setLayoutParams(tvPar);
                String a = items.getString(i);

                tvi.setText("　　"+items.get(i));
                tvi.setPadding(30, 0, 0, 0);

                layouts.addView(tv);
                layouts.addView(tvi);
                layout_center.addView(layouts);

            }
            scrollView.addView(layout_center);



            LinearLayout layout_bottom_strock = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams_bottom = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0.01f);
            layout_bottom_strock.setLayoutParams(layoutParams_bottom);
            layout_bottom_strock.setBackgroundColor(getResources().getColor(R.color.bottom_back));

            LinearLayout layout_bottom = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams_bottoms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,1.0f);
            layout_bottom.setLayoutParams(layoutParams_bottoms);
            layout_bottom.setOrientation(LinearLayout.HORIZONTAL);
            layout_bottom.setBackgroundColor(getResources().getColor(R.color.white));


            ImageView imageViewNewRec = new ImageView(this);
            imageViewNewRec.setBackgroundResource(R.drawable.new_record);
            LinearLayout.LayoutParams imageViewNewRecParams = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams.setMargins(80,30,80,30);
            imageViewNewRec.setLayoutParams(imageViewNewRecParams);
            layout_bottom.addView(imageViewNewRec);

            ImageView imageViewNewRec2 = new ImageView(this);
            imageViewNewRec2.setBackgroundResource(R.drawable.scan);
            LinearLayout.LayoutParams imageViewNewRecParams2 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams2.setMargins(80,30,80,30);
            imageViewNewRec2.setLayoutParams(imageViewNewRecParams2);
            layout_bottom.addView(imageViewNewRec2);

            ImageView imageViewNewRec3 = new ImageView(this);
            imageViewNewRec3.setBackgroundResource(R.drawable.sereach_user);
            LinearLayout.LayoutParams imageViewNewRecParams3 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams3.setMargins(80,30,80,30);
            imageViewNewRec3.setLayoutParams(imageViewNewRecParams3);
            layout_bottom.addView(imageViewNewRec3);

            ImageView imageViewNewRec4 = new ImageView(this);
            imageViewNewRec4.setBackgroundResource(R.drawable.menu);
            LinearLayout.LayoutParams imageViewNewRecParams4 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams4.setMargins(80,30,80,30);
            imageViewNewRec4.setLayoutParams(imageViewNewRecParams4);
            layout_bottom.addView(imageViewNewRec4);





            linearLayout.addView(layout_top);
            linearLayout.addView(scrollView);
            linearLayout.addView(layout_bottom_strock);
            linearLayout.addView(layout_bottom);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentView(linearLayout);


    }
}