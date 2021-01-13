package com.example.nhom6_6.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nhom6_6.Model.Thongtin;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Thongtin> listDHShip;

    public ItemAdapter(Context context, int layout, List<Thongtin> listDHShip) {
        this.context = context;
        this.layout = layout;
        this.listDHShip = listDHShip;
    }

    @Override
    public int getCount() {
        return listDHShip.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtMa, txtTen , txtGia, txtDepcription;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;


        return null;
    }
}
