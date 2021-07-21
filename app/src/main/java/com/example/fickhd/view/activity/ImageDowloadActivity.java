package com.example.fickhd.view.activity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.example.fickhd.R;
import com.example.fickhd.adapter.ImageDowloadAdapter;
import com.example.fickhd.interfaces.GetUrlImage;
import com.example.fickhd.model.Photo;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ImageDowloadActivity extends AppCompatActivity {

    private static final int CODE = 123;
    Gson gson;
    private ImageView imageView;
    private FloatingActionButton acButon;
    private ViewPager viewPager;
    private List<Photo> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        gson = new Gson();
        setContentView(R.layout.activity_image_dowload);
        viewPager = findViewById(R.id.viewPager);
        acButon = findViewById(R.id.floating_action);
        Type list = new TypeToken<List<Photo>>() {
        }.getType();
        Bundle bundle = getIntent().getExtras();
        String Url = bundle.getString("KEY_JSON");
        int vitri = bundle.getInt("KEY_ID");
        photoList = gson.fromJson(Url, list);
        if (bundle != null) {
            ImageDowloadAdapter adapter = new ImageDowloadAdapter(this, photoList);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(vitri);
        }
        acButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
            }
        });

    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                String[] permistion = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permistion, CODE);
            } else {
                startDowloadImage();
            }
        } else {
            startDowloadImage();
        }
    }

    private void startDowloadImage() {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(photoList.get(viewPager.getCurrentItem()).getUrlL()));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setTitle("Dowload ");
        request.setDescription("Dowload File....");
        request.setDestinationInExternalPublicDir(String.valueOf(getExternalFilesDir(Environment.DIRECTORY_PICTURES)), "wallpaper" + System.currentTimeMillis() + ".png");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if (downloadManager != null) {
            downloadManager.enqueue(request);

        }
    }

}