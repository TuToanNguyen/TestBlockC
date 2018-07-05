package com.example.nicolaipc.ungdungcauhoitracnghiem.monhoc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolaipc.ungdungcauhoitracnghiem.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvNumExam);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgIcon);

        Exam exam = getItem(position);
        if (exam != null)
        {
            textView.setText("" + exam.getName());
            imageView.setImageResource(R.drawable.dethi);
        }

        return convertView;
    }
}
