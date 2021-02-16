package com.example.sath1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private Animation top1, buttom;
    private ImageView image1,image2,image3;
    private EditText t1,t2,t3,t4;
    ProgressDialog br;
    private Button loginhere;
    private TextView login,register;
    private FirebaseAuth mAuth;
    private static int SS= 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        top1= AnimationUtils.loadAnimation(this,R.anim.top_animation1);
        buttom= AnimationUtils.loadAnimation(this,R.anim.buttom_animatiion);
        image1=findViewById(R.id.l1);
        image2=findViewById(R.id.l2);
        image3=findViewById(R.id.l3);
        image1.setAnimation(top1);
        image2.setAnimation(top1);
        image3.setAnimation(top1);
        register=findViewById(R.id.registerhere);
        t1 = findViewById(R.id.inputemail);
        t2 = findViewById(R.id.inputpassword);
        loginhere = findViewById(R.id.loginmainbtn);
        mAuth = FirebaseAuth.getInstance();
        br = new ProgressDialog(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login(){
        String email= t1.getText().toString();
        String password=t2.getText().toString();
        if(TextUtils.isEmpty(email)){
            t1.setError("Enter Correct Email");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            t1.setError("Enter Correct Password");
            return;
        }
        br.setMessage("Please Wait....");
        br.show();
        br.setCanceledOnTouchOutside(false);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(login.this,"Verify The OTP Code ",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(login.this,dashboard.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(login.this,"Login Failed",Toast.LENGTH_LONG).show();
                }
                br.dismiss();
            }
        });

    }

    private boolean isValledEmail(CharSequence target){
        return !(TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    }
