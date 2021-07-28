package com.example.userofkdschool.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.userofkdschool.R;
import com.facebook.shimmer.ShimmerFrameLayout;
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

    private ShimmerFrameLayout shimmerFrameLayout1,shimmerFrameLayout2,shimmerFrameLayout3,shimmerFrameLayout4,shimmerFrameLayout5,shimmerFrameLayout6,shimmerFrameLayout7,shimmerFrameLayout8;
    private LinearLayout shimerLayout1,shimerLayout2,shimerLayout3,shimerLayout4,shimerLayout5,shimerLayout6,shimerLayout7,shimerLayout8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);


        shimmerFrameLayout1=view.findViewById(R.id.shimmer_view_container1);
        shimmerFrameLayout2=view.findViewById(R.id.shimmer_view_container2);
        shimmerFrameLayout3=view.findViewById(R.id.shimmer_view_container3);
        shimmerFrameLayout4=view.findViewById(R.id.shimmer_view_container4);
        shimmerFrameLayout5=view.findViewById(R.id.shimmer_view_container5);
        shimmerFrameLayout6=view.findViewById(R.id.shimmer_view_container6);
        shimmerFrameLayout7=view.findViewById(R.id.shimmer_view_container7);
        shimmerFrameLayout8=view.findViewById(R.id.shimmer_view_container8);

        shimerLayout1=view.findViewById(R.id.shimeer1);
        shimerLayout2=view.findViewById(R.id.shimeer2);
        shimerLayout3=view.findViewById(R.id.shimeer3);
        shimerLayout4=view.findViewById(R.id.shimeer4);
        shimerLayout5=view.findViewById(R.id.shimeer5);
        shimerLayout6=view.findViewById(R.id.shimeer6);
        shimerLayout7=view.findViewById(R.id.shimeer7);
        shimerLayout8=view.findViewById(R.id.shimeer8);

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
                shimmerFrameLayout2.stopShimmer();
                shimerLayout2.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onPause() {
        shimmerFrameLayout1.stopShimmer();
        super.onPause();
    }

    @Override
    public void onResume() {
        shimmerFrameLayout1.startShimmer();
        super.onResume();
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
                shimmerFrameLayout8.stopShimmer();
                shimerLayout8.setVisibility(View.GONE);
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

                shimmerFrameLayout1.stopShimmer();
                shimerLayout1.setVisibility(View.GONE);

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

                shimmerFrameLayout3.stopShimmer();
                shimerLayout3.setVisibility(View.GONE);
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

                shimmerFrameLayout4.stopShimmer();
                shimerLayout4.setVisibility(View.GONE);
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

                shimmerFrameLayout5.stopShimmer();
                shimerLayout5.setVisibility(View.GONE);
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

                shimmerFrameLayout6.stopShimmer();
                shimerLayout6.setVisibility(View.GONE);
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

                shimmerFrameLayout7.stopShimmer();
                shimerLayout7.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}