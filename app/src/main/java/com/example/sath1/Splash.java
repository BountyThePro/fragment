package com.example.sath1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    Animation top, buttom;
    ImageView image;
    TextView Text;
    private static int SS= 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        buttom= AnimationUtils.loadAnimation(this,R.anim.buttom_animatiion);
        image=findViewById(R.id.logo);
        Text=findViewById(R.id.sathtext);
        image.setAnimation(top);
        Text.setAnimation(buttom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },SS);

    }
}