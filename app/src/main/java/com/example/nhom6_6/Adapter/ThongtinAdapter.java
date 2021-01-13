package com.example.nhom6_6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom6_6.Model.ThongtinDH;
import com.example.nhom6_6.R;

import java.util.ArrayList;

public class ThongtinAdapter extends RecyclerView.Adapter<ThongtinAdapter.ViewHolder> {
     Context context;
     ArrayList<ThongtinDH> data_thongtinDH;

    public ThongtinAdapter(Context context, ArrayList<ThongtinDH> data_thongtinDH) {
        this.context = context;
        this.data_thongtinDH = data_thongtinDH;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.thongtindh_listview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMaDH.setText(data_thongtinDH.get(position).getId());
        holder.tvDate.setText(data_thongtinDH.get(position).getP_date());
        holder.tvDiscount.setText(data_thongtinDH.get(position).getP_discount());
        holder.tvDiscount_price.setText(data_thongtinDH.get(position).getP_discount_price());
        holder.tvName.setText(data_thongtinDH.get(position).getP_name());
        holder.tvPrice.setText(data_thongtinDH.get(position).getP_price());
        holder.tvPrice_final.setText(data_thongtinDH.get(position).getP_price_final());
        holder.tvQuantity.setText(data_thongtinDH.get(position).getP_quantity());
        holder.tvTime.setText(data_thongtinDH.get(position).getP_time());
    }

    @Override
    public int getItemCount() {
        return data_thongtinDH.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        TextView tvMaDH;
        TextView tvDate;
        TextView tvDiscount;
        TextView tvDiscount_price;
        TextView tvName;
        TextView tvPrice;
        TextView tvPrice_final;
        TextView tvQuantity;
        TextView tvTime;

        public ViewHolder(View view)
        {
            super(view);
            tvMaDH = (TextView)view.findViewById(R.id.tvMaDH);
            tvDate = (TextView)view.findViewById(R.id.tvDate);
            tvDiscount = (TextView)view.findViewById(R.id.tvDiscount);
            tvDiscount_price = (TextView)view.findViewById(R.id.tvDiscount_price);
            tvName = (TextView)view.findViewById(R.id.tvName);
            tvPrice = (TextView)view.findViewById(R.id.tvPrice);
            tvPrice_final = (TextView)view.findViewById(R.id.tvPrice_Final);
            tvQuantity = (TextView)view.findViewById(R.id.tvQuantity);
            tvTime = (TextView)view.findViewById(R.id.tvTime);
        }

    }
}
