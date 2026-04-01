package com.user.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    TextView splash_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        splash_title=findViewById(R.id.Splash_Title);

        Animation fade_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        splash_title.startAnimation(fade_in);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}