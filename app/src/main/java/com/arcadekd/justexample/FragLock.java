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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FragLock extends Fragment
{
    private View view;
    private TextView tv_lock;
    private RecyclerView rv_lock;
    private Button btn_add;
    private RecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<DataModel> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_lock, container, false);

        initUIComponent();

        dataList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(dataList);
        rv_lock.setAdapter(adapter);

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

        return view;
    }

    private void initUIComponent()
    {
        tv_lock = view.findViewById(R.id.tv_lock);
        rv_lock = view.findViewById(R.id.rv_lock);
        btn_add = view.findViewById(R.id.btn_add);

        adapter = new RecyclerViewAdapter(dataList);
        linearLayoutManager = new LinearLayoutManager(getActivity());

        tv_lock.setText("Lock Fragment");

        rv_lock.setAdapter(adapter);
        rv_lock.setLayoutManager(linearLayoutManager);
    }

}