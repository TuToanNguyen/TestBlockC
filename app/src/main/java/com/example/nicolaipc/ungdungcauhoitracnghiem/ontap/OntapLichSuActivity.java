package com.example.nicolaipc.ungdungcauhoitracnghiem.ontap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.nicolaipc.ungdungcauhoitracnghiem.R;
import com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat.Database;

import java.util.ArrayList;

public class OntapLichSuActivity extends AppCompatActivity {
    private Database mydatabase;
    final String DATABASE_NAME = "dbtracnghiem2.sqlite";
    SQLiteDatabase database;

    Context context;
    ListView listView;
    ArrayList<Ontap> list;
    AdapterOnTap adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontap_lich_su);

        AddControl();
        readData();
    }
    public void AddControl()
    {
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterOnTap(this, list);
        listView.setAdapter(adapter);
    }
    private void readData() {
        String monhoc = "lichsu";
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM ontap WHERE mon ='"+monhoc+"' ", null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String mon = cursor.getString(1);
            String noidung = cursor.getString(2);
            String tieude = cursor.getString(3);

            list.add(new Ontap(id, mon, noidung, tieude));
        }
        adapter.notifyDataSetChanged();
    }
}
