package com.arcadekd.justexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragCamera extends Fragment
{
    private View view;
    private TextView tv_camera;

    private final String BASE_URL = "http://www.kobis.or.kr";
    private Retrofit retrofit;
    private BoxOfficeService boxOfficeService;
    private RecyclerView rv_boxOffice;

    private final String API_KEY = "4c8cbb7d069aed4ff0c7285c4177b681";

    private List<WeeklyBoxOfficeList> weeklyBoxOfficeLists = new ArrayList<>();
    private BoxOfficeAdapter boxOfficeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_camera, container, false);

        initUIComponent();

        Log.e("Fragment Camera : ", "CREATE");

        boxOfficeService.getBoxOffice(API_KEY, "20200610").enqueue(new Callback<Result>()
        {
            @Override
            public void onResponse(@NonNull Call<Result> call, @NonNull Response<Result> response)
            {
                if (response.isSuccessful())
                {
                    Log.e("retro", 1 + "");
                    Result result = response.body();
                    BoxOfficeResult boxOfficeResult = result.getBoxOfficeResult();
                    List<WeeklyBoxOfficeList> weeklyBoxOfficeListLIst2 = boxOfficeResult.getWeeklyBoxOfficeList();
                    for (WeeklyBoxOfficeList weeklyBoxOffice : weeklyBoxOfficeListLIst2)
                    {
                        weeklyBoxOfficeLists.add(weeklyBoxOffice);
                    }


                    boxOfficeAdapter = new BoxOfficeAdapter(weeklyBoxOfficeLists, getActivity());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    rv_boxOffice.setLayoutManager(linearLayoutManager);
                    rv_boxOffice.setAdapter(boxOfficeAdapter);
                }
                else
                {
                    Log.e("retro", 2 + "Error");
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t)
            {
                Log.e("Retrofit2", "FAILED TO CALLBACK");
            }
        });

        return view;
    }

    private void initUIComponent()
    {
        tv_camera = view.findViewById(R.id.tv_camera);
        rv_boxOffice = view.findViewById(R.id.rv_boxoffice);

        tv_camera.setText("RecyclerView with Retrofit2");


        //Retrofit 객체생성
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        boxOfficeService = retrofit.create(BoxOfficeService.class);
    }
}