package com.zoro.myoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private ImageView rul;
    private Random random;
    private int old_deegre = 0;
    private int deegre = 0;
    private static final float FACTOR = 4.86f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onclickStart(View view) {
        old_deegre = deegre % 360;
        deegre = random.nextInt(3600) + 720;
        RotateAnimation rotate = new RotateAnimation(old_deegre, deegre, RotateAnimation.RELATIVE_TO_SELF,
                0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3600);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new DecelerateInterpolator());
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
               tvResult.setText("А ты ждал легких денеге ,пхаххаха пиздуй работать !!!!!!");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
tvResult.setText(" ");
                tvResult.setText("пиздуй нету тут ничего такого!! ");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        });
        rul.startAnimation(rotate);
    }

    private void init() {
        tvResult = findViewById(R.id.vhod);
        rul = findViewById(R.id.ruletka);
        random = new Random();
    }
}