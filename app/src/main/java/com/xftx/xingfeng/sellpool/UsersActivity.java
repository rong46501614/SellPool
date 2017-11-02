package com.xftx.xingfeng.sellpool;

import android.content.Intent;
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

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final UsersActivity usersActivity = this;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.background_gray));

        Intent intent = getIntent();
        String name = intent.getStringExtra("com.xingfeng.CompanyActivity.JSONArray");
        String jsonCom = intent.getStringExtra("com.xingfeng.CompanyActivity.jsonCom");
        try {
            JSONArray jsonArray = new JSONArray(name);


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
            textView.setText(jsonCom);
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

            for (int i=2;i<jsonArray.length()-2;i++){

                final JSONArray item = jsonArray.getJSONArray(i);
                final JSONArray titlelist = jsonArray.getJSONArray(1);
                String part = jsonArray.getJSONArray(i).getString(0);
                String username = jsonArray.getJSONArray(i).getString(1);


                LinearLayout layouts = new LinearLayout(this);
                layouts.setOrientation(LinearLayout.HORIZONTAL);
                layouts.setBackgroundResource(R.drawable.customer_selector);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);
                layoutParams.setMargins(30, 10, 30, 10);
                layouts.setLayoutParams(layoutParams);


                LinearLayout layouts_left = new LinearLayout(this);
                layouts_left.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams layoutParams_left = new LinearLayout.LayoutParams(0, 150,1.0f);
                layouts_left.setLayoutParams(layoutParams_left);



                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams_img = new LinearLayout.LayoutParams(100, 100);
                layoutParams_img.setMargins(20, 20, 0, 0);
                imageView.setLayoutParams(layoutParams_img);
                imageView.setBackgroundResource(R.drawable.user_photo);
                layouts_left.addView(imageView);


                LinearLayout layouts_right = new LinearLayout(this);
                layouts_right.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams layoutParams_right = new LinearLayout.LayoutParams(0, 150,7.0f);
                layouts_right.setLayoutParams(layoutParams_right);



                TextView tv = new TextView(this);
                LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 90);
                tv.setTextSize(14);
                tv.setLayoutParams(tvParams);
                tv.setText(username);
                tv.setPadding(30, 20, 0, 0);
                layouts_right.addView(tv);
                TextView tvi = new TextView(this);
                LinearLayout.LayoutParams tvPar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60);
                tvi.setTextSize(10);
                tvi.setLayoutParams(tvPar);

                if(!part.equals("")){
                    tvi.setText("部门："+part);
                }else{
                    tvi.setText("部门：同上");
                }
                tvi.setPadding(30, 0, 0, 0);
                layouts_right.addView(tvi);


                layouts.addView(layouts_left);
                layouts.addView(layouts_right);

                layouts.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(usersActivity, UserActivity.class);
                        intent1.putExtra("com.xingfeng.usersActivity.item", item.toString());
                        intent1.putExtra("com.xingfeng.usersActivity.titlelist", titlelist.toString());
                        startActivity(intent1);
                    }
                });




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