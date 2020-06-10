package com.arcadekd.justexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FragLock extends Fragment
{
    private View view;
    private TextView tv_lock;
    private RecyclerView rv_lock;

    private Button btn_add;
    private Button btn_setLock;
    private Button btn_lock;

    private RecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<DataModel> dataList;

    private FragmentTransaction ft;
    private FragmentManager fm;

    private FragPattern fragPattern;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_lock, container, false);

        initUIComponent();

        btn_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DataModel dataModel = new DataModel("Test", R.mipmap.ic_launcher_round);
                dataList.add(dataModel);
                adapter.notifyDataSetChanged();
            }
        });

        btn_lock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_main, fragPattern);
                ft.commit();
            }
        });

        btn_setLock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ft = fm.beginTransaction();
                ft.replace(R.id.frame_main, fragPattern);
                ft.commit();
            }
        });

        return view;
    }

    private void initUIComponent()
    {
        tv_lock = view.findViewById(R.id.tv_lock);
        rv_lock = view.findViewById(R.id.rv_lock);

        btn_add = view.findViewById(R.id.btn_add);
        btn_lock = view.findViewById(R.id.btn_lock);
        btn_setLock = view.findViewById(R.id.btn_setlock);

        adapter = new RecyclerViewAdapter(dataList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        fragPattern = new FragPattern();

        dataList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(dataList);
        rv_lock.setAdapter(adapter);

        tv_lock.setText("Lock Fragment");

        rv_lock.setAdapter(adapter);
        rv_lock.setLayoutManager(linearLayoutManager);

        fm = getActivity().getSupportFragmentManager();

    }

}