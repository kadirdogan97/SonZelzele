package com.kadir.bootcamp.sonzelzele.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kadir.bootcamp.sonzelzele.R;
import com.kadir.bootcamp.sonzelzele.models.EarthQueueModel;
import com.kadir.bootcamp.sonzelzele.network.Factory;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KadirDogan on 8/17/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] lokasyonlar = new String[10];
    private String[] tarihler = new String[10];
    private String[] enlemler = new String[10];
    private String[] boylamlar = new String[10];
    private String[] siddetler = new String[10];
    private String[] derinlikler = new String[10];

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView yerText,tarihText,enlemText,boylamText,siddetText,derinlikText;
        public ViewHolder(View itemView) {
            super(itemView);
            yerText = (TextView) itemView.findViewById(R.id.yerText);
            tarihText = (TextView) itemView.findViewById(R.id.tarihText);
            enlemText = (TextView) itemView.findViewById(R.id.latText);
            boylamText = (TextView) itemView.findViewById(R.id.lngText);
            siddetText = (TextView) itemView.findViewById(R.id.siddetText);
            derinlikText = (TextView) itemView.findViewById(R.id.derinlikText);
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_layout,parent,false);
        ViewHolder recyclerViewHolder = new ViewHolder(itemView);
        Factory.getInstance().getEarthQueue().enqueue(new Callback<EarthQueueModel>() {
            @Override
            public void onResponse(Call<EarthQueueModel> call, Response<EarthQueueModel> response) {
                for(int i = 0; i<10; i++){
                    lokasyonlar[i] = response.body().data.get(i).lokasyon;
                    tarihler[i] = response.body().data.get(i).tarih2;
                    enlemler[i] = response.body().data.get(i).lat;
                    boylamlar[i] = response.body().data.get(i).lng;
                    siddetler[i] = response.body().data.get(i).siddeti;
                    derinlikler[i] = response.body().data.get(i).derinlik;
                }
            }

            @Override
            public void onFailure(Call<EarthQueueModel> call, Throwable t) {

            }
        });
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.yerText.setText("YER: "+lokasyonlar[position]);
        holder.enlemText.setText("Enlem: "+enlemler[position]);
        holder.boylamText.setText("Boylam: "+boylamlar[position]);
        holder.tarihText.setText("Tarih/Saat: "+tarihler[position]);
        holder.siddetText.setText("Şiddet: "+siddetler[position]);
        holder.derinlikText.setText("Derinlik: "+derinlikler[position]);
    }

    @Override
    public int getItemCount() {
        return lokasyonlar.length;
    }



}
