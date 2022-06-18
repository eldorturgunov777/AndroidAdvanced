package com.example.androidadvanced.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidadvanced.R;

import java.util.Locale;

import timber.log.Timber;

public class FirstActivity extends AppCompatActivity {
    private Button btn_jp;
    private Button btn_kr;
    private Button btn_ru;
    private Button btn_uz;
    private Button btn_cn;
    private Button btn_check_first;
    private Button btn_check_second;
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

//        Timber.plant(new Timber.DebugTree());
        Timber.i("Timber logging is ready");
        btn_check_first = findViewById(R.id.btn_check_first);
        btn_check_second = findViewById(R.id.btn_check_second);

        Button btn_en = findViewById(R.id.btn_en);
        btn_en.setOnClickListener(view -> {
            setLocale("en");
            Timber.i("click english ");
        });
        btn_jp = findViewById(R.id.btn_jp);
        btn_jp.setOnClickListener(view -> {
            setLocale("ja");
            Timber.e("Error Message");
        });
        btn_kr = findViewById(R.id.btn_kr);
        btn_kr.setOnClickListener(view -> {
            setLocale("ko");
            Timber.d("Debug Message");
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

        btn_check_first.setOnClickListener(view -> {
            morphDoneAndRevert();
        });
        btn_check_second.setOnClickListener(view -> {

            Toast.makeText(this, "Yahooo", Toast.LENGTH_SHORT).show();

        });
    }

    void morphDoneAndRevert() {
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