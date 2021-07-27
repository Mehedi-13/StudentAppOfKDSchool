package com.example.userofkdschool.ebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userofkdschool.R;
import com.example.userofkdschool.ui.faculty.TeacherData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    private Context context;
    private List<EbookData> list;

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EbookAdapter.EbookViewHolder holder, int position) {

//        EbookData item = list.get(position);
//        holder.ebookName.setText(item.getPdfTitle());
        
        holder.ebookName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getPdfTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Download", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookDownload;

        public EbookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            ebookName=itemView.findViewById(R.id.ebookName);
            ebookDownload=itemView.findViewById(R.id.ebookDownload);
        }
    }
}
