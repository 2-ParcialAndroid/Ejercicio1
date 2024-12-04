package com.example.horariointeligente;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddClassActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        db = openOrCreateDatabase("ScheduleDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS schedule(subject TEXT, day TEXT, time TEXT)");

        findViewById(R.id.btn_save_class).setOnClickListener(v -> {
            EditText etSubject = findViewById(R.id.et_subject_name);
            EditText etDay = findViewById(R.id.et_day);
            EditText etTime = findViewById(R.id.et_time);

            String subject = etSubject.getText().toString();
            String day = etDay.getText().toString();
            String time = etTime.getText().toString();

            db.execSQL("INSERT INTO schedule VALUES(?, ?, ?)", new Object[]{subject, day, time});
            Toast.makeText(this, "Clase añadida", Toast.LENGTH_SHORT).show();
        });
    }
}
