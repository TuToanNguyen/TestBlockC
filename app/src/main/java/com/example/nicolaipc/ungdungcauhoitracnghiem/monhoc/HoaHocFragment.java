package com.example.nicolaipc.ungdungcauhoitracnghiem.monhoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nicolaipc.ungdungcauhoitracnghiem.MainActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.R;
import com.example.nicolaipc.ungdungcauhoitracnghiem.chondethi.ChondethiHHFragment;
import com.example.nicolaipc.ungdungcauhoitracnghiem.ontap.OntapDiaLyActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.ontap.OntapNguVanActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.score.ScoreFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HoaHocFragment extends Fragment {
    CharSequence nations[] = {"Đề số 1", "Đề số 2", "Đề số 3", "Đề số 4", "Đề số 5", "Đề số 6"};
    String selectedItem;

    Button btnontap, btnchondethi, btnthemcauhoi, btnxemdiem;

    public HoaHocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Địa Lý");
        return inflater.inflate(R.layout.fragment_hoa_hoc, container, false);
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
                ChondethiHHFragment chondethiHHFragment = new ChondethiHHFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, chondethiHHFragment, chondethiHHFragment.getTag()).commit();
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
                Intent intent = new Intent(getActivity(), OntapDiaLyActivity.class);
                startActivity(intent);
            }
        });
    }
}
