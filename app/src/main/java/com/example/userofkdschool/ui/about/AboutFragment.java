package com.example.userofkdschool.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.userofkdschool.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

private ViewPager viewPager;
private BranchAdapter adapter;
private List<DepartmantModel> list;
    private ImageView map1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);

        list= new ArrayList<>();
        list.add(new DepartmantModel(R.drawable.statistics,"Commerce","In our institution, the subject of  COMMERCE has been taught since 1900. Here our students are very talented and our teachers are also very skilled. Another important thing is that the mental development of the students is growing in a beautiful way from a young age. As a result, our institution is doing well with good reputation in Rajshahi Board of Education."));
        list.add(new DepartmantModel(R.drawable.chemistry,"Science","In our institution, the subject of  SCIENCE has been taught since 1900. Here our students are very talented and our teachers are also very skilled. Another important thing is that the mental development of the students is growing in a beautiful way from a young age. As a result, our institution is doing well with good reputation in Rajshahi Board of Education."));
        list.add(new DepartmantModel(R.drawable.homework,"Arts","In our institution, the subject of  ARTS has been taught since 1900. Here our students are very talented and our teachers are also very skilled. Another important thing is that the mental development of the students is growing in a beautiful way from a young age. As a result, our institution is doing well with good reputation in Rajshahi Board of Education."));

        adapter= new BranchAdapter(getContext(),list);
        viewPager=view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView= view.findViewById(R.id.school_Image);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/admin-s-of-kd-school.appspot.com/o/kdschool.jpg?alt=media&token=4e6b8ad7-c29e-4b5d-ac07-87b57da65419")
                .into(imageView);

        map1= view.findViewById(R.id.map1);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        return view;
    }

    private void openMap() {

        Uri uri= Uri.parse("geo:0, 0?q=Naogaon KD Govt High School");

        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}