package com.example.fueldashboard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fueldashboard.Abastecimento;
import com.example.fueldashboard.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList db;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvID;
        public TextView tvPosto;
        public TextView tvLitros;
        public TextView tvValor;
        public TextView tvKm;

        public MyViewHolder(View v) {
            super(v);
            tvID = v.findViewById(R.id.tvID);
            tvPosto = v.findViewById(R.id.tvPosto);
            tvLitros = v.findViewById(R.id.tvLitros);
            tvValor = v.findViewById(R.id.tvValor);
            tvKm = v.findViewById(R.id.tvKm);
        }
    }

    public Adapter(ArrayList myDataset) {
        db = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(com.example.fueldashboard.R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Abastecimento abastecimento;
        abastecimento = (Abastecimento) db.get(position);

        holder.tvID.setText(abastecimento.getId());
        holder.tvPosto.setText(abastecimento.getPosto());
        holder.tvLitros.setText(String.valueOf(abastecimento.getLitros()));
        holder.tvValor.setText(String.valueOf(abastecimento.getValor()));
        holder.tvKm.setText(String.valueOf(abastecimento.getKm()));

    }

    @Override
    public int getItemCount() {

        return db.size();

    }


}
