package com.example.horariointeligente;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class CurrentClassActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_class);

        db = openOrCreateDatabase("ScheduleDB", MODE_PRIVATE, null);
        TextView tvCurrentClass = findViewById(R.id.tv_current_class);

        Calendar calendar = Calendar.getInstance();
        String day = new SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.getTime());
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.getTime());

        Cursor cursor = db.rawQuery("SELECT * FROM schedule WHERE day=? AND time=?", new String[]{day, currentTime});

        if (cursor.moveToNext()) {
            tvCurrentClass.setText("Estás en clase de: " + cursor.getString(0));
        } else {
            tvCurrentClass.setText("No hay clases ahora.");
        }
    }
}
