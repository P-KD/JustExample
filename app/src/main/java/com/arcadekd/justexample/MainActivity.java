package com.arcadekd.justexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    /**
     * Adapter, Fragment lifecycle 이해할 것
     * Image Slider(Horizontal), RecyclerView(Vertical), Glide, retrofit2, textObserver, ViewPager,
     * Room, Search Bar, QR code, Bottom NavigationView, address copy to clipBoard, pattern code 관련 공부하고 사용해볼 것
     **/

    private TextView tv_main;
    private ViewPager vp_main;
    private Button btn_move;

    private ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initUIComponent();

        initializeData();

        buttonManager();

    }

    private void initUIComponent()
    {
        setContentView(R.layout.activity_main);

        tv_main = findViewById(R.id.tv_main);
        vp_main = findViewById(R.id.vp_main);
        btn_move = findViewById(R.id.btn_move);

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

    private void buttonManager()
    {
        btn_move.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), FragmentActivity.class);

                startActivity(intent);
            }
        });
    }
}