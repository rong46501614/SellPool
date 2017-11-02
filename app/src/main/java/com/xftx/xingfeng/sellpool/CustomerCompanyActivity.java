package com.xftx.xingfeng.sellpool;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.xftx.xingfeng.fileutils.FileUtil;
import com.xftx.xingfeng.permission.Permission;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


public class CustomerCompanyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final CustomerCompanyActivity companyActivity = this;
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.background_gray));

        try {
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
            textView.setText("客户资料-公司篇");
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
            String filePath = FileUtil.getFilePath()+"/SellPool/User/";
            String fileName = "user.json";
            String str = FileUtil.readFileByLines(filePath+fileName);
            JSONObject json = null;
            json = new JSONObject(str);
            Iterator jsonArray_user_company = json.keys();

            while (jsonArray_user_company.hasNext()){
                final String jsonCom = (String)jsonArray_user_company.next();
                final JSONArray jsonObject = json.getJSONArray(jsonCom);
                String address = jsonObject.getJSONArray(jsonObject.length()-1).getString(0);

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
                imageView.setBackgroundResource(R.drawable.company);
                layouts_left.addView(imageView);


                LinearLayout layouts_right = new LinearLayout(this);
                layouts_right.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams layoutParams_right = new LinearLayout.LayoutParams(0, 150,7.0f);
                layouts_right.setLayoutParams(layoutParams_right);



                TextView tv = new TextView(this);
                LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 90);
                tv.setTextSize(14);
                tv.setLayoutParams(tvParams);
                tv.setText(jsonCom);
                tv.setPadding(30, 20, 0, 0);
                layouts_right.addView(tv);
                TextView tvi = new TextView(this);
                LinearLayout.LayoutParams tvPar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60);
                tvi.setTextSize(10);
                tvi.setLayoutParams(tvPar);

                if(address.startsWith("地址")){
                    tvi.setText(address);
                }else{
                    tvi.setText("地址：无");
                }
                tvi.setPadding(30, 0, 0, 0);
                layouts_right.addView(tvi);


                layouts.addView(layouts_left);
                layouts.addView(layouts_right);

                layouts.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(companyActivity, UsersActivity.class);
                        intent1.putExtra("com.xingfeng.CompanyActivity.JSONArray", jsonObject.toString());
                        intent1.putExtra("com.xingfeng.CompanyActivity.jsonCom", jsonCom);
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
            imageViewNewRec2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Permission.verifyStoragePermissions(CustomerCompanyActivity.this);
                    Intent getPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    String strImgPath = Environment.getExternalStorageDirectory()
                            .toString() + "/SellPool/pic/";
                    String fileName = new SimpleDateFormat("yyyyMMddHHmmss")
                            .format(new Date()) + ".jpg";// 照片以格式化日期方式命名
                    File out = new File(strImgPath);
                    if (!out.exists()) {
                        out.mkdirs();
                    }
                    out = new File(strImgPath, fileName);
                    strImgPath = strImgPath + fileName;// 该照片的绝对路径
                    Uri uri = Uri.fromFile(out);
                    getPhoto.putExtra(MediaStore.EXTRA_OUTPUT, uri);//根据uri保存照片
                    getPhoto.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);//保存照片的质量
                    startActivityForResult(getPhoto, 3);//启动相机拍照

                    Toast.makeText(getApplicationContext(), "扫名片--暂未实现",
                            Toast.LENGTH_SHORT).show();
                }
            });
            layout_bottom.addView(imageViewNewRec2);

            ImageView imageViewNewRec3 = new ImageView(this);
            imageViewNewRec3.setBackgroundResource(R.drawable.sereach_user);
            LinearLayout.LayoutParams imageViewNewRecParams3 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams3.setMargins(80,30,80,30);
            imageViewNewRec3.setLayoutParams(imageViewNewRecParams3);
            layout_bottom.addView(imageViewNewRec3);

            final ImageView imageViewNewRec4 = new ImageView(this);
            imageViewNewRec4.setBackgroundResource(R.drawable.menu);
            LinearLayout.LayoutParams imageViewNewRecParams4 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            imageViewNewRecParams4.setMargins(80,30,80,30);
            imageViewNewRec4.setLayoutParams(imageViewNewRecParams4);
            imageViewNewRec4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View popupView = CustomerCompanyActivity.this.getLayoutInflater().inflate(R.layout.popupwindow, null);
                    PopupWindow window = new PopupWindow(popupView, 700, 1180);
                    setBackgroundAlpha(0.7f);//设置屏幕透明度
                    window.setAnimationStyle(R.style.popup_window_anim);
                    window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
                    window.setFocusable(true);
                    window.setOutsideTouchable(true);
                    window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            setBackgroundAlpha(1.0f);
                        }
                    });
                    window.update();
                    window.showAsDropDown(imageViewNewRec4, -700, 200);

                }
            });
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            String img_path = actualimagecursor.getString(actual_image_column_index);
        }
        if(requestCode==3)
        {


        }

    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity)  this).getWindow().setAttributes(lp);
    }

    public void menu_select(View v) {
        switch (v.getId()){
            case R.id.import_file:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                break;
        }
    }

}

