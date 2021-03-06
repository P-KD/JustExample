package com.arcadekd.justexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragSearch extends Fragment
{
    private View view;
    private TextView tv_search;
    private SearchView search_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_search, container, false);

        initUIComponent();

        return view;
    }

    private void initUIComponent()
    {
        tv_search = view.findViewById(R.id.tv_search);
        search_view = view.findViewById(R.id.search_view);

        tv_search.setText("Search Fragment");
    }
}