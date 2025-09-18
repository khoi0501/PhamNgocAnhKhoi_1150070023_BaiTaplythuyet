package com.example.baitaplythuyet3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler db;
    ListView lv;
    ArrayAdapter<String> adapter;
    List<Contact> contacts;
    ArrayList<String> contactNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv_contacts);
        db = new DatabaseHandler(this);

        // 🔹 Chỉ thêm dữ liệu mẫu khi bảng rỗng
        if (db.getAllContacts().isEmpty()) {
            addSampleContact("Pham Ngoc Anh Khôi", "1150070023");
            addSampleContact("Jimmy", "1150070024");
            addSampleContact("Tomm", "1150070025");
            addSampleContact("Chris", "1150070026");
        }

        // Hiển thị dữ liệu lần đầu
        loadContacts();

        // Xóa contact khi nhấn giữ (long click)
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contacts.get(position);
                db.deleteContact(contact.getID());
                loadContacts();
                return true;
            }
        });
    }

    // Hàm chỉ thêm contact nếu chưa có số điện thoại đó
    private void addSampleContact(String name, String phone) {
        Contact c = db.getContactByPhone(phone);
        if (c == null) {
            db.addContact(new Contact(name, phone));
        }
    }

    private void loadContacts() {
        contacts = db.getAllContacts();
        contactNames = new ArrayList<>();

        for (Contact c : db.getAllContacts()) {
            contactNames.add(c.getID() + " - " + c.getName() + " - " + c.getPhoneNumber());
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactNames);
        lv.setAdapter(adapter);
    }
}
