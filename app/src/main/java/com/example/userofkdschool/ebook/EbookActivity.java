package com.example.userofkdschool.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.userofkdschool.R;
import com.example.userofkdschool.ui.gallery.GalleryAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;
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
    private ShimmerFrameLayout shimmerFrameLayout,shimmerFrameLayout4,shimmerFrameLayout5,shimmerFrameLayout6,shimmerFrameLayout7,shimmerFrameLayout8,shimmerFrameLayout9,shimmerFrameLayout10;
    private LinearLayout linearLayout,shimalLayout4,shimalLayout5,shimalLayout6,shimalLayout7,shimalLayout8,shimalLayout9,shimalLayout10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);


    //Top interface show back icon & click to go userPage

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        linearLayout= findViewById(R.id.shimeerClassThree);
        shimalLayout4= findViewById(R.id.shimeerClass4);
        shimalLayout5= findViewById(R.id.shimeerClass5);
        shimalLayout6= findViewById(R.id.shimeerClass6);
        shimalLayout7= findViewById(R.id.shimeerClass7);
        shimalLayout8= findViewById(R.id.shimeerClass8);
        shimalLayout9= findViewById(R.id.shimeerClass9);
        shimalLayout10= findViewById(R.id.shimeerClass10);

        classThree=findViewById(R.id.classThree);
        classFour=findViewById(R.id.classFour);
        classFive=findViewById(R.id.classFive);
        classSix=findViewById(R.id.classSix);
        classSeven=findViewById(R.id.classSeven);
        classEight=findViewById(R.id.classEight);
        classNineTen=findViewById(R.id.classNineTen);
        otherPdfs=findViewById(R.id.otherPdfs);

        reference= FirebaseDatabase.getInstance().getReference().child("pdf");

        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        shimmerFrameLayout4=findViewById(R.id.shimmer_view_container4);
        shimmerFrameLayout5=findViewById(R.id.shimmer_view_container5);
        shimmerFrameLayout6=findViewById(R.id.shimmer_view_container6);
        shimmerFrameLayout7=findViewById(R.id.shimmer_view_container7);
        shimmerFrameLayout8=findViewById(R.id.shimmer_view_container8);
        shimmerFrameLayout9=findViewById(R.id.shimmer_view_container9);
        shimmerFrameLayout10=findViewById(R.id.shimmer_view_container10);


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


                shimmerFrameLayout.stopShimmer();
                linearLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
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

                shimmerFrameLayout4.stopShimmer();
                shimalLayout4.setVisibility(View.GONE);
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

                shimmerFrameLayout5.stopShimmer();
                shimalLayout5.setVisibility(View.GONE);
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

                shimmerFrameLayout6.stopShimmer();
                shimalLayout6.setVisibility(View.GONE);
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

                shimmerFrameLayout7.stopShimmer();
                shimalLayout7.setVisibility(View.GONE);
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

                shimmerFrameLayout8.stopShimmer();
                shimalLayout8.setVisibility(View.GONE);
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

                shimmerFrameLayout9.stopShimmer();
                shimalLayout9.setVisibility(View.GONE);
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

                shimmerFrameLayout10.stopShimmer();
                shimalLayout10.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }




}