package com.example.baitaplythuyet3;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    private static final String TAG = "StudentDetailAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // dùng layout detail chính xác
        setContentView(R.layout.activity_student);

        TextView txtDetail = findViewById(R.id.txtDetail);
        if (txtDetail == null) {
            Log.e(TAG, "txtDetail == null -> kiểm tra activity_student_detail.xml");
            return;
        }

        String mssv = getIntent().getStringExtra("mssv");
        String name = getIntent().getStringExtra("name");
        String lop  = getIntent().getStringExtra("lop");

        if (mssv == null) mssv = "";
        if (name == null) name = "";
        if (lop == null)  lop = "";

        txtDetail.setText("MSSV: " + mssv + "\nHọ tên: " + name + "\nLớp: " + lop);
    }
}
