package com.arcadekd.justexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter
{
    private Context context;
    private ArrayList<Integer> list;

    public ViewPagerAdapter(Context context, ArrayList<Integer> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert inflater != null;

        final View view = inflater.inflate(R.layout.item_main_viewpager, null);

        ImageView iv_item_main = view.findViewById(R.id.iv_item_main);
        ImageView iv_item_content = view.findViewById(R.id.iv_item_content);

        Button btn_item_next = view.findViewById(R.id.btn_item_next);

        TextView tv_item_main = view.findViewById(R.id.tv_item_main);

        tv_item_main.setText("Page No. " + (position+1));

        iv_item_main.setImageResource(R.mipmap.ic_launcher_round);

        iv_item_content.setImageResource(R.mipmap.ic_launcher);

        btn_item_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                container.removeView(view);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return (view == object);
    }
}
