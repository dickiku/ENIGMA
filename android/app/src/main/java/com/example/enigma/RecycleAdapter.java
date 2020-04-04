package com.example.enigma;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private Context context;
    private List<kelasss> listKelas;

    public RecycleAdapter(Context context){
        this.context = context;
        listKelas = new ArrayList<>();
    }

    public void setListKelas(List<kelasss> listKelas) {
        this.listKelas = listKelas;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(context).inflate(R.layout.activity_itemkelas, viewGroup,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,int i){
        kelasss k=listKelas.get(i);

        viewHolder.tvNama.setText(k.getNama());
        viewHolder.tvNim.setText(k.getNim());
    }

    @Override
    public int getItemCount(){
        return listKelas.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvNim = itemView.findViewById(R.id.tv_nim);

        }
    }
}
