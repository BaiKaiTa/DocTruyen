package com.example.doctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doctruyen.database.databasedoctruyen;
import com.example.doctruyen.model.Truyen;

public class ManDangBai extends AppCompatActivity {

    EditText edtTenTruyen, edtNoiDung, edtAnh;
    Button btnDangBai;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh = findViewById(R.id.dbIMG);
        edtTenTruyen = findViewById(R.id.dbTenTruyen);
        edtNoiDung = findViewById(R.id.dbNoiDung);
        btnDangBai = findViewById(R.id.dbangBai);

        databasedoctruyen = new databasedoctruyen(this);
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentruyen = edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String IMG = edtAnh.getText().toString();

                Truyen truyen = CreateTruyen();

                if (tentruyen.equals("") || noidung.equals("") || IMG.equals("")){
                    Toast.makeText(ManDangBai.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("Error", "Nhập đầy đủ thông tin");
                }
                else{
                    databasedoctruyen.AddTruyen(truyen);

                    Intent intent = new Intent(ManDangBai.this,ManAdmin.class);
                    finish();
                    startActivity(intent);
                }
            }
        });


    }
    //tạo truyện
    private Truyen CreateTruyen(){
        String tentruyen = edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String IMG = edtAnh.getText().toString();

        Intent intent = getIntent();
        int id = intent.getIntExtra("Id", 0);

        Truyen truyen = new Truyen(tentruyen,noidung,IMG,id);
        return truyen;
    }
}