package com.example.baitaplythuyet3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<Student> students;
    private Context context;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_student, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student s = students.get(position);
        holder.txtName.setText(s.getMssv() + " - " + s.getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, StudentDetailActivity.class);
            intent.putExtra("mssv", s.getMssv());
            intent.putExtra("name", s.getName());
            intent.putExtra("lop", s.getLop());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_student);
        }
    }
}
