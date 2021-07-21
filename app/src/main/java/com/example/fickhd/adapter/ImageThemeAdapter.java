package com.example.fickhd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fickhd.R;
import com.example.fickhd.model.Avatar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageThemeAdapter extends RecyclerView.Adapter<ImageThemeAdapter.ViewHolder> {
    private Context context;
    private List<Avatar> avatarList;

    public ImageThemeAdapter(Context context, List<Avatar> avatarList) {
        this.context = context;
        this.avatarList = avatarList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custem_adapter_avatar, parent, false);
        return new ImageThemeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Glide.with(context).load(avatarList.get(position).getUrlAvatar()).into(holder.imageView);
        holder.textView.setText(avatarList.get(position).getNameAvatar());
    }

    @Override
    public int getItemCount() {
        if (avatarList != null) {
            return avatarList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_avatar);
            textView = itemView.findViewById(R.id.image_avatar_name);
        }
    }
}
