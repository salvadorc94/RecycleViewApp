package com.algo.labo5;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UCA on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Serie> series;


    public static MyAdapterListener onClickListener;

    public interface MyAdapterListener {

        void btnOnClick(View v, int position);
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView name;
        ImageView img;
        Button ver;


        public SeriesViewHolder(View itemView) {
            super(itemView);
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.imagen);
            ver = itemView.findViewById(R.id.btn_ver);

            ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.btnOnClick(v,getAdapterPosition());
                }
            });

        }
    }


    public SeriesAdapter(ArrayList<Serie> series){this.series=series;}

    public SeriesAdapter(ArrayList<Serie> series, MyAdapterListener Listener){
        this.series = series;
        onClickListener = Listener;
    }


    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}
