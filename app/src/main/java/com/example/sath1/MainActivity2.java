package com.example.sath1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        tablayout=(TabLayout) findViewById(R.id.tablayout_id);
        viewPager=(ViewPager) findViewById((R.id.viewpager_id));
        loginadapter adapter= new loginadapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentOffline(),"Offline");
        adapter.AddFragment(new FragmentOnline(),"Online");
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);




    }

}