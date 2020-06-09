package com.arcadekd.justexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragLock extends Fragment
{
    private View view;
    private TextView tv_lock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_lock, container, false);

        initUIComponent();

        return view;
    }

    private void initUIComponent()
    {
        tv_lock = view.findViewById(R.id.tv_lock);

        tv_lock.setText("Lock Fragment");
    }
}