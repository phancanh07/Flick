package com.example.fickhd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fickhd.R;
import com.example.fickhd.model.Theme;
import com.example.fickhd.view.activity.ThemeActivity;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {

    List<Theme> titles;
    Context context;

    public ThemeAdapter(List<Theme> titles, Context context) {
        this.titles = titles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custem_adapter_gridview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(titles.get(position).getTheme_id());
        Glide.with(context).load(titles.get(position).getAvatarCard()).into(holder.gridIcon);
//        holder.gridIcon.setImageResource(titles.get(position).getAvatarCard());
      //  holder.gridIcon.setImageBitmap(ImageFactory.decodeSampledBitmapFromResource(context.getResources(), titles.get(position).getAvatarCard(), 300, 100));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView gridIcon;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gridIcon = itemView.findViewById(R.id.image_nguoidep2);
            textView = itemView.findViewById(R.id.id_them);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, ThemeActivity.class));
                }
            });
        }
    }
}