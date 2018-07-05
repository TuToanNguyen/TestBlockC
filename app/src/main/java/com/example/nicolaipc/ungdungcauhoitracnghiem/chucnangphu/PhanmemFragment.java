package com.example.nicolaipc.ungdungcauhoitracnghiem.chucnangphu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicolaipc.ungdungcauhoitracnghiem.MainActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhanmemFragment extends Fragment {


    public PhanmemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Giới thiệu");
        return inflater.inflate(R.layout.fragment_phanmem, container, false);
    }

}
