package com.example.fickhd.view.activity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fickhd.R;
import com.example.fickhd.adapter.ImageThemeAdapter;
import com.example.fickhd.model.Avatar;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.jpardogo.android.googleprogressbar.library.NexusRotationCrossDrawable;

import java.util.ArrayList;
import java.util.List;

public class ThemeActivity extends AppCompatActivity {
    private FirebaseStorage storage;
    private StorageReference storageRef;

    private List<Avatar> avatarList ;
    private ImageThemeAdapter imageThemeAdapter;
    private RecyclerView recyclerView;
    int i = 1;
    private ProgressBar progressBar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        getInitUI();
        getInitFireBase("N02400");

        StorageReference imagesRef = storage.getReference();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        Log.d("TAG", storageReference.getName());


    }

    private void getInitUI() {
        recyclerView = findViewById(R.id.theme_avatar);
        progressBar = findViewById(R.id.progessbar_theme);
        progressBar.setIndeterminateDrawable(new NexusRotationCrossDrawable.Builder(getApplicationContext())
                .build());
    }

    private void getInitFireBase(String childForder) {
        avatarList = new ArrayList<>();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        Log.d("HH", storage.getReference().getStream().toString());
        StorageReference listRef = storage.getReference().child("Animal");
        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    StorageReference imagesReff = storageRef.child("Animal").child(item.getName());
                    imagesReff.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Avatar avatar = new Avatar();
                            avatar.setNameAvatar(item.getName());
                            avatar.setUrlAvatar(uri.toString());
                            avatarList.add(avatar);
                            progressBar.setVisibility(View.GONE);
                            getDataList(avatarList);
                        }
                    });
                }
            }
        });
    }

    private void getDataList(List<Avatar> avatarList) {
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
        imageThemeAdapter = new ImageThemeAdapter(getApplicationContext(), avatarList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(imageThemeAdapter);
        progressBar.setVisibility(View.GONE);
    }


}