package com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.nicolaipc.ungdungcauhoitracnghiem.MainActivity;
import com.example.nicolaipc.ungdungcauhoitracnghiem.R;
import com.example.nicolaipc.ungdungcauhoitracnghiem.chucnangphu.NhaphattrienFragment;
import com.example.nicolaipc.ungdungcauhoitracnghiem.monhoc.HomeFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private EditText nhapid, nhapcauhoi, nhapA, nhapB, nhapC, nhapD;
    private Spinner dapandung, sode, tenmon;
    private Button btnThem, btnHuy;
    private Database mydatabase;
    final String DATABASE_NAME = "dbtracnghiem2.sqlite";
    SQLiteDatabase database;


    Context context;
    ListView listView;
    ArrayList<Tracnghiem> list;
    AdapterTracNghiem adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydatabase = new Database();
        addConTrols();
        readData();
    }
    private void addConTrols() {
        btnThem = (Button) findViewById(R.id.btnThem);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
//                HomeFragment homeFragment = new HomeFragment();
//                FragmentManager manager = getSupportFragmentManager();
//                manager.beginTransaction().replace(R.id.content, homeFragment, homeFragment.getTag()).commit();
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterTracNghiem(this, list);
        listView.setAdapter(adapter);
    }

    private void readData() {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM tracnghiem WHERE num_exam ='"+6+"' ", null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int _id = cursor.getInt(0);
            String question = cursor.getString(1);
            String ans_a = cursor.getString(2);
            String ans_b = cursor.getString(3);
            String ans_c = cursor.getString(4);
            String ans_d = cursor.getString(5);
            String result = cursor.getString(6);
            int num_exam = cursor.getInt(7);
            String subject = cursor.getString(8);
            String image = cursor.getString(9);

            list.add(new Tracnghiem(_id, question, ans_a, ans_b, ans_c, ans_d, result, num_exam, subject, image));
        }
        adapter.notifyDataSetChanged();
    }


}
