package com.example.baitaplythuyet3;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    // Constructor rỗng (bắt buộc cho SQLite)
    public Contact() {
    }

    // Constructor khi thêm contact mới (không cần id vì SQLite tự sinh)
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Constructor đầy đủ (dùng khi lấy dữ liệu từ DB)
    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
