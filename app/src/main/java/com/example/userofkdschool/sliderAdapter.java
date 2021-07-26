package com.example.userofkdschool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class sliderAdapter extends SliderViewAdapter<sliderAdapter.Holder> {

    int[] images;

    public sliderAdapter(int[] images){

        this.images=images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{

      private   ImageView imageView;

        public Holder(View itemView) {
            super(itemView);

            imageView=itemView. findViewById(R.id.image_view);

        }
    }


}
