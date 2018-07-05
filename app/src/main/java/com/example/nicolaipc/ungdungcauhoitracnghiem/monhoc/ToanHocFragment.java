package com.example.nicolaipc.ungdungcauhoitracnghiem.monhoc;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nicolaipc.ungdungcauhoitracnghiem.chondethi.ChondethiFragment;
import com.example.nicolaipc.ungdungcauhoitracnghiem.MainActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.R;
import com.example.nicolaipc.ungdungcauhoitracnghiem.ontap.OntapNguVanActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.score.ScoreFragment;
import com.example.nicolaipc.ungdungcauhoitracnghiem.slide.ScreenSlideActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToanHocFragment extends Fragment {

    CharSequence nations[] = {"Đề số 1", "Đề số 2", "Đề số 3", "Đề số 4", "Đề số 5", "Đề số 6"};
    String selectedItem;

    Button btnontap, btnchondethi, btnthemcauhoi, btnxemdiem;
    public ToanHocFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Ngữ Văn");
        return inflater.inflate(R.layout.fragment_toan_hoc, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnontap = (Button) getActivity().findViewById(R.id.btnontap);
        btnchondethi = (Button) getActivity().findViewById(R.id.btnchondethi);
        btnthemcauhoi = (Button) getActivity().findViewById(R.id.btnthemcauhoi);
        btnxemdiem = (Button) getActivity().findViewById(R.id.btnxemdiem);

        btnchondethi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChondethiFragment chondethiFragment = new ChondethiFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, chondethiFragment, chondethiFragment.getTag()).commit();
            }
        });
        btnxemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreFragment scoreFragment = new ScoreFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, scoreFragment, scoreFragment.getTag()).commit();
            }
        });
        btnontap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OntapNguVanActivity.class);
                startActivity(intent);
            }
        });

    }
    public void showAlertDialogChondethi()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn đề thi");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setSingleChoiceItems(nations, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedItem = nations[which].toString();
            }
        });
        selectedItem="";
        builder.show();
    }
}
