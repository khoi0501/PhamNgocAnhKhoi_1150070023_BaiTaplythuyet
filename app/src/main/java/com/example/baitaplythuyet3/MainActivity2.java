package com.example.baitaplythuyet3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private EditText edtMssv, edtName, edtLop;
    private Button btnInsert, btnUpdate, btnDelete, btnQuery;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main); // layout bạn vừa gửi

        // Ánh xạ view
        edtMssv = findViewById(R.id.edtMssv);
        edtName = findViewById(R.id.edtName);
        edtLop = findViewById(R.id.edtLop);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnQuery = findViewById(R.id.btnQuery);
        recyclerView = findViewById(R.id.recyclerView);

        // Khởi tạo danh sách sinh viên
        students = new ArrayList<>();

        // Gắn adapter cho RecyclerView
        adapter = new StudentAdapter(this, students);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Xử lý nút Insert
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = edtMssv.getText().toString();
                String name = edtName.getText().toString();
                String lop = edtLop.getText().toString();

                students.add(new Student(mssv, name, lop));
                adapter.notifyDataSetChanged();
            }
        });

        // Xử lý nút Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = edtMssv.getText().toString();
                for (Student s : students) {
                    if (s.getMssv().equals(mssv)) {
                        s.setName(edtName.getText().toString());
                        s.setLop(edtLop.getText().toString());
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        // Xử lý nút Delete
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mssv = edtMssv.getText().toString();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getMssv().equals(mssv)) {
                        students.remove(i);
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        // Xử lý nút Query (ở đây mình chỉ hiển thị lại danh sách)
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
            }
        });
    }
}
