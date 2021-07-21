package com.example.fickhd.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fickhd.R;
import com.example.fickhd.interfaces.GetUrlImage;
import com.example.fickhd.model.Photo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageDowloadAdapter extends PagerAdapter {
    private Context context;
    private List<Photo> photos;


    public ImageDowloadAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }


    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_pager, null);
        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.sdvImage);
        draweeView.setImageURI(photos.get(position).getUrlL());
//        Picasso.get()
//                .load(photos.get(position).getUrlL())
//                .into(imageView);
        ImageView dowload = (ImageView) view.findViewById(R.id.dowload);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view);
        return view;
    }

    @Override
    public int getItemPosition(@NonNull @NotNull Object object) {
        return super.getItemPosition(object);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
