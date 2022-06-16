package com.example.androidadvanced.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidadvanced.R;

import java.util.Locale;

public class FirstActivity extends AppCompatActivity {
    private Button btn_jp;
    private Button btn_kr;
    private Button btn_ru;
    private Button btn_uz;
    private Button btn_cn;
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn_en = findViewById(R.id.btn_en);
        btn_en.setOnClickListener(view -> {
            setLocale("en");
        });
        btn_jp = findViewById(R.id.btn_jp);
        btn_jp.setOnClickListener(view -> {
            setLocale("ja");
        });
        btn_kr = findViewById(R.id.btn_kr);
        btn_kr.setOnClickListener(view -> {
            setLocale("ko");
        });
        btn_ru = findViewById(R.id.btn_ru);
        btn_ru.setOnClickListener(view -> {
            setLocale("ru");
        });
        btn_uz = findViewById(R.id.btn_uz);
        btn_uz.setOnClickListener(view -> {
            setLocale("uz");
        });
        btn_cn = findViewById(R.id.btn_cn);
        btn_cn.setOnClickListener(view -> {
            setLocale("zh");
        });
        tv_desc = findViewById(R.id.tv_desc);
    }

    private void setLocale(String lan) {
        Locale locale = new Locale(lan);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        finish();
    }

}