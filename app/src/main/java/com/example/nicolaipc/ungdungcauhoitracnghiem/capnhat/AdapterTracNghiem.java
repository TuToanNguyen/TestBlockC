package com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolaipc.ungdungcauhoitracnghiem.R;

import java.util.ArrayList;

public class AdapterTracNghiem extends BaseAdapter {

    Context context;
    ArrayList<Tracnghiem> list;

    public AdapterTracNghiem(Context context, ArrayList<Tracnghiem> list) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.adapter_tracnghiem, null);
        ImageView imgHinhDaiDien = (ImageView) row.findViewById(R.id.imgHinhDaiDien);
        TextView txtCauhoi = (TextView) row.findViewById(R.id.txtId);
        TextView txtId = (TextView) row.findViewById(R.id.txtCauhoi);
        TextView txtA = (TextView) row.findViewById(R.id.txtA);
        TextView txtB = (TextView) row.findViewById(R.id.txtB);
        TextView txtC = (TextView) row.findViewById(R.id.txtC);
        TextView txtD = (TextView) row.findViewById(R.id.txtD);
        TextView txtDapan = (TextView) row.findViewById(R.id.txtDapan);
        TextView txtSode = (TextView) row.findViewById(R.id.txtSode);
        TextView txtMonhoc = (TextView) row.findViewById(R.id.txtMonhoc);
        Button btnXoa = (Button) row.findViewById(R.id.btnXoa);
        Button btnSua = (Button) row.findViewById(R.id.btnHuy);

        final Tracnghiem tracnghiem = list.get(position);
        txtId.setText(tracnghiem._id + "");
        txtCauhoi.setText(tracnghiem.question);
        txtA.setText(tracnghiem.ans_a);
        txtB.setText(tracnghiem.ans_b);
        txtC.setText(tracnghiem.ans_c);
        txtD.setText(tracnghiem.ans_d);
        txtDapan.setText(tracnghiem.result);
        txtSode.setText(tracnghiem.num_exam + "");
        txtMonhoc.setText(tracnghiem.subject);

//        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(tracnghiem.image, 0, tracnghiem.image.length);
//        imgHinhDaiDien.setImageBitmap(bmHinhDaiDien);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("ID", tracnghiem._id);
                context.startActivity(intent);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Xác nhận xóa!");
                builder.setMessage("Bạn có chắn muốn xóa?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete(tracnghiem._id);
                    }
                });
                builder.setNeutralButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return row;
    }
    private void delete(int _id)
    {
        SQLiteDatabase database = Database.initDatabase(context  , "dbtracnghiem2.sqlite");
        database.delete("tracnghiem", "_id = ?", new String[]{_id + ""});
        list.clear();

        Cursor cursor = database.rawQuery("SELECT * FROM tracnghiem WHERE num_exam ='"+6+"'", null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String question = cursor.getString(1);
            String ans_a = cursor.getString(2);
            String ans_b = cursor.getString(3);
            String ans_c = cursor.getString(4);
            String ans_d = cursor.getString(5);
            String result = cursor.getString(6);

            int num_exam = cursor.getInt(7);

            String subject = cursor.getString(8);
            String image = cursor.getString(9);
            //byte[] anh = cursor.getBlob(3);

            list.add(new Tracnghiem( id, question, ans_a, ans_b, ans_c,ans_d, result, num_exam, subject, image ) );

        }
        notifyDataSetChanged();

    }
}
