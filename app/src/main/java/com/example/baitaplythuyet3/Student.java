package com.example.baitaplythuyet3;

public class Student {
    private String mssv;
    private String name;
    private String lop;

    public Student(String mssv, String name, String lop) {
        this.mssv = mssv;
        this.name = name;
        this.lop = lop;
    }

    public String getMssv() { return mssv; }
    public String getName() { return name; }
    public String getLop() { return lop; }

    public void setMssv(String mssv) { this.mssv = mssv; }
    public void setName(String name) { this.name = name; }
    public void setLop(String lop) { this.lop = lop; }
}
