package com.arcadekd.justexample;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    private BottomNavigationView bnv_main;
    private FragSearch fragSearch;
    private FragCall fragCall;
    private FragCamera fragCamera;
    private FragLock fragLock;

    private FragmentTransaction ft;
    private FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initUIComponent();
    }

    private void initUIComponent()
    {
        setContentView(R.layout.activity_fragment);

        fm = this.getSupportFragmentManager();

        fragSearch = new FragSearch();
        fragCall = new FragCall();
        fragCamera = new FragCamera();
        fragLock = new FragLock();

        ft = fm.beginTransaction();
        ft.replace(R.id.frame_main, fragSearch);
        ft.commit();

        bnv_main = findViewById(R.id.bnv_fragment);

        bnv_main.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        ft = fm.beginTransaction();
        switch (menuItem.getItemId())
        {
            case R.id.item_call:
                ft.replace(R.id.frame_main, fragCall);
                ft.commit();
                break;

            case R.id.item_camera:
                ft.replace(R.id.frame_main, fragCamera);
                ft.commit();
                break;

            case R.id.item_lock:
                ft.replace(R.id.frame_main, fragLock);
                ft.commit();
                break;

            case R.id.item_search:
                ft.replace(R.id.frame_main, fragSearch);
                ft.commit();
                break;
        }
        return true;
    }
}
