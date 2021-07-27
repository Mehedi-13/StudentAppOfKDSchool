package com.example.userofkdschool.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class GalleryFragment extends Fragment {
    private RecyclerView foundationRecycler,sportsRecycler,culturalRecycler,priceRecycler,independentRecycler,
            mournRecycler,admissionRecycler,otherEventsRecycler;

    private GalleryAdapter adapter;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        foundationRecycler=view.findViewById(R.id.foundationDay);
        sportsRecycler=view.findViewById(R.id.sportsDay);
        culturalRecycler=view.findViewById(R.id.culturalDay);
        priceRecycler=view.findViewById(R.id.prizeGivenCeremony);
        independentRecycler=view.findViewById(R.id.independentDay);
        mournRecycler=view.findViewById(R.id.mourn);
        admissionRecycler=view.findViewById(R.id.admissionDay);
        otherEventsRecycler=view.findViewById(R.id.otherEvents);

        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        
        getfoundation();

        getSports();
        getCultural();
        getPrize();
        getIndependent();
        getMourn();
        getAdmission();

        getOtherEvents();



        return view;
    }


    private void getSports() {
        reference.child("Sports Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        String data= (String) snapshot1.getValue();
                        imageList.add(data);
                    }

                    adapter= new GalleryAdapter(getContext(),imageList);
                    sportsRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                    sportsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOtherEvents() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                otherEventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                otherEventsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getfoundation() {
        reference.child("Foundation Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                foundationRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                foundationRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCultural() {
        reference.child("Cultural Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                culturalRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                culturalRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPrize() {
        reference.child("Prize Given Ceremony").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                priceRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                priceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndependent() {
        reference.child("Independent Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                independentRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                independentRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMourn() {
        reference.child("Mourn").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                mournRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                mournRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAdmission() {
        reference.child("Admission Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter= new GalleryAdapter(getContext(),imageList);
                admissionRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                admissionRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}