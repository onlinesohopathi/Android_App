package com.example.awsaf.onlinesohopathi.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.awsaf.onlinesohopathi.Activity.MainActivity;
import com.example.awsaf.onlinesohopathi.Model.Response;
import com.example.awsaf.onlinesohopathi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<Response> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textUserName;
        TextView textTitle;
        TextView Type;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textUserName = (TextView) itemView.findViewById(R.id.username);
            this.textTitle = (TextView) itemView.findViewById(R.id.title);
            this.Type = (TextView) itemView.findViewById(R.id.question);

            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CustomAdapter(List<Response> data , Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.question, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        Response response = dataSet.get(listPosition);

        TextView textUserName = holder.textUserName;
        TextView textTitle = holder.textTitle;
        TextView Type = holder.Type;
        ImageView imageView = holder.imageViewIcon;

        textUserName.setText(response.getUsername());
        textTitle.setText(response.getTitle());
        Type.setText(response.getQuestion());

        imageView.setImageResource(R.drawable.ic_account);

//        Glide.with(context).load(response.getFbpics()).into(imageView);
        Picasso.with(context).load(response.getFbpics()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
