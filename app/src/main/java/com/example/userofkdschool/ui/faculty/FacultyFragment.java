package com.example.userofkdschool.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.userofkdschool.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView cDepartment,sDepartment,aDepartment;
    private LinearLayout cNoData,sNoData,aNoData;
    private List<TeacherData> list1,list2,list3;
    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);





        cDepartment=view.findViewById(R.id.cDepartment);
        sDepartment=view.findViewById(R.id.sDepartment);
        aDepartment=view.findViewById(R.id.aDepartment);

        cNoData=view.findViewById(R.id.cNoData);
        sNoData=view.findViewById(R.id.sNoData);
        aNoData=view.findViewById(R.id.aNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("Teacher");

        cDepartment();
        sDepartment();
        aDepartment();

        return view;


    }

    private void cDepartment() {
        dbRef= reference.child("Commerce");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                list2= new ArrayList<>();
                if (!snapshot.exists()){
                    cNoData.setVisibility(View.VISIBLE);
                    cDepartment.setVisibility(View.GONE);
                }else {
                    cNoData.setVisibility(View.GONE);
                    cDepartment.setVisibility(View. VISIBLE);

                    for (DataSnapshot snapshot1 :snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    cDepartment.setHasFixedSize(true);
                    cDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list2,getContext(),"Commerce");
                    adapter.notifyDataSetChanged();
                    cDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sDepartment() {
        dbRef= reference.child("Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                list1= new ArrayList<>();
                if (!snapshot.exists()){
                    sNoData.setVisibility(View.VISIBLE);
                    sDepartment.setVisibility(View.GONE);
                }else {
                    sNoData.setVisibility(View.GONE);
                    sDepartment.setVisibility(View. VISIBLE);

                    for (DataSnapshot snapshot1 :snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    sDepartment.setHasFixedSize(true);
                    sDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list1,getContext(),"Science");
                    adapter.notifyDataSetChanged();

                    sDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aDepartment() {
        dbRef= reference.child("Arts");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                list3= new ArrayList<>();
                if (!snapshot.exists()){
                    aNoData.setVisibility(View.VISIBLE);
                    aDepartment.setVisibility(View.GONE);
                }else {
                    aNoData.setVisibility(View.GONE);
                    aDepartment.setVisibility(View. VISIBLE);

                    for (DataSnapshot snapshot1 :snapshot.getChildren()){
                        TeacherData data= snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    aDepartment.setHasFixedSize(true);
                    aDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter= new TeacherAdapter(list3,getContext(),"Arts");
                    adapter.notifyDataSetChanged();

                    aDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}