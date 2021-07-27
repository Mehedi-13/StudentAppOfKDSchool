package com.example.userofkdschool.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.userofkdschool.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BranchAdapter extends PagerAdapter {
    private Context context;
    private List<DepartmantModel> list;

    public BranchAdapter(Context context, List<DepartmantModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
       // return super.instantiateItem(container, position);

        View view= LayoutInflater.from(context).inflate(R.layout.dept_item_latout,container,false);

        ImageView depIcon;
        TextView depTitle, depDescription;

        depIcon= view.findViewById(R.id.com_logo);
        depTitle= view.findViewById(R.id.comTitle);
        depDescription= view.findViewById(R.id.comDescription);

        depIcon.setImageResource(list.get(position).getImg());
        depTitle.setText(list.get(position).getTitle());
        depDescription.setText(list.get(position).getDescription());

        container.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}
