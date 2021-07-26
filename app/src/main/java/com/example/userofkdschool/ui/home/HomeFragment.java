package com.example.userofkdschool.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.userofkdschool.R;
import com.example.userofkdschool.sliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

    private SliderView sliderView;
    int[] images= {
            R.drawable.mainroot,
            R.drawable.bigmainroot,
            R.drawable.asembli,
            R.drawable.tracher,
            R.drawable.paret,
            R.drawable.price,
            R.drawable.night,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        sliderView= view.findViewById(R.id.slider);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setScrollTimeInSec(1);
//
//
//        setSliderViews();
//
        sliderAdapter sliderAdapter =new sliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        return view;
    }

//    private void setSliderViews() {
//        for (int i=0; i<5;i++){
//
//            DefaultItemAnimator itemAnimator= new DefaultItemAnimator(getContext())
//        }
//    }
}