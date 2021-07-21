package com.example.fickhd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fickhd.R;
import com.example.fickhd.interfaces.SendList;
import com.example.fickhd.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageApdapter extends RecyclerView.Adapter<ImageApdapter.ImageAdapterHoder> {
    private List<Photo> photoList;
    private Context context;
    private SendList sendList;


    public void setData(List<Photo> photos) {
        this.photoList = photos;
        notifyDataSetChanged();
    }


    public ImageApdapter(List<Photo> photoList, Context context, SendList sendList) {
        this.photoList = photoList;
        this.context = context;
        this.sendList = sendList;
    }

    @NonNull
    @Override
    public ImageAdapterHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout_adapter, parent, false);
        return new ImageApdapter.ImageAdapterHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterHoder holder, int position) {
        holder.textView.setText(photoList.get(position).getViews());
        Picasso.get().load(photoList.get(position).getUrlZ()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        if (photoList != null) {
            return photoList.size();
        }
        return 0;
    }

    public class ImageAdapterHoder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private CardView cardView;
        private TextView textView;

        public ImageAdapterHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.viewDowload);
            cardView = itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendList.listImage(photoList, getAdapterPosition());
                }
            });
        }
    }


}
