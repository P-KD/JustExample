package com.arcadekd.justexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragCall extends Fragment
{
    private View view;
    private TextView tv_call;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_call, container, false);

        initUIComponent();

        return view;
    }

    private void initUIComponent()
    {
        tv_call = view.findViewById(R.id.tv_call);

        tv_call.setText("Call Fragment");
    }
}