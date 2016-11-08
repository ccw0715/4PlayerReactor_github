package com.yedona.a4playerreactor;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class WhiteScreenActivity extends AppCompatActivity {

    private RelativeLayout rl1, rl2, rl3;
    private TextView title1, title2, count1, count2, gameName1, gameName2, gameNum2, gameNum1, colorText1, colorText2;
    private TextView pr;
    private Random random = new Random();
    private boolean isTrue = false;
    private int isChoice = -1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    isChoice = -1;
                    startGame();
                    break;
                case 1:
                    rl2.setBackgroundResource(R.drawable.btn_bg_2);
                    title2.setText("看见白色时点击");
                    rl1.setBackgroundResource(R.drawable.btn_bg_2);
                    title1.setText("看见白色时点击");
                    handler.sendEmptyMessageDelayed(0, random.nextInt(1000) + 10000);
                    break;
                case 2:
                    colorText1.setText("1");
                    colorText1.setTextColor(Color.RED);
                    colorText2.setText("1");
                    colorText2.setTextColor(Color.RED);

                    handler.sendEmptyMessageDelayed(5, 1000);
                    break;
                case 3:
                    colorText1.setText("2");
                    colorText1.setTextColor(Color.GREEN);
                    colorText2.setText("2");
                    colorText2.setTextColor(Color.GREEN);
                    handler.sendEmptyMessageDelayed(2, 1000);
                    break;
                case 4:
                    colorText1.setText("3");
                    colorText1.setTextColor(Color.YELLOW);
                    colorText2.setText("3");
                    colorText2.setTextColor(Color.YELLOW);
                    handler.sendEmptyMessageDelayed(3, 1000);
                    break;
                case 5:
                    colorText1.setVisibility(View.GONE);
                    colorText2.setVisibility(View.GONE);
                    handler.sendEmptyMessageDelayed(0, random.nextInt(1000) + 10000);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }

    private void initView() {

        rl1 = ((RelativeLayout) findViewById(R.id.rl1));
        rl2 = ((RelativeLayout) findViewById(R.id.rl2));
        rl3 = ((RelativeLayout) findViewById(R.id.rl3));


        title1 = ((TextView) findViewById(R.id.title1));
        title2 = ((TextView) findViewById(R.id.title2));
        count1 = ((TextView) findViewById(R.id.count1));
        count2 = ((TextView) findViewById(R.id.count2));
        count1.setText(0 + "");
        count2.setText(0 + "");

        colorText1 = ((TextView) findViewById(R.id.colorText1));
        colorText2 = ((TextView) findViewById(R.id.colorText2));


        gameName1 = ((TextView) findViewById(R.id.gameName1));
        gameName2 = ((TextView) findViewById(R.id.gameName2));
        gameNum2 = ((TextView) findViewById(R.id.gameNum2));
        gameNum1 = ((TextView) findViewById(R.id.gameNum1));
        pr = ((TextView) findViewById(R.id.pr));

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.trans1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.trans2);

        gameName1.startAnimation(animation);
        gameName2.startAnimation(animation);
        gameNum1.startAnimation(animation2);
        gameNum2.startAnimation(animation2);

        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                colorText1.setVisibility(View.VISIBLE);
                colorText2.setVisibility(View.VISIBLE);
                handler.sendEmptyMessage(4);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void startGame() {

        rl3.setBackgroundResource(R.drawable.choice_true);
        isTrue = true;
        Animation animation1 = AnimationUtils.loadAnimation(WhiteScreenActivity.this, R.anim.scale);
        animation1.setDuration(1000);
        animation1.setFillAfter(true);
        pr.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isChoice == -1) {
                    handler.sendEmptyMessageDelayed(0, random.nextInt(1000) + 10000);
                    rl3.setBackgroundResource(R.drawable.btn_bg_2);
                }
                isTrue = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }


    public void choice1(View view) {

        if (isTrue) {
            String s = count1.getText().toString();
            int i = Integer.valueOf(s) + 1;
            rl1.setBackgroundResource(R.drawable.btn_bg_true);
            isTrue = false;
            title1.setText("哟 (＾Ｕ＾)ノ~ＹＯ");
            count1.setText("" + i);
        } else {
            String s = count1.getText().toString();
            int i = Integer.valueOf(s) - 1;
            count1.setText("" + i);
            title1.setText("小垃圾");
            rl1.setBackgroundResource(R.drawable.btn_bg_false);
        }
        rl3.setBackgroundResource(R.drawable.btn_bg_2);
        isChoice = 1;


        handler.sendEmptyMessageDelayed(1, 1000);
    }

    public void choice2(View view) {

        if (isTrue) {
            rl2.setBackgroundResource(R.drawable.btn_bg_true);
            String s = count2.getText().toString();
            int i = Integer.valueOf(s) + 1;
            count2.setText(i + "");
            title2.setText("哟 (＾Ｕ＾)ノ~ＹＯ");
            isTrue = false;

        } else {
            title2.setText("小垃圾");
            String s = count2.getText().toString();
            int i = Integer.valueOf(s) - 1;
            count2.setText(i + "");
            rl2.setBackgroundResource(R.drawable.btn_bg_false);
        }
        rl3.setBackgroundResource(R.drawable.btn_bg_2);
        isChoice = 1;

        handler.sendEmptyMessageDelayed(1, 1000);
    }

    public void choice3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(WhiteScreenActivity.this);
        builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
            }
        }).setPositiveButton("返回", null).setTitle("退出？").show();
    }
}
