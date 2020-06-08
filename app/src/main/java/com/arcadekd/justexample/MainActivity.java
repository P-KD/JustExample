package com.arcadekd.justexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private TextView tv_main;
    private ViewPager vp_main;

    private ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initUIComponent();

        initializeData();


    }

    private void initUIComponent()
    {
        setContentView(R.layout.activity_main);

        tv_main = findViewById(R.id.tv_main);
        vp_main = findViewById(R.id.vp_main);

        tv_main.setText("Examples");

        vp_main.setClipToPadding(false);
    }

    private void initializeData()
    {
        list = new ArrayList<>();

        list.add(0,0);
        list.add(1,0);
        list.add(2,0);
        list.add(3,0);

        Log.e("list.size", String.valueOf(list.size()));

        vp_main.setAdapter(new ViewPagerAdapter(this, list));
    }
}