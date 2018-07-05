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
import com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat.Main2Activity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.question.SearchQuesFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button toan, vatly, hoahoc, timkiem, themcauhoi;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Trang chủ");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toan = (Button) getActivity().findViewById(R.id.toan);
        vatly = (Button) getActivity().findViewById(R.id.vatly);
        hoahoc = (Button) getActivity().findViewById(R.id.hoahoc);
        themcauhoi = (Button) getActivity().findViewById(R.id.themcauhoi);
        timkiem = (Button) getActivity().findViewById(R.id.timkiem);




        toan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToanHocFragment toanHocFragment = new ToanHocFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, toanHocFragment, toanHocFragment.getTag()).commit();
            }
        });
        vatly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatLyFragment vatLyFragment = new VatLyFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, vatLyFragment, vatLyFragment.getTag()).commit();
            }
        });
        hoahoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoaHocFragment hoaHocFragment = new HoaHocFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, hoaHocFragment, hoaHocFragment.getTag()).commit();
            }
        });
        themcauhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });
        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchQuesFragment searchQuesFragment = new SearchQuesFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content, searchQuesFragment, searchQuesFragment.getTag()).commit();
            }
        });
    }
}
