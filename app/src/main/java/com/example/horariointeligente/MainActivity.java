package com.example.horariointeligente;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_class).setOnClickListener(v -> {
            startActivity(new Intent(this, AddClassActivity.class));
        });

        findViewById(R.id.btn_view_schedule).setOnClickListener(v -> {
            startActivity(new Intent(this, ViewScheduleActivity.class));
        });

        findViewById(R.id.btn_current_class).setOnClickListener(v -> {
            startActivity(new Intent(this, CurrentClassActivity.class));
        });
    }
}
