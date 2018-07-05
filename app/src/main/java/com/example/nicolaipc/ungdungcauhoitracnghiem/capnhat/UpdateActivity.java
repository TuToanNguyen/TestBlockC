package com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicolaipc.ungdungcauhoitracnghiem.R;

public class UpdateActivity extends AppCompatActivity {

    TextView nhapid;
    EditText nhapcauhoi, nhapA, nhapB, nhapC, nhapD;
    Spinner dapandung, sode, tenmon;
    Button btnThoat, btnLuu;

    final String DATABASE_NAME = "dbtracnghiem2.sqlite";

    int _id = -1;

    String arr[] = {"A", "B", "C", "D"};
    TextView selection;

    String arr2[] = {"6"};

    String arr3[] = {"nguvan", "dialy", "lichsu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        LoadDapAn();
        LoadDe();
        LoadMonHoc();
        addControls();
        initUI();
    }
    private void update() {
        String question = nhapcauhoi.getText().toString();
        String ans_a = nhapA.getText().toString();
        String ans_b = nhapB.getText().toString();
        String ans_c = nhapC.getText().toString();
        String ans_d = nhapD.getText().toString();

        String result = dapandung.getSelectedItem().toString();

        String num_exam = sode.getSelectedItem().toString();

        String subject = tenmon.getSelectedItem().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("question", question);
        contentValues.put("ans_a", ans_a);
        contentValues.put("ans_b", ans_b);
        contentValues.put("ans_c", ans_c);
        contentValues.put("ans_d", ans_d);
        contentValues.put("result", result);
        contentValues.put("num_exam", num_exam);
        contentValues.put("subject", subject);

        SQLiteDatabase database = Database.initDatabase(this, "dbtracnghiem2.sqlite");
        database.update("tracnghiem", contentValues, "_id = ?", new String[]{_id + ""});

        Toast.makeText(this,"Update thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    public void addControls() {
        nhapid = (TextView) findViewById(R.id.nhapid);
        nhapcauhoi = (EditText) findViewById(R.id.nhapcauhoi);
        nhapA = (EditText) findViewById(R.id.nhapA);
        nhapB = (EditText) findViewById(R.id.nhapB);
        nhapC = (EditText) findViewById(R.id.nhapC);
        nhapD = (EditText) findViewById(R.id.nhapD);
        dapandung = (Spinner) findViewById(R.id.dapandung);
        sode = (Spinner) findViewById(R.id.sode);
        tenmon = (Spinner) findViewById(R.id.tenmon);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnLuu = (Button) findViewById(R.id.btnLuu);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void initUI() {
        Intent intent = getIntent();
        _id = intent.getIntExtra("ID", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM tracnghiem WHERE _id = ?", new String[]{_id + ""});
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String question = cursor.getString(1);
        String ans_a = cursor.getString(2);
        String ans_b = cursor.getString(3);
        String ans_c = cursor.getString(4);
        String ans_d = cursor.getString(5);
        String result = cursor.getString(6);

        int num_exam = cursor.getInt(7);

        String subject = cursor.getString(8);
        //String image = cursor.getString(9);

        nhapid.setText(id);
        nhapcauhoi.setText(question);
        nhapA.setText(ans_a);
        nhapB.setText(ans_b);
        nhapC.setText(ans_c);
        nhapD.setText(ans_d);

        setSpinText(dapandung, result);

        setSpinText(tenmon, subject);

        setSpinText(sode, String.valueOf(num_exam));


    }

    public void setSpinText(Spinner spin, String text) {
        for (int i = 0; i < spin.getAdapter().getCount(); i++) {
            if (spin.getAdapter().getItem(i).toString().contains(text)) {
                spin.setSelection(i);
            }
        }

    }

    public void LoadDapAn() {
        selection = (TextView) findViewById(R.id.selection);
        //Lấy đối tượng Spinner ra
        Spinner spin = (Spinner) findViewById(R.id.dapandung);
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spin.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spin.setOnItemSelectedListener(new MyProcessEvent());
    }

    //Class tạo sự kiện
    private class MyProcessEvent implements AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //arg2 là phần tử được chọn trong data source
            //selection.setText(arr[arg2]);
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }

    public void LoadDe() {
        selection = (TextView) findViewById(R.id.selection);
        //Lấy đối tượng Spinner ra
        Spinner spin2 = (Spinner) findViewById(R.id.sode);
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr2);
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spin2.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spin2.setOnItemSelectedListener(new MyProcessEvent1());
    }

    //Class tạo sự kiện
    private class MyProcessEvent1 implements AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //arg2 là phần tử được chọn trong data source
            //selection.setText(arr[arg2]);
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }

    public void LoadMonHoc() {
        selection = (TextView) findViewById(R.id.selection);
        //Lấy đối tượng Spinner ra
        Spinner spin2 = (Spinner) findViewById(R.id.tenmon);
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr3);
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spin2.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spin2.setOnItemSelectedListener(new MyProcessEvent3());
    }

    //Class tạo sự kiện
    private class MyProcessEvent3 implements AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //arg2 là phần tử được chọn trong data source
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }

}
