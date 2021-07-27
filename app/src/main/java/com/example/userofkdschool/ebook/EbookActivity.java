package com.example.userofkdschool.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.userofkdschool.R;
import com.example.userofkdschool.ui.gallery.GalleryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView classThree,classFour,classFive,classSix,classSeven,
            classEight,classNineTen,otherPdfs;

    private EbookAdapter adapter;
    private List<EbookData> list;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        classThree=findViewById(R.id.classThree);
        classFour=findViewById(R.id.classFour);
        classFive=findViewById(R.id.classFive);
        classSix=findViewById(R.id.classSix);
        classSeven=findViewById(R.id.classSeven);
        classEight=findViewById(R.id.classEight);
        classNineTen=findViewById(R.id.classNineTen);
        otherPdfs=findViewById(R.id.otherPdfs);

        reference= FirebaseDatabase.getInstance().getReference().child("pdf");

        getClassThree();
        getClassFour();
        getClassFive();
        getClassSix();
        getClassSeven();
        getClassEight();
        getClassNineTen();
        getOtherPdfs();
    }


    private void getClassThree() {
        reference.child("Class Three").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classThree.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classThree.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassFour() {
        reference.child("Class Four").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classFour.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classFour.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassFive() {
        reference.child("Class Five").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classFive.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classFive.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassSix() {
        reference.child("Class Six").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classSix.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classSix.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassSeven() {
        reference.child("Class Seven").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classSeven.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classSeven.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassEight() {
        reference.child("Class Eight").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classEight.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classEight.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getClassNineTen() {
        reference.child("Class Nine & Ten").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                classNineTen.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                classNineTen.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getOtherPdfs() {
        reference.child("Other PDFs").addValueEventListener(new ValueEventListener() {

            List<EbookData> list = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    EbookData data= snapshot1.getValue(EbookData.class);
                    list.add(data);
                }

                adapter= new EbookAdapter(EbookActivity.this,list);
                otherPdfs.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                otherPdfs.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }




}