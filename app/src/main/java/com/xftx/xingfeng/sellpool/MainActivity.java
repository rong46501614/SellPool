package com.xftx.xingfeng.sellpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void redircte(View v) {
        switch (v.getId()){
            case R.id.customer_company:
                Intent intent1 = new Intent(this, CustomerCompanyActivity.class);
                startActivity(intent1);
                break;
            case R.id.baidu_map:
                Intent intent2 = new Intent(this, BaiduMapActivity.class);
                startActivity(intent2);
                break;
            case R.id.intent_customer:
                Intent intent3 = new Intent(this, IntentCustomerActivity.class);
                startActivity(intent3);
                break;
            case R.id.deal_records:
                Intent intent4 = new Intent(this, DealRecordsActivity.class);
                startActivity(intent4);
                break;
            case R.id.could_bak:
                Intent intent5 = new Intent(this, CouldBakActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
