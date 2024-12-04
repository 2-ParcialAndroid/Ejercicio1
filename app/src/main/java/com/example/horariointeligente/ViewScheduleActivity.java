package com.example.horariointeligente;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewScheduleActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        db = openOrCreateDatabase("ScheduleDB", MODE_PRIVATE, null);

        findViewById(R.id.btn_view_day_schedule).setOnClickListener(v -> {
            EditText etDay = findViewById(R.id.et_day_query);
            TextView tvSchedule = findViewById(R.id.tv_schedule);

            String day = etDay.getText().toString();
            Cursor cursor = db.rawQuery("SELECT * FROM schedule WHERE day=?", new String[]{day});

            StringBuilder schedule = new StringBuilder();
            while (cursor.moveToNext()) {
                schedule.append(cursor.getString(0)).append(" - ").append(cursor.getString(2)).append("\n");
            }

            tvSchedule.setText(schedule.toString());
        });
    }
}
