package com.arcadekd.justexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>
{
    ArrayList<DataModel> dataModels;

    public RecyclerViewAdapter(ArrayList<DataModel> dataModels)
    {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_lock, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.CustomViewHolder holder, int position)
    {
        holder.tv_text.setText(dataModels.get(position).getText());
        holder.iv_recycler.setImageResource(dataModels.get(position).getImgRes());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String curName = holder.tv_text.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return (null != dataModels ? dataModels.size() : 0);
    }

    public void remove(int position)
    {
        try
        {
            dataModels.remove(position);
            notifyItemRemoved(position);
        }
        catch (IndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView tv_text;
        protected ImageView iv_recycler;

        public CustomViewHolder(View itemView)
        {
            super(itemView);
            this.tv_text = itemView.findViewById(R.id.item_tv_title);
            this.iv_recycler = itemView.findViewById(R.id.item_iv_recycler);
        }
    }
}

