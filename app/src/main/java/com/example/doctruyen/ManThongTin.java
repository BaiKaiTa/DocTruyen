package com.example.doctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ManThongTin extends AppCompatActivity {

    TextView txtThongtinapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_tin);

        txtThongtinapp = findViewById(R.id.textviewThongTin);
        String thongtin = "App làm bởi nhóm 6 \n" +
                "Trung FullStack\n" +
                "Hào FontEnd\n" +
                "Thanh Báo Cáo";
        txtThongtinapp.setText(thongtin);
    }
}