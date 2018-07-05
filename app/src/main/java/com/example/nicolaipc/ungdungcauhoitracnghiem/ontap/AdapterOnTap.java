package com.example.nicolaipc.ungdungcauhoitracnghiem.ontap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolaipc.ungdungcauhoitracnghiem.R;
import com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat.Tracnghiem;

import java.util.ArrayList;

public class AdapterOnTap extends BaseAdapter{
    Context context;
    ArrayList<Ontap> list;

    public AdapterOnTap(Context context, ArrayList<Ontap> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position,final View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.adapter_ontap, null);
        TextView txtcau = (TextView) row.findViewById(R.id.txtcau);
        TextView txttieude = (TextView) row.findViewById(R.id.txttieude);
        TextView txtnoidung = (TextView) row.findViewById(R.id.txtnoidung);

        final Ontap ontap = list.get(position);
        txtcau.setText(ontap.id + "");
        txttieude.setText(ontap.tieude);
        txtnoidung.setText(ontap.noidung);

        return row;
    }
}

