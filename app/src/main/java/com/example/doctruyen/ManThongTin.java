package com.example.doctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManThongTin extends AppCompatActivity {

    TextView txtThongtinapp;
    Button btntrovett;

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

        btntrovett = findViewById(R.id.btntrovett);
        btntrovett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}