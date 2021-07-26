package com.example.userofkdschool.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.userofkdschool.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<TeacherData> list;
    private Context context;

    public TeacherAdapter(List<TeacherData> list, Context context, String category) {
        this.list = list;
        this.context = context;


    }

    @NonNull
    @NotNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeacherAdapter.TeacherViewAdapter holder, int position) {

        TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        holder.phoneNumber.setText(item.getPhoneNumber());
        holder.shift.setText(item.getShift());
        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.avater_profile).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, post, email, phoneNumber, shift;

        private ImageView image;

        public TeacherViewAdapter(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            post = itemView.findViewById(R.id.teacherPost);
            email = itemView.findViewById(R.id.teacherEmail);
            phoneNumber = itemView.findViewById(R.id.teacherPhoneNumber);
            shift = itemView.findViewById(R.id.teacherShift);
            image = itemView.findViewById(R.id.teacherImage);

        }
    }
}
