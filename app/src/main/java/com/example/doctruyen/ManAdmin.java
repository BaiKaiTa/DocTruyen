package com.example.doctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doctruyen.adapter.adapterTruyen;
import com.example.doctruyen.database.databasedoctruyen;
import com.example.doctruyen.model.Truyen;

import java.util.ArrayList;

public class ManAdmin extends AppCompatActivity {

    ListView listView;
    Button buttonThem, btntrovett;

    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);

        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.btnThemTruyen);
        btntrovett = findViewById(R.id.btntrovett);

        btntrovett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intnList();

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                int id = intent1.getIntExtra("Id", 0);
                Intent intent = new Intent(ManAdmin.this,ManDangBai.class);
                intent.putExtra("Id", id);
                startActivity(intent);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DialogDelete(position);
                return false;
            }
        });
    }
    //hiển thị cửa số xoá
    private void DialogDelete(int position){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idtruyen = TruyenArrayList.get(position).getID();
                //xoá dữ liệu
                databasedoctruyen.Delete(idtruyen);
                //cập nhật lại activity
                Intent intent = new Intent(ManAdmin.this,ManAdmin.class);
                finish();
                startActivity(intent);
                Toast.makeText(ManAdmin.this, "Xoá truyện thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //gán dữ liệu cho listview
    private void intnList() {
        TruyenArrayList = new ArrayList<>();
        databasedoctruyen = new databasedoctruyen(this);
        Cursor cursor1 = databasedoctruyen.getData2();
        while (cursor1.moveToNext()){
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArrayList);
            listView.setAdapter(adapterTruyen);

        }
        cursor1.moveToFirst();
        cursor1.close();
    }
}