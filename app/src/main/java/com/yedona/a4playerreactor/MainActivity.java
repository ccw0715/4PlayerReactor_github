package com.yedona.a4playerreactor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView quickTV, tv1, tv2, tv3, tv4, tv11, tv12, tv13, tv14, modeltv;
    private int view;
    private RelativeLayout r1, r2, r3, r4;
    private static int MODEL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        quickTV = (TextView) findViewById(R.id.quick);
        tv1 = ((TextView) findViewById(R.id.tv1));
        tv2 = ((TextView) findViewById(R.id.tv2));
        tv3 = ((TextView) findViewById(R.id.tv3));
        tv4 = ((TextView) findViewById(R.id.tv4));
        tv11 = ((TextView) findViewById(R.id.tv11));
        tv12 = ((TextView) findViewById(R.id.tv12));
        tv13 = ((TextView) findViewById(R.id.tv13));
        tv14 = ((TextView) findViewById(R.id.tv14));
        modeltv = ((TextView) findViewById(R.id.modeltv));
        r1 = ((RelativeLayout) findViewById(R.id.r1));
        r2 = ((RelativeLayout) findViewById(R.id.r2));
        r3 = ((RelativeLayout) findViewById(R.id.r3));
        r4 = ((RelativeLayout) findViewById(R.id.r4));

    }

    public void setPlay1(View view) {
        setView(1);
    }

    public void setPlay2(View view) {
        setView(2);
    }

    public void setPlay3(View view) {
        setView(3);
    }

    public void setPlay4(View view) {
        setView(4);
    }

    //设置选择人数时字体的变化
    public void setView(int i) {
        switch (i) {
            case 1:
                r1.setBackgroundResource(R.drawable.btn_bg_2);
                r2.setBackgroundResource(R.drawable.btn_bg);
                r3.setBackgroundResource(R.drawable.btn_bg);
                r4.setBackgroundResource(R.drawable.btn_bg);
                tv11.setVisibility(View.VISIBLE);
                tv12.setVisibility(View.GONE);
                tv13.setVisibility(View.GONE);
                tv14.setVisibility(View.GONE);
                tv1.setTextColor(Color.WHITE);
                tv2.setTextColor(getResources().getColor(R.color.gray));
                tv3.setTextColor(getResources().getColor(R.color.gray));
                tv4.setTextColor(getResources().getColor(R.color.gray));
                quickTV.setVisibility(View.VISIBLE);
                break;
            case 2:
                r1.setBackgroundResource(R.drawable.btn_bg);
                r2.setBackgroundResource(R.drawable.btn_bg_2);
                r3.setBackgroundResource(R.drawable.btn_bg);
                r4.setBackgroundResource(R.drawable.btn_bg);
                tv11.setVisibility(View.GONE);
                tv12.setVisibility(View.VISIBLE);
                tv13.setVisibility(View.GONE);
                tv14.setVisibility(View.GONE);
                tv2.setTextColor(Color.WHITE);
                tv1.setTextColor(getResources().getColor(R.color.gray));
                tv3.setTextColor(getResources().getColor(R.color.gray));
                tv4.setTextColor(getResources().getColor(R.color.gray));
                quickTV.setVisibility(View.GONE);
                break;
            case 3:
                r1.setBackgroundResource(R.drawable.btn_bg);
                r3.setBackgroundResource(R.drawable.btn_bg_2);
                r2.setBackgroundResource(R.drawable.btn_bg);
                r4.setBackgroundResource(R.drawable.btn_bg);
                tv11.setVisibility(View.GONE);
                tv13.setVisibility(View.VISIBLE);
                tv12.setVisibility(View.GONE);
                tv14.setVisibility(View.GONE);
                tv3.setTextColor(Color.WHITE);
                tv1.setTextColor(getResources().getColor(R.color.gray));
                tv2.setTextColor(getResources().getColor(R.color.gray));
                tv4.setTextColor(getResources().getColor(R.color.gray));
                quickTV.setVisibility(View.GONE);
                break;
            case 4:
                r1.setBackgroundResource(R.drawable.btn_bg);
                r4.setBackgroundResource(R.drawable.btn_bg_2);
                r3.setBackgroundResource(R.drawable.btn_bg);
                r2.setBackgroundResource(R.drawable.btn_bg);
                tv11.setVisibility(View.GONE);
                tv14.setVisibility(View.VISIBLE);
                tv13.setVisibility(View.GONE);
                tv12.setVisibility(View.GONE);
                tv4.setTextColor(Color.WHITE);
                tv1.setTextColor(getResources().getColor(R.color.gray));
                tv3.setTextColor(getResources().getColor(R.color.gray));
                tv2.setTextColor(getResources().getColor(R.color.gray));
                quickTV.setVisibility(View.GONE);
                break;
        }
    }

    //设置选择难度
    public void setModel(View view) {
        MODEL++;
        if (MODEL % 5 == 0) {
            MODEL++;
        }
        switch (MODEL % 5) {

            case 1:
                modeltv.setText("简单?");
                break;
            case 2:
                modeltv.setText("中等。");
                break;
            case 3:
                modeltv.setText("困难！");
                break;
            case 4:
                modeltv.setText("疯狂！！");
                break;
        }
    }

    public void startGame(View view) {
        startActivity(new Intent(this,WhiteScreenActivity.class));
    }
}
